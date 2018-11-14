// Postfix Calculator Applet
//
// CS 201 HW 8  -  Skeleton

// Benjamin Allan-Rahill

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*; // for Stack

public class Calc extends Applet implements ActionListener {

    private static final long serialVersionUID = 1L; // to avoid Eclipse warning

    // instance variables

    protected Label result;         // label used to show result
    protected Stack<Integer> stack; // stack used for calculations
    protected int current;          // current number being entered
    protected boolean entered;      // whether current number has been entered
                                    // if so, show number in red

    // local color constants
    static final Color black = Color.black;
    static final Color white = Color.white;
    static final Color red = Color.red;
    static final Color blue = Color.blue;
    static final Color yellow = Color.yellow;
    static final Color orange = Color.orange;
    static final Color lblue = new Color(200, 220, 255);
    static final Color dred = new Color(160, 0, 100);
    static final Color dgreen = new Color(0, 120, 90);
    static final Color dblue = Color.blue.darker();

    public void init() {
        this.setFont(new Font("TimesRoman", Font.BOLD, 28));

        this.setLayout(new BorderLayout());
        this.add("North", makeResultPanel());
        this.add("Center", makeNumberPanel());
        this.add("South", makeEnterPanel());

        this.setBackground(dblue);

        stack = new Stack<Integer>(); // initialize stack
    }

    // helper method to set up result panel
    public Panel makeResultPanel(){
        Panel resultPanel = new Panel();
        resultPanel.setLayout(new BorderLayout());
        result = new Label("0");
        result.setAlignment(Label.RIGHT);
        result.setBackground(white);
        resultPanel.add("Center", result);
        resultPanel.add("West", CLabel("", white, dblue));
        resultPanel.add("North", CLabel("", white, dblue));
        resultPanel.add("East", CLabel("", white, dblue));
        resultPanel.add("South", CLabel("", white, dblue));
        resultPanel.setBackground(white);
        return resultPanel;
    }

    //helper method to make the number buttons
    public Panel makeNumberPanel(){
        Panel numbers = new Panel();
        numbers.setLayout(new GridLayout(4,4,2,2));
        numbers.add(CButton("7", dgreen, yellow));
        numbers.add(CButton("8", dgreen, yellow));
        numbers.add(CButton("9", dgreen, yellow));
        numbers.add(CButton("+", dblue, orange));
        numbers.add(CButton("4", dgreen, yellow));
        numbers.add(CButton("5", dgreen, yellow));
        numbers.add(CButton("6", dgreen, yellow));
        numbers.add(CButton("-", dblue, orange));
        numbers.add(CButton("1", dgreen, yellow));
        numbers.add(CButton("2", dgreen, yellow));
        numbers.add(CButton("3", dgreen, yellow));
        numbers.add(CButton("*", dblue, orange));
        numbers.add(CButton("0", dgreen, yellow));
        numbers.add(CButton("(-)", dred, yellow));
        numbers.add(CButton("Pop", dred, yellow));
        numbers.add(CButton("/", dblue, orange));
        return numbers;
    }

    //helper method to make enter and control buttons
    public Panel makeEnterPanel(){
        Panel entClr = new Panel();
        entClr.setLayout(new GridLayout(1,2,2,2));
        entClr.add(CButton("Enter", dblue, lblue));
        entClr.add(CButton("Clear", dblue, lblue));
        return entClr;
    }


    // create a colored button
    protected Button CButton(String s, Color fg, Color bg) {
        Button b = new Button(s);
        b.setBackground(bg);
        b.setForeground(fg);
        b.addActionListener(this);
        return b;
    }

    // create labels for results
    protected Label CLabel(String s, Color fg, Color bg){
        Label l = new Label(s);
        l.setBackground(bg);
        l.setForeground(fg);
        l.setFont(new Font("TimesRoman", Font.BOLD, 10));
        return l;
    }

    // handle button clicks
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof Button) {
            String label = ((Button)e.getSource()).getLabel();
            if (label.equals("+"))
                funcs(0);
            else if (label.equals("-"))
                funcs(1);
            else if (label.equals("*"))
                funcs(2);
            else if (label.equals("/"))
                funcs(3);
            else if(label.equals("Enter")){
                stack.push(current);
                int current = 0; // set new result to 0
                entered = true;
                result.setForeground(red);
            }
            else if(label.equals("Clear")){
                stack = new Stack<Integer>(); //clears the Stack
                entered = false;
                reset(); // call to reset result label
            }
            else if (label.equals("Pop")){
                stack.pop();
                if(stack.empty())
                    reset();
                else{
                    current = stack.peek();
                    show(current);
                }
            }
            else if (label.equals("(-)")){ // negate button
                current*=-1;
                show(current);
            }
            else {     // number button
                int n = Integer.parseInt(label);
                number(n);
            }
        }
    }

    // display number n in result label
    protected void show(int n) {
        result.setText(Integer.toString(n));
    }

    // reset result label
    // (called above)
    protected void reset(){
        result.setText("0");
        result.setForeground(black);
    }

    // function to avoid repetitive code in funtion methods
    // takes input of integer to coordinate operation (+,-,*,/)
    // 0 = Add
    // 1 = Subtract
    // 2 = Multiply
    // 3 = Divide
    public void funcs(int op){
        if(!entered)
            stack.push(current);
        if (stack.empty()){
            show(0);
        }
        else{
            int x1 = stack.pop();
            int x2 = 0;
            if (!stack.empty())
                x2 = stack.pop();
            if (op == 0)
                stack.push(x2 + x1);
            else if (op == 1)
                stack.push(x2 - x1);
            else if (op == 2)
                stack.push(x2 * x1);
            else if (op == 3)
                stack.push(x2 / x1);

            show(stack.peek());
            entered = true;
            result.setForeground(red);
        }

    }

    // handle number buttons
    protected void number(int n) {
        if (entered){
            current = n;
            show(current);
            entered = false;
            result.setForeground(black);
        }else {
            if (Integer.parseInt(result.getText()) < 0)
                current= Integer.parseInt(result.getText())* 10 - n;
                else
                current = Integer.parseInt(result.getText())* 10 + n;
            show(current);
        }

    }

}
