// HiLo.java -- example for CS 201
//
// Play HiLo game with different search strategies
//
// See also Opponent.java - implementation of Opponent class
//
// Daniel Scharstein
//
// based on a program by Lyn Turbak


// Bailey's structure package.  Not really needed here except for assertions,
// which are commented out for now.

//import structure.*;

public class HiLo {

    public static void main (String[] args) {
        // tests four methods of guessing
        Opponent opp = new Opponent();

        int secretFound;

        System.out.println("Linear Search (while):");
        secretFound = linearSearchWhile(opp, 0, opp.MAX);
        System.out.println("Secret = " + secretFound + " found in "
                           + opp.reportGuesses() + " guesses.\n");

        System.out.println("Linear Search (recursive):");
        secretFound = linearSearchRec(opp, 0, opp.MAX);
        System.out.println("Secret = " + secretFound + " found in "
                           + opp.reportGuesses() + " guesses.\n");

        System.out.println("Binary Search (while):");
        secretFound = binarySearchWhile(opp, 0, opp.MAX);
        System.out.println("Secret = " + secretFound + " found in "
                           + opp.reportGuesses() + " guesses.\n");

        System.out.println("Binary Search (recursive):");
        secretFound = binarySearchRec(opp, 0, opp.MAX);
        System.out.println("Secret = " + secretFound + " found in "
                           + opp.reportGuesses() + " guesses.\n");


    }


    public static int linearSearchWhile(Opponent opp, int lo, int hi) {
        // search for secret using iterative linear search
        // pre: secret is in [lo..hi]
        // post: returns secret

        int ans = opp.ask(lo);
        while (ans == -1) {
            lo = lo + 1;
            ans = opp.ask(lo);
            //Assert.condition(ans != 1, "guess can't be too high");
        }
        //Assert.post(ans == 0, "guess is correct");
        return lo;
    }

    public static int linearSearchRec(Opponent opp, int lo, int hi) {
        // search for secret using recursive linear search
        // pre: secret is in [lo..hi]
        // post: returns secret



        int ans = opp.ask(lo);
        if (ans != 0) {
            lo++;
            lo = linearSearchRec(opp, lo, hi);
        }
        return lo; // just a placeholder
    }

    public static int binarySearchWhile(Opponent opp, int lo, int hi) {
        // search for secret using iterative binary search

        int mid = (lo + hi) / 2;
        int test = opp.ask(mid);
        while (test != 0) {
            if (test == -1) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
            mid = (lo + hi) / 2;
            test = opp.ask(mid);
        }
        return mid;
    }

    public static int binarySearchRec(Opponent opp, int lo, int hi) {
        // search for secret using recursive binary search

        System.out.println("Binary: " + lo + "; " + hi);
        int mid = (lo + hi) / 2;
        int test = opp.ask(mid);

        if (test == -1) {
            hi = mid;
            binarySearchRec(opp, lo, hi);
        }
        else if (test == 1) {
            lo = mid;
            binarySearchRec(opp, lo, hi);
        }

        return mid; // just a placeholder
    }

}
