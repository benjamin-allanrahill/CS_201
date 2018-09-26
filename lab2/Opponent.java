// Opponent.java -- example for CS 201
//
// Implements opponenent in HiLo guessing game
//
// See also HiLo.java - implementation using this class
//
// Daniel Scharstein
//
// based on a program by Lyn Turbak

import java.util.Random;

public class Opponent {
    public final int MAX = 1000;    // maximum number
    Random rand = new Random();

    private int secret = 793; // Should be between 0 and MAX, inclusive  (fixed for testing)
    //private int secret = rand.nextInt(MAX+1);

    private int guesses = 0;  // keep track of how many guesses it takes

    public int ask(int guess) {
        // return 0 if guess is correct, -1 if too low, +1 if too high
        // also update number of guesses

        guesses = guesses + 1;
        if (guess == secret) {
            return 0;
        } else if (guess < secret) {
            return -1;
        } else {
            return 1;
        }
    }

    public int reportGuesses() {
        // returns number of guesses and resets it to 0 for next round

        int g = guesses;
        guesses = 0; // reset guesses for next round.
        return g;
    }

}
