/**
 * BankAccount interface with additional methods beyond BankAccountKernel.
 *
 * Convention: The balance is always non-negative. The account number is a
 * non-empty String with only digits.
 *
 * Correspondence: this = (accountNumber, balance)
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
     * Determines whether the given name matches the owner of this account.
     *
     * @param name
     *            the name to check
     * @requires name != null
     * @ensures isOwner = (this.owner.equals(name))
     */
    boolean isOwner(String name);

    /**
     * Applies interest to the current balance at the given non-negative rate.
     *
     * @param rate
     *            the interest rate as a decimal (e.g., 0.05 for 5%)
     * @requires rate >= 0.0
     * @ensures this.balance = #this.balance + (#this.balance * rate)
     */
    void applyInterest(double rate);

}
