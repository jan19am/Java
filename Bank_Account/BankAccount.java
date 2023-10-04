public class BankAccount {
    // The class should have the following attributes: (double) checking balance, (double) savings balance.
    private double checkingBalance;
    private double savingsBalance;

    //     Create a class member (static) that has the number of accounts created thus far.
    private static int numberOfAccounts = 0;

// Create a class member (static) that tracks the total amount of money stored in every account created.
    private static double total = 0.0;

// In the constructor, be sure to increment the account count.
    public BankAccount(double checkingBalance, double savingsBalance) {
        this.checkingBalance = checkingBalance;
        this.savingsBalance = savingsBalance;
        numberOfAccounts++;
        total = checkingBalance + savingsBalance;
    }

 // Method to be able to see number of accounts created
    public static int accountCounter() {             
        return numberOfAccounts;
    }

// Create a getter method for the user's checking account balance.
    public double getCheckingAccountBalance() {
        return checkingBalance;
    }

    // // Checking Setter
    // public void setCheckingAccountBalance(double checking) {
    //     this.checkingBalance = checking;
    // }

// Create a getter method for the user's saving account balance.
    public double getSavingsAccountBalance() {
        return savingsBalance;
    }

// // Savings Setter
//     public void setSavingsAccountBalance(double savings) {
//         this.savingsBalance = savings;
//     }

// Create a method that will allow a user to deposit money into either the checking or saving, be sure to add to total amount stored.

// This is to deposit into the Checking Account
    public void checkingDeposit(double amount) {
        checkingBalance += amount;
        total = checkingBalance + savingsBalance;
    }

// This is to deposit to the Savings Account
    public void savingsDeposit(double amount) {
        savingsBalance += amount;
        total = checkingBalance + savingsBalance;
    }

// Create a method to withdraw money from one balance. Do not allow them to withdraw money if there are insufficient funds.
    public void checkingWithdrawal(double amount) {
        if (checkingBalance < amount) {
            System.out.println("Insufficiet Funds");
        }
        else {
            checkingBalance -= amount;
            total = checkingBalance + savingsBalance;
        }
    }

// Create a method to see the total money from the checking and saving.

// Trial method to see how it will function in a public method
//     public double showBalance() {
//         double totalBalance = checkingBalance + savingsBalance;
//         return totalBalance;
//     }

    public static double showMeTheMoney() {
        return total;
    }
// Users should not be able to set any of the attributes from the class.

}
