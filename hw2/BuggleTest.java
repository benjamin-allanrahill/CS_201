//BuggleTest.java
//
//Benjamin Allan-Rahill
//
// Test class to run the Buggle class

public class BuggleTest {
    public static void main(String args[]){
        // create a Buggle
        Buggle becky = new Buggle();
        // print it (this invokes the toString() method)
        System.out.println("becky: " + becky);

        // move becky around a bit and keep printing it
        becky.forward();  System.out.println("becky: " + becky);
        becky.left();     System.out.println("becky: " + becky);
        becky.forward(5); System.out.println("becky: " + becky);

        // create another Buggle and print it
        Buggle bobby = new Buggle();
        System.out.println("bobby: " + bobby);

        // move bobby without printing
        bobby.right();
        bobby.forward(5);
        bobby.right();
        bobby.forward(20);
        bobby.left();

        // move becky some more
        becky.left();
        becky.forward(3);

        // report final state of both Buggles
        System.out.println("becky: " + becky);
        System.out.println("bobby: " + bobby);
    }
}
