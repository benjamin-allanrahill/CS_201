//Josephus.java
//
//Benjamin Allan-Rahill

public class Josephus{
    //instance variables
    Circular messengerCircle;
    int numToSkip;

    // constructor:

    // Pre:   numPeople and numToSkip are both >= 1
    // Post:  Initializes the instance variables to set up
    //  the "circle" of potential messengers.  Make sure
    //  the "current" number of the circle is 0 (i.e. the first person).
   public Josephus(int numPeople, int numToSkip){
       messengerCircle = new CircularVector();
       for (int i = 1; i <= numPeople; i++){
           messengerCircle.addAfterCurrent(i);
       }
       messengerCircle.next(); // make sure that `current` = 0
       this.numToSkip = numToSkip;
   }


   // instance method:

   // Pre:   A Josephus problem has been set up, with at least one potential
   //  messenger.
   // Post:  Messenger selected has been displayed on the screen; those
   //  not selected have had their names printed in the order in which they
   //  were excluded.
   public void findMessenger(){

       while(messengerCircle.size() > 1){

           for(int i = 1; i <= numToSkip; i++){
               System.out.println("Skip " + messengerCircle.getCurrent());
               messengerCircle.next();
           }
           System.out.println("Remove " + messengerCircle.getCurrent());
           messengerCircle.removeCurrent();
       }
       System.out.println("Messenger is " + messengerCircle.getCurrent());
   }

   // main method that creates a new object of type Josephus, initialized
   // (using the constructor) with two numbers supplied by
   // the user via command-line arguments.
   public static void main(String[] args){
       if (args.length != 0){
           int numPeople = Integer.parseInt(args[0]);
           int numToSkip = Integer.parseInt(args[1]);
           System.out.printf("Solving Josephus problem with %d people, skipping %d", numPeople, numToSkip);
           Josephus josephus = new Josephus(numPeople, numToSkip);
           josephus.findMessenger();
       }else {
           //set error code for when the args are empty
           System.err.println("Usage: Josephus <numPeople> <numToSkip>");
       }
   }

}
