// DebugMe.java
// CS 201 Lab 2

public class DebugMe {

    // Debug one method at a time.  Once you fixed one, uncomment the next one.
    // Work incrementally and compile often!
    public static void main (String[] args) {
        sumnums();
        log2(1024);
        countdown(10);
    }

    // computes sum of numbers from 1 to 10 and prints it
    public static void sumnums() {
        int sum = 0;
        for (int i = 0; i <= 10; i++) {
            sum += i;
        }
        System.out.println("sum = " + sum);
    }


    // comment out the other functions for now

    // computes log_2 of x by repeatedly cutting it in half and print the result
    public static void log2(double x) {
        int cnt = 0;
        while (x > 1) {
            x = x / 2.0;
            cnt++;
        }
        System.out.println("log_2 x = " + cnt);
    }


    // recursively count down from n to 0 and print "Blastoff!" at the end
    public static void countdown(int n) {
        if (n == 0){
            System.out.println("Blastoff!");
        }
        else {
            System.out.println(n);
            countdown(n-1);
        }
    }



}
