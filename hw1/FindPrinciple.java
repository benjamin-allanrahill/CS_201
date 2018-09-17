//Benjamin Allan-Rahill

public class FindPrincipal {

    public static double find(double mortgage, double interest,
			      double years) {

	       return findBetween(mortgage, interest, years,
			   0, upperBound(mortgage, interest, years));
    }

    public static double findBetween(double mortgage, double interest,
				     double years, double lo, double hi) {
	// FILL IN
    }

    public static double upperBound(double mortgage, double interest,
				    double years) {

              double m = 0;
              double p = 1;
              for (p = 1; m > mortgage ; p*=2 ) {
                m = Mortgage.mortgage(p,interest,years); //calculate the new m
                System.out.printf("Mortage for %f P = %f", p, m);
                p = p;
              }
              System.out.print("Upper bound = " + p);
              return p; //return the upper bound

    }

    public static void testFind(double m, double i, double y) {
	System.out.println("find(" + m + ", " + i + ", " + y + ") = "
			   + find(m, i, y));
    }

    public static void main(String [] args) {
      upperBound(1200.00, 7.00, 30.00);
	// testFind(1200.00, 7.00, 30.0);
    }

}
