//Mortgage program
//
// Benjamin Allan-Rahill


public class Mortgage{

  public static void main(String[] args){
    // Loop that prints the information for a principal = 250000 and y = 30 at incrementing (by .25) interest rates from 5-10
    for (double i = 5.0; i<=10; i+=.25) {
      print(250000, i, 30);

    }
  }

  public static double mortgage(double p, double i, double y){
    // declare mortgage variable
    double mortgageVal = (p * (i / 1200))/(1- Math.pow((1/(1+(i/1200))), 12*y )); // formula for mortagage
    return mortgageVal;

  }

  public static void print(double p, double i, double y){ // function to print out parameter and system information
    double mortg = mortgage(p, i, y); // calculate mortgage
    double totalMortgage = (mortg*12)*y; // calculate total payments

    // print parameter info to System
    System.out.printf("principal = %.2f; interest = %.2f; years = %.2f; mortgage = %.2f; total = %.2f \n", p, i, y, mortg, totalMortgage);

  }

}
