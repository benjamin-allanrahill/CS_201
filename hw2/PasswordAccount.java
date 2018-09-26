// PasswordAccount.Java
//
// Benjamin Allan-Rahill
//
// Script to create a BankAccount with a password


public class PasswordAccount{

        // instance vars
        protected String password;
        protected int id;
        protected double balance;

        // Create an account with a password, id, and balance
        public PasswordAccount(int id, String password, double balance) {
            // We use this.id to denote the instance variable named id rather
            // than the parameter named id.  When no local variable has the
            // same name as an instance variable, using "this" is optional
            this.id = id;
            this.balance = balance;
            this.password = password;
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
        // makes sure that withdraw is less than balance and positive and that
        // the password is correct
        public void withdraw(double amount, String pass) {
            if (pass.equals(password)) {
                if (amount > 0 && amount <= balance) {
                    balance -= amount;
                    System.out.println("Withdrew $" + amount + ".");
                } else {
                    System.err.println("Sorry, you must withdraw a positive amount" +
                                       " of money up to $" + balance + ".");
                }
            } else {
                System.out.println("Sorry, incorrect password.");
            }

        }

        //method to print balance using the instance variable
        public void printBalance(String pass) {
            if (pass.equals(password)) {
                System.out.println("Your balance is $" + balance + ".");
            } else {
                System.out.println("Sorry, incorrect password.");
            }
        }
        
        //Method to print id when calling Object
        public String toString() {
            return ("Account #" + id);
        }

}
