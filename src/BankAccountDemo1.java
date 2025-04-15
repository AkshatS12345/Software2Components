public class BankAccountDemo1 {
    public static void main(String[] args) {
        // Create two bank accounts with initial balances
        BankAccount1L joeyBankAccount = new BankAccount1L(500, "Joey");
        BankAccount1L akshatBankAccount = new BankAccount1L(500, "Akshat");

        // Display initial balances
        System.out.println("Initial Balances:");
        System.out.println(
                "Joey's Account Balance: " + joeyBankAccount.balance());
        System.out.println(
                "Akshat's Account Balance: " + akshatBankAccount.balance());

        // Perform a transfer from Joey to Akshat
        joeyBankAccount.transferTo(akshatBankAccount, 200);

        // Display balances after transfer
        System.out.println("\nAfter Transfer:");
        System.out.println(
                "Joey's Account Balance: " + joeyBankAccount.balance());
        System.out.println(
                "Akshat's Account Balance: " + akshatBankAccount.balance());

        // Check ownership using isOwner method
        System.out.println("\nOwnership Check:");
        System.out.println("Is Joey the owner of Joey's account? "
                + joeyBankAccount.isOwner("Joey"));
        System.out.println("Is Akshat the owner of Joey's account? "
                + joeyBankAccount.isOwner("Akshat"));
    }
}
