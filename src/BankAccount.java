import components.sequence.Sequence;
import components.sequence.Sequence1L;

public final class BankAccount {

    private int balance;
    private Sequence<String> transactions;

    /**
     * Constructor (initializes balance and transaction history).
     */
    public BankAccount() {
        this.balance = 0;
        this.transactions = new Sequence1L<>();
    }

    /**
     * Deposits a given amount into the account.
     *
     * @param amount
     *            the amount to deposit (must be > 0)
     */
    public void deposit(int amount) {
        assert amount > 0 : "Deposit amount must be positive.";
        this.balance += amount;
        this.transactions.add(this.transactions.length(), "Deposit " + amount);
    }

    /**
     * Withdraws a given amount from the account.
     *
     * @param amount
     *            the amount to withdraw (must be > 0 and <= balance)
     */
    public void withdraw(int amount) {
        assert amount > 0 : "Withdrawal amount must be positive.";
        assert amount <= this.balance : "Insufficient funds.";
        this.balance -= amount;
        this.transactions.add(this.transactions.length(), "Withdraw " + amount);
    }

    /**
     * Returns the current balance.
     *
     * @return the balance
     */
    public int currentBalance() {
        return this.balance;
    }

    /**
     * Prints the transaction history.
     */
    public void printTransactionHistory() {
        for (int i = 0; i < this.transactions.length(); i++) {
            System.out.println(this.transactions.entry(i));
        }
    }

    /**
     * Main method to demonstrate the component.
     */
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        account.deposit(100);
        account.withdraw(30);
        account.deposit(50);

        System.out.println("Current balance: $" + account.currentBalance());
        System.out.println("Transaction history:");
        account.printTransactionHistory();
    }
}