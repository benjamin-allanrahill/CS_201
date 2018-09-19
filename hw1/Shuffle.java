// Shuffle.java
// Benjamin Allan-Rahill
// CS 201  HW 1, Problem 3

public class Shuffle {

    public static void main(String[] args) {
      printShufflePeriods(2,100);
    }

    // Prints even shuffle periods between lo and hi.
    // For each even integer k in the interval [lo, hi],
    // print a line whose contents is shufflePeriod(k)=p,
    //where p is the shuffle period for an array of length k.
    public static void printShufflePeriods(int lo, int hi) {
        // Assume lo and hi are even;
      for (int i = lo; i<=hi ;i+=2) {
          System.out.println(i + "=" + shufflePeriod(i));
      }
    }


    // Computes shuffle period for a deck of size L.
    // (The shuffle period is the smallest number of perfect shuffles
    // necessary to bring the deck back into its originial order.)
    public static int shufflePeriod(int L) {
        // Assume L is even
        int counter = 1; // initiates counter variable

        //creates a perfectly shuffeled array of desired length
        // runs until the array is back to an identity array
        // running a perfect shuffle every loop
        for (int[] arr = perfectShuffle(identity(L)); isIdentity(arr) != true ; arr = perfectShuffle(arr) ) {
          counter++; // increments counter per perfect shuffle
        }
      //  System.out.println(counter);
        return counter; // just a placeholder
    }

    // Performs a perfect shuffle.
    // Returns a new array that's a perfect shuffle of A
    public static int[] perfectShuffle(int[] A) {
        // Assume A has even length
        int len = A.length;
        int[] beg = new int[len/2]; // create empty arrays that are half the length of the identity array
        int[] end = new int[len/2];

        int begLen = beg.length; // establishes lengths of halfs
        int endLen = end.length; // always the same length but for organizational purposes I initialized it twice

        // Build identity arrays for the first half of the array using the index `i`
        for(int i =0; i <= begLen - 1; i++){
          beg[i] = A[i];
        }
        // Build the second array stating at index `i=len/2`
        for(int i =len/2; i <= len -1; i++){
          end[i - endLen] = A[i];
        }

	       // allocate result array
        int[] result = new int[len];

        // loop to shuffle using the index of the two arrays.
	      for (int i = 0 ; i <= (len/2)-1; i++) {
          result[i*2]= beg[i];
          result[(i*2)+1]= end[i];
        }

        // return result array to `shufflePeriod` function
        return result;
    }

    // Returns an identity array of length L
    // create new array of length L
    // fill it with numbers 0 .. L-1
    public static int[] identity(int L) {

    // allocate array of specified length (L)
    int[] array = new int[L];

    // For loop using indecies to create identity array
    for(int i = 0; i <= L-1; i++){
      array[i] = i;
    }
	   // return it
    return array;
    }

    // Returns whether array A is the identity array.
    public static boolean isIdentity(int[] A) {

      // uses index to check for identity
      for (int i = 0; i < A.length ; i++ ) {
        if (i != A[i]) {
          return false;
        }
      }
      return true;
    }

    // Creates a string representation of integer array A.
    // (useful for debugging)
    public static String intArrayToString(int[] a) {
        String s = "[";
        if (a.length > 0) {
            s += a[0];
            for (int i = 1; i < a.length; i++) {
                s += (", " + a[i]);
            }
        }
        s += "]";
        return s;
    }

}
