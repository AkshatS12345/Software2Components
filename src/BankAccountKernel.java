import components.standard.Standard;

/**
 * Kernel interface for a BankAccount component.
 */
public interface BankAccountKernel extends Standard<BankAccount> {

    /**
     * Deposits a non-negative amount into the account.
     *
     * @param amount
     *            the amount to deposit
     * @requires amount >= 0
     * @ensures this.balance = #this.balance + amount
     */
    void deposit(int amount);

    /**
     * Withdraws a non-negative amount from the account.
     *
     * @param amount
     *            the amount to withdraw
     * @requires 0 <= amount <= this.balance
     * @ensures this.balance = #this.balance - amount
     */
    void withdraw(int amount);

    /**
     * Returns the current balance of the account.
     *
     * @return the balance
     * @ensures balance = this.balance
     */
    int balance();

    /**
     * Sets the name of the account owner.
     *
     * @param owner
     *            the new owner's name
     * @requires owner != null
     * @ensures this.owner = owner
     */
    void setOwner(String owner);

    /**
     * Returns the name of the account owner.
     *
     * @return the owner's name
     * @ensures owner = this.owner
     */
    String owner();

}