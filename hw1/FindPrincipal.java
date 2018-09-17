//Benjamin Allan-Rahill

public class FindPrincipal {


    public static double find(double mortgage, double interest,
			      double years) {

	       return findBetween(mortgage, interest, years, 0, upperBound(mortgage, interest, years));
    }


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




/*
                 if (Math.abs(mortgage - midPointMortgage) <= 1) {
                    System.out.print("M is accurate \n "+ "midPointMortgage =" + midPointMortgage+ "\n");
                    System.out.print(midPoint + "\n");
                    midPoint = midPoint;
                    System.out.print(midPoint + "\n");
                    return midPoint;

                  }

*/


    }


    public static double upperBound(double mortgage, double interest,
				    double years) {

              double m = 1; // initiates starting value for mortgage
              double p = 1; // initiates starting value for the principal

              for ( p = 1; m <= mortgage ; p=p ) {
                p*=2;
                m = Mortgage.mortgage(p,interest,years); //calculate the new m
                System.out.printf("Mortage for %f P = %f", p, m);
              }
              System.out.print("Upper bound = " + p + "\n");
              return p; //return the upper bound

    }

    public static void testFind(double m, double i, double y) {
	System.out.println("find(" + m + ", " + i + ", " + y + ") = "
			   + find(m, i, y));
    }

    public static void main(String [] args) {
      // upperBound(1200.00, 7.00, 30.00);
	     testFind(1200.00, 7.00, 30.0);
    }

}
