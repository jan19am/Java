public class TestBank {
    
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount(500.0, 200.0);
        account1.checkingDeposit(20.0);
        account1.checkingWithdrawal(40.0);
        System.out.println(BankAccount.showMeTheMoney());
        

        // account1.savingsDeposit(25.0);
        // account1.checkingWithdrawal(30.0);

        // System.out.println(account1.showBalance()); 
        

    }
}
