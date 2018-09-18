// Shuffle.java
//
// Skeleton for CS 201  HW 1, Problem 3

public class Shuffle {

    public static void main(String[] args) {
      //  printShufflePeriods(2,100);

        identity(8);
    }

  /*
    // Prints even shuffle periods between lo and hi.
    public static void printShufflePeriods(int lo, int hi) {
        // Assume lo and hi are even;
        int i = lo;

     for (i; i<=hi ;i+=2) {

          System.out.print(shufflePeriod(i));

        }

    }

*/

    // Computes shuffle period for a deck of size L.
    // (The shuffle period is the smallest number of perfect shuffles
    // necessary to bring the deck back into its originial order.)
    public static int shufflePeriod(int L) {
        // Assume L is even.
        int shuffleCount = 0;
        int [] idArray;

      //  idArray = new identity(L);

        return 0; // just a placeholder
    }

    // Performs a perfect shuffle.
    // Returns a new array that's a perfect shuffle of A
    public static int[] perfectShuffle(int[] A) {
        // Assume A has even length

        int len = A.length;
        int[] beg = new int[len/2];
        int[] end = new int[len/2];

        int begLen = beg.length;
        int endLen = end.length;

        for(int i =0; i <= begLen - 1; i++){
          beg[i] = A[i];
        }
        System.out.println("BEG = " + intArrayToString(beg));
        for(int i =len/2; i <= len -1; i++){
          System.out.print(i);
          end[i - endLen] = A[i];
        }
        System.out.println("END = " + intArrayToString(end));

	// allocate result array
        int[] result = new int[len];

	      for (int i = 0 ; i <= (len/2)-1; i++) {
          System.out.print(i);
          result[i*2]= beg[i];
          result[(i*2)+1]= end[i];
          System.out.println("RESULT = " + intArrayToString(result));

        }

	// for debugging, print arrays like:
	System.out.println("RESULT = " + intArrayToString(result));


        return result;
    }

    // Returns an identity array of length L
    public static int[] identity(int L) {

    int[] array = new int[L];

    System.out.println("A = " + intArrayToString(array));

    for(int i = 0; i <= L-1; i++){
      System.out.print(i);
      array[i] = i;
    }

    perfectShuffle(array);

    System.out.println("A = " + intArrayToString(array));

	// create new array of length L
	// fill it with numbers 0 .. L-1
	// return it
    return array;
    //  return id; // just a placeholder
    }

    // Returns whether array A is the identity array.
    public static boolean isIdentity(int[] A) {

	// FILL IN

        return false; // just a placeholder
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
