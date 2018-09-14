// Program to print the first ten odd numbers
// Benjamin Allan-Rahill

public class Odd {
  public static void main(String[] args) {
    printOdd(10);
  }

    public static void printOdd(int limit){

      int countOfOdds = 0; // sets the counter varaible to 0

      for(int i = 0; countOfOdds < limit; i++){ // sets the varaible i to 0
        if (i % 2 != 0 ) {
          System.out.println(i);
          countOfOdds++;
        }

      }
    }



}
