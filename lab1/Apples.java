// Ben Allan-Rahill

public class Apples {

  public static void main(String[] args){
      System.out.println("I like to eat, eat, eat \n apples and bananas \n");
      System.out.println("I like to eat, eat, eat \n apples and icecream \n");

      printVerse("bananas");
      printVerse("icecream");
  }

  public static void printVerse(String param){
    System.out.println("I like to eat, eat, eat \n apples and " + param + "\n");
  }
}
