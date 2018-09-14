// Write the HailStone Seq for any given number
// Benjamin Allan-Rahill

public class HailStone{
  public static void main(String[] args){
    int arg1 = Integer.parseInt(args[0]); // Convert the first system argument to an integer
    printHailStone(arg1); // call the function with that specified interger
  }

  public static void printHailStone(int integer){  // set the input as an integer

    System.out.print(integer + ", ");
    while (integer > 1) {
      integer = next(integer); // call the 'next' function to get the next value in the sequence
      System.out.print(integer + ", ");  // print the new integer received from the 'next' funtion
    }
  }

  public static int next(int n) {
    if (n % 2 == 0){ // if the number is even => devide it by 2
      n = n / 2;
    }
    else if (n % 2 != 0) { // if the number is odd => multiply by 3 and add 1
      n = 3 * n + 1;
    }
    return n; // retrun the new interger
  }
}
