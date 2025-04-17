/**
 * Has all the secondary methods including the implementations for all the
 * object methods for the class BankAccount.
 */
public abstract class BankAccountSecondary implements BankAccount {

    @Override
    public final void transferTo(BankAccount target, int amount) {
        assert target != null : "Target account must not be null";
        assert this != target : "Cannot transfer to the same account";
        assert amount >= 0
                && amount <= this.balance() : "Invalid transfer amount";

        this.withdraw(amount);
        target.deposit(amount);
    }

    @Override
    public final boolean isOwner(String name) {
        assert name != null : "Name must not be null";
        return this.owner().equals(name);
    }

    @Override
    public final void applyInterest(double rate) {
        assert rate >= 0.0 : "Interest rate must be non-negative";
        int finalBalance = this.balance();
        int interest = (int) (finalBalance * rate);
        this.deposit(interest);
    }

    /**
     * Returns a string representation of this BankAccount.
     *
     * @return a string displaying the account number, account holder, and
     *         balance
     */
    @Override
    public String toString() {
        return "BankAccount[" + "Account Holder: " + this.owner() + ", "
                + "Balance: $" + this.balance() + "]";
    }

    /**
     * Reports whether this BankAccount is equal to the given object.
     *
     * @param obj
     *            the object to compare to
     * @return true if obj is a BankAccount and has the same balance as this;
     *         false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj == this) {
            return true;
        }

        if (!(obj instanceof BankAccount)) {
            return false;
        }

        boolean equalAccounts = false;
        BankAccount b2 = (BankAccount) obj;
        if (this.balance() == b2.balance() && this.owner().equals(b2.owner())) {
            equalAccounts = true;
        }
        return equalAccounts;
    }

}
