// FindPrincipal.java
//Benjamin Allan-Rahill
// CS 201, HW 1, Problem 2

public class FindPrincipal {

    //method that finds the principal using the `findBetween` and `upperBound` Functions
    // inputs: given mortgage (mortgage), interest rate (interest), and years.
    public static double find(double mortgage, double interest,
			      double years) {
	       return findBetween(mortgage, interest, years, 0, upperBound(mortgage, interest, years)); // calls binary search function
    }

    // Binary search method
    // Calculates an estimated principal in the given interval (lo, hi)
    // Returns the principal (midPoint) to the `find` function so that it is printed to the system
    public static double findBetween(double mortgage, double interest,
				     double years, double lo, double hi) {

                  double midPoint = (lo + hi)/2.0; // calculate the midPoint
                  double midPointMortgage = Mortgage.mortgage(midPoint, interest, years);

                  if (Math.abs(mortgage - midPointMortgage) > 1) {
                    if (mortgage > midPointMortgage) {
                      System.out.print("M is greater than middle \n" + "midPointMortgage =" + midPointMortgage + "\n");
                      midPoint = findBetween(mortgage, interest, years, midPoint, hi);
                    }
                    else if (mortgage < midPointMortgage) {
                      System.out.print("M is less than middle \n"+ "midPointMortgage =" + midPointMortgage+ "\n");
                      midPoint = findBetween(mortgage, interest, years, lo, midPoint);
                    }

                  }

                   System.out.print(midPoint + "\n");
                   return midPoint;
    }

    // Method that calculates the upper bound for the binary search function
    // Does this by doubling the principal until the mortgage at that p
    // is greater than or equal to the given mortgage (mortgage)
    public static double upperBound(double mortgage, double interest,
				    double years) {

              double m = 1; // initiates starting value for mortgage
              double p = 1; // initiates starting value for the principal

              for ( p = 1; m <= mortgage ; p=p ) {
                p*=2;
                m = Mortgage.mortgage(p,interest,years); //calculate the new mortgage
                System.out.printf("Mortage for %f P = %f", p, m);
              }
              System.out.print("Upper bound = " + p + "\n");
              return p; //return the upper bound

    }

    // method to test the `find` and other functions
    public static void testFind(double m, double i, double y) {
	System.out.println("find(" + m + ", " + i + ", " + y + ") = "
			   + find(m, i, y));
    }

    public static void main(String [] args) {
	     testFind(1200.00, 7.00, 30.0);
    }

}
