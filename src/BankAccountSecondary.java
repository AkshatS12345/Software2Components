public abstract class BankAccountSecondary implements BankAccount {

    /**
     * Transfers a non-negative amount from this account to another.
     *
     * @param target
     *            the BankAccount to transfer funds to
     * @param amount
     *            the amount to transfer
     * @requires this != target and 0 <= amount <= this.balance()
     * @ensures this.balance = #this.balance - amount and target.balance =
     *          #target.balance + amount
     */
    @Override
    public final void transferTo(BankAccount target, int amount) {
        assert target != null : "Target account must not be null";
        assert this != target : "Cannot transfer to the same account";
        assert amount >= 0
                && amount <= this.balance() : "Invalid transfer amount";

        this.withdraw(amount);
        target.deposit(amount);
    }

    /**
     * Determines whether the given name matches the owner of this account.
     *
     * @param name
     *
     * @requires n
     * @ensures isOwner = (this.own
     */
    @Override
    public final boolean isOwner(String name) {
        assert name != null : "Name must not be null";
        return this.owner().equals(name);
    }

    /**
     * Applies interest to the current balance at the given non-negative rate.
     *
     * @param rate
     *            the interest rate as a decimal (e.g., 0.05 for 5%)
     * @requires rate >= 0.0
     * @ensures this.balance = #this.balance + (#this.balance * rate)
     */
    @Override
    public final void applyInterest(double rate) {
        assert rate >= 0.0 : "Interest rate must be non-negative";
        int finalBalance = this.balance();
        int interest = (int) (finalBalance * rate);
        this.deposit(interest);
    }

}
