// BankAccount.java
// Defines BankAccount objects that have individual IDs and balances
// CS 201 HW 2 problem 4

public class BankAccount {

    // instance variables

    protected int id;
    protected double balance;


    // constructors

    //creates BankAccount with id and balance
    public BankAccount(int id, double balance) {
        // We use this.id to denote the instance variable named id rather
        // than the parameter named id.  When no local variable has the
        // same name as an instance variable, using "this" is optional
        this.id = id;
        this.balance = balance;
    }

    //creates account without balance specified 
    public BankAccount(int id) { // this constructor accounts for when a balance is not specified
        // we call the other constructor with 0 as the initial balance
        this(id, 0);
    }


    // instance methods

    // Method to deposit money to account
    public void deposit(double amount) {
        if (amount > 0) { // can only deposit positive amount of money
            balance += amount;
            System.out.println("Deposited $" + amount + ".");
        } else {
            System.err.println("You must deposit a positive amount of money.");
        }
    }

    // method to withdraw money
    // makes sure that withdraw is less than balance and positive
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew $" + amount + ".");
        } else {
            System.err.println("Sorry, you must withdraw a positive amount" +
                               " of money up to $" + balance + ".");
        }
    }

    //method to print balance using the instance variable
    public void printBalance() {
        System.out.println("Your balance is $" + balance + ".");
    }

    //Method to print id when calling Object
    public String toString() {
        return ("Account #" + id);
    }
}
