// CircularVector.java
//
//Benjamin Allan-Rahill

// Don't forget comments!


// to tell java where to find the Vector class, use ONE of following two import statements:

//import java.util.Vector; // get it from java.util

import structure.*; // get it from Bailey's structure package
  // if this causes problems, see Lab 1, exercise 0.
  // ask a tutor for help if necessary


public class CircularVector implements Circular
{
    // instance vars
    protected Vector list;
    protected int current;

    //Constructor

    public CircularVector(){
        list = new Vector();
        current = 0;
    }

    // add your code here

    // pre:  this is non-empty
    // post: moves current to successor position in arrangement
    public void next(){
        if (current == list.size() - 1) {
            current = 0;
        } else {
            current++;
        }
    }

    // pre:
    // post: returns number of elts in object (0 if empty)
    public int size(){
        return list.size();
    }

    // pre:  this is non-empty
    // post: returns the current element
    public Object getCurrent(){
        return list.get(current);
    }

    // pre:  this is non-empty
    // post: Current elt is deleted, if non-empty, successor of old current
    //       is new current elt
    public void removeCurrent(){
        if (current != list.size() - 1) {
            list.remove(current);
        } else{

            // Since it is circular add the first value to the end, then remove
            // the first value. Next, remove the "last" value (current)
            Object tmp = list.get(0);
            list.add(list.size(), tmp);
            list.remove(current);
            list.remove(0);
            current = list.indexOf(tmp);
        }

    }

    // pre:
    // post: If this was empty, obj is inserted as only elt, otherwise added
    //       after current elt.  Either way, obj is now current elt
    public void addAfterCurrent(Object obj){
        if(list.size() > 0){
            list.add(current+1, obj);
            current++;
        } else{
            list.add(current, obj);
        }
    }

    // pre:
    // post: collection of objects is now empty
    public void clear(){
        list.clear();
    }

    // useful shorthand for System.out.println to save some typing
    public static void p(String s) {
        System.out.println(s);
    }


    // use a main method like the following to test your implementation:
    public static void main(String[] args) {

        p("creating new circular vector");
        Circular myList = new CircularVector();
        p("size is " + myList.size());
        p("adding 7");
        myList.addAfterCurrent(7);
        p("current is now " + myList.getCurrent());
        p("adding 8");
        myList.addAfterCurrent(8);
        p("calling next");
        myList.next();
        p("current is now " + myList.getCurrent());
        p("size is now " + myList.size());

        // add more code to *thoroughly* test all methods!
    }

}
