/**
 * Enhanced interface for a BankAccount component.
 */
public interface BankAccount extends BankAccountKernel {

    /**
     * Transfers a non-negative amount from this account to another.
     *
     * @param amount
     *            the amount to transfer
     * @param target
     *            the BankAccount to transfer funds to
     * @requires this != target and 0 <= amount <= this.balance
     * @ensures this.balance = #this.balance - amount and target.balance =
     *          #target.balance + amount
     */
    void transferTo(BankAccount target, int amount);

    /**
     * Returns the name of the account owner.
     *
     * @return the owner's name
     * @ensures owner = this.owner
     */
    String owner();

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
     * Returns a String representation of the BankAccount.
     *
     * @return formatted string with owner and balance
     * @ensures toString = owner + ": $" + balance
     */
    @Override
    String toString();
}
