public class BankAccountDemo2 {
    public static void main(String[] args) {
        // Create a bank account with an initial balance
        BankAccount1L joeyBankAccount = new BankAccount1L(1000, "Joey");

        // Display initial balance
        System.out.println("Initial Balance:");
        System.out.println(
                "Joey's Account Balance: " + joeyBankAccount.balance());

        // Apply an interest rate of 5% to the account
        joeyBankAccount.applyInterest(0.05);

        // Display balance after interest is applied
        System.out.println("\nAfter Applying Interest:");
        System.out.println(
                "Joey's Account Balance: " + joeyBankAccount.balance());
    }
}
