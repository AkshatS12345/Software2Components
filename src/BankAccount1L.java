public class BankAccount1L extends BankAccountSecondary {

    /**
     * Representation of this BankAccount's balance.
     */
    private int balance;

    /**
     * Representation of the owner's name.
     */
    private String owner;

    /**
     * Creator of initial representation.
     */
    private void createNewRep() {
        this.balance = 0;
        this.owner = "";
    }

    /**
     * No-argument constructor.
     */
    public BankAccount1L() {
        this.createNewRep();
    }

    /**
     * Constructor with initial balance and owner.
     *
     * @param initialBalance
     *            the initial balance
     * @param owner
     *            the owner's name
     */
    public BankAccount1L(int initialBalance, String owner) {
        assert initialBalance >= 0 : "Violation of: initialBalance >= 0";
        assert owner != null : "Violation of: owner is not null";
        this.balance = initialBalance;
        this.owner = owner;
    }

    /**
     * Constructor from another BankAccount.
     *
     * @param source
     *            the source BankAccount
     */
    public BankAccount1L(BankAccount source) {
        assert source != null : "Violation of: source is not null";
        this.balance = source.balance();
        this.owner = source.owner();
    }

    /*
     * Standard methods -------------------------------------------------------
     */

    @Override
    public final BankAccount newInstance() {
        try {
            return this.getClass().getConstructor().newInstance();
        } catch (ReflectiveOperationException e) {
            throw new AssertionError(
                    "Cannot construct object of type " + this.getClass());
        }
    }

    @Override
    public final void clear() {
        this.createNewRep();
    }

    @Override
    public final void transferFrom(BankAccount source) {
        assert source != null : "Violation of: source is not null";
        assert source != this : "Violation of: source is not this";
        assert source instanceof BankAccount1L : "Violation of: source is of dynamic type BankAccount1L";

        BankAccount1L localSource = (BankAccount1L) source;
        this.balance = localSource.balance;
        this.owner = localSource.owner;
        localSource.createNewRep();
    }

    @Override
    public final void deposit(int amount) {
        assert amount >= 0 : "Violation of: amount >= 0";
        this.balance += amount;
    }

    @Override
    public final void withdraw(int amount) {
        assert 0 <= amount
                && amount <= this.balance : "Violation of: 0 <= amount <= this.balance";
        this.balance -= amount;
    }

    @Override
    public final int balance() {
        return this.balance;
    }

    @Override
    public final String owner() {
        return this.owner;
    }

    @Override
    public final void setOwner(String owner) {
        assert owner != null : "Violation of: owner != null";
        this.owner = owner;
    }

}
