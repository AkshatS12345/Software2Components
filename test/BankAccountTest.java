import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * JUnit test fixture for {@code BankAccount}'s constructor.
 *
 * @author Akshat Shah
 *
 */
public class BankAccountTest {

    /**
     *
     * Tests that transferTo correctly updates both account balances.
     *
     * @ensures B1.balance() = 50 and B2.balance() = 150
     */
    @Test
    public final void transferToTestNoArgumentConstructor() {
        BankAccount b1 = new BankAccount1L();

        BankAccount b2 = new BankAccount1L();

        b1.deposit(100);
        b2.deposit(100);
        b1.transferTo(b2, 50);

        assertEquals(b1.balance(), 50);
        assertEquals(b2.balance(), 150);

    }

    /**
     * Tests that transferTo transfers the full balance using parameterized
     * constructor.
     *
     * @ensures joeyBankAccount.balance() = 0 and akshatBankAccount.balance() =
     *          1000
     */
    @Test
    public final void transferToTestParameterizedConstructor() {
        BankAccount joeyBankAccount = new BankAccount1L(500, "Joey");
        BankAccount akshatBankAccount = new BankAccount1L(500, "Akshat");

        joeyBankAccount.transferTo(akshatBankAccount, 500);

        assertEquals(joeyBankAccount.balance(), 0);
        assertEquals(akshatBankAccount.balance(), 1000);

    }

    /**
     * Tests that transferTo works with a BankAccount parameter constructor.
     *
     * @ensures escroAccount.balance() = 0 and akshatBankAccount.balance() =
     *          1000
     */
    @Test
    public final void transferToTestBankAccountParameter() {
        BankAccount akshatBankAccount = new BankAccount1L(500, "Akshat");
        BankAccount escroAccount = new BankAccount1L(akshatBankAccount);

        escroAccount.transferTo(akshatBankAccount, 500);

        assertEquals(escroAccount.balance(), 0);
        assertEquals(akshatBankAccount.balance(), 1000);

    }

    /**
     * Tests that isOwner correctly identifies the account owner after using the
     * no-argument constructor.
     *
     * @ensures b1.isOwner("Alice") = true and b2.isOwner("Bob") = true
     */
    @Test
    public final void isOwnerTestNoConstructor() {
        BankAccount b1 = new BankAccount1L();
        BankAccount b2 = new BankAccount1L();

        b1.setOwner("Alice");
        b2.setOwner("Bob");

        assertEquals(b1.isOwner("Alice"), true);
        assertEquals(b1.isOwner("Bob"), false);
        assertEquals(b2.isOwner("Bob"), true); // should return true
        assertEquals(b2.isOwner("Alice"), false); // should return false
    }

    /**
     * Tests that isOwner works correctly with the parameterized constructor.
     *
     * @ensures b1.isOwner("Joey") = true and b2.isOwner("Akshat") = true
     */
    @Test
    public final void isOwnerTestParameterizedConstructor() {
        BankAccount b1 = new BankAccount1L(500, "Joey");
        BankAccount b2 = new BankAccount1L(500, "Akshat");

        assertEquals(b1.isOwner("Joey"), true);
        assertEquals(b1.isOwner("Akshat"), false);
        assertEquals(b2.isOwner("Akshat"), true);
        assertEquals(b2.isOwner("Joey"), false);
    }

    /**
     * Tests that isOwner works correctly when constructed from another
     * BankAccount.
     *
     * @ensures b2.isOwner("Joey") = true and b2.isOwner("Akshat") = false
     */
    @Test
    public final void isOwnerTestBankAccountParameter() {
        BankAccount b1 = new BankAccount1L(500, "Joey");
        BankAccount b2 = new BankAccount1L(b1);

        assertEquals(b1.isOwner("Joey"), true);
        assertEquals(b1.isOwner("Akshat"), false);
        assertEquals(b2.isOwner("Akshat"), false);
        assertEquals(b2.isOwner("Joey"), true);
    }

    /**
     * Tests that applyInterest correctly updates balance using no-argument
     * constructor.
     *
     * @ensures b1.balance() = 150
     */
    @Test
    public final void applyInterestRateTestNoArgument() {
        BankAccount b1 = new BankAccount1L();
        b1.setOwner("Alice");
        b1.deposit(100);

        b1.applyInterest(.5);
        assertEquals(b1.balance(), 150);

    }

    /**
     * Tests that applyInterest correctly updates balance with parameterized
     * constructor.
     *
     * @ensures b1.balance() = 550
     */
    @Test
    public final void applyInterestParameterizedConstructor() {
        BankAccount b1 = new BankAccount1L(500, "Alice");

        b1.applyInterest(.1);
        assertEquals(b1.balance(), 550);

    }

    /**
     * Tests that applyInterest works correctly with a BankAccount parameter
     * constructor.
     *
     * @ensures b1.balance() = 240 and b2.balance() = 220
     */
    @Test
    public final void applyInterestWithBankAccountConstructor() {
        BankAccount b1 = new BankAccount1L(200, "Alice");
        BankAccount b2 = new BankAccount1L(b1);

        b1.applyInterest(.2);
        b2.applyInterest(.1);

        assertEquals(b1.balance(), 240);
        assertEquals(b2.balance(), 220);

    }

    /**
     * Standard Methods
     */

    /**
     *
     * Tests that newInstance creates a new BankAccount with default values.
     *
     * @ensures b1.balance() = 0 and b1.owner() = "" and b2.balance() = 0 and
     *          b2.owner() = ""
     */
    @Test
    public final void newInstanceTestNoArgumentConstructor() {
        BankAccount b1 = new BankAccount1L();
        BankAccount b2 = b1.newInstance();
        assertEquals(b1.balance(), 0);
        assertEquals(b1.owner(), "");
        assertEquals(b2.balance(), 0);
        assertEquals(b2.owner(), "");

    }

    /**
     *
     * Tests that newInstance creates a new BankAccount with default values,
     * even when called on an account initialized with parameters.
     *
     * @ensures b1.balance() = 100 and b1.owner() = "Sam" and b2.balance() = 0
     *          and b2.owner() = ""
     */
    @Test
    public final void newInstanceParameterizedConstructor() {
        BankAccount b1 = new BankAccount1L(100, "Sam");
        BankAccount b2 = b1.newInstance();
        assertEquals(b1.balance(), 100);
        assertEquals(b1.owner(), "Sam");
        assertEquals(b2.balance(), 0);
        assertEquals(b2.owner(), "");

    }

    /**
     *
     * Tests that newInstance creates a new BankAccount with default values,
     * even when called on a copy constructed from another account.
     *
     * @ensures b1.balance() = 0 and b1.owner() = "" and b2.balance() = 0 and
     *          b2.owner() = "" and b3.balance() = 0 and b3.owner() = ""
     */
    @Test
    public final void newInstanceTestBankAccountConstructor() {
        BankAccount b1 = new BankAccount1L();
        BankAccount b2 = new BankAccount1L(b1);
        BankAccount b3 = b2.newInstance();

        assertEquals(b1.balance(), 0);
        assertEquals(b1.owner(), "");

        assertEquals(b2.balance(), 0);
        assertEquals(b2.owner(), "");

        assertEquals(b3.balance(), 0);
        assertEquals(b3.owner(), "");

    }

    /**
     *
     * Tests that clear sets the balance to 0 for a default-constructed account.
     *
     * @ensures b1.balance() = 0
     */
    @Test
    public final void clearKernalMethodTestNoArgumentConstructor() {
        BankAccount b1 = new BankAccount1L();
        b1.clear();
        assertEquals(b1.balance(), 0);
    }

    /**
     *
     * Tests that clear sets the balance to 0 for a parameterized account.
     *
     * @ensures b1.balance() = 0
     */
    @Test
    public final void clearKernalMethodTestParameterizedConstructor() {
        BankAccount b1 = new BankAccount1L(500, "Joey");
        b1.clear();
        assertEquals(b1.balance(), 0);
    }

    /**
     *
     * Tests that clear sets the balance to 0 for a copied account, and does not
     * affect the original account's balance.
     *
     * @ensures b2.balance() = 0 and b1.balance() = 500
     */
    @Test
    public final void clearKernalMethodTestBankAccountConstructor() {
        BankAccount b1 = new BankAccount1L(500, "Joey");
        BankAccount b2 = new BankAccount1L(b1);
        b2.clear();
        assertEquals(b2.balance(), 0);
        assertEquals(b1.balance(), 500);
    }

    /**
     *
     * Tests that transferFrom correctly transfers balance and owner from
     * another account created with the no-argument constructor.
     *
     * @ensures b2.balance() = 100 and b2.owner() = "Sam" and b1.balance() = 0
     *          and b1.owner() = ""
     */
    @Test
    public final void transferFromTestNoArgumentConstructor() {
        BankAccount b1 = new BankAccount1L();
        b1.setOwner("Sam");
        b1.deposit(100);

        BankAccount b2 = new BankAccount1L();

        b2.transferFrom(b1);

        assertEquals(b2.balance(), 100);
        assertEquals(b2.owner(), "Sam");

        assertEquals(b1.balance(), 0);
        assertEquals(b1.owner(), "");

    }

    /**
     *
     * Tests that transferFrom replaces the balance and owner of the receiving
     * account with those of the source account when both are initialized with
     * parameters.
     *
     * @ensures b2.balance() = 500 and b2.owner() = "Joey" and b1.balance() = 0
     *          and b1.owner() = ""
     */
    @Test
    public final void transferFromTestParameterizedConstructor() {
        BankAccount b1 = new BankAccount1L(500, "Joey");

        BankAccount b2 = new BankAccount1L(100, "Akshat");

        b2.transferFrom(b1);

        assertEquals(b2.balance(), 500);
        assertEquals(b2.owner(), "Joey");

        assertEquals(b1.balance(), 0);
        assertEquals(b1.owner(), "");

    }

    /**
     *
     * Tests that transferFrom correctly transfers balance and owner from the
     * source account to a copy-constructed account, and clears the source
     * account.
     *
     * @ensures b2.balance() = 500 and b2.owner() = "Joey" and b1.balance() = 0
     *          and b1.owner() = ""
     */
    @Test
    public final void transferFromTestBankAccountConstructor() {
        BankAccount b1 = new BankAccount1L(500, "Joey");

        BankAccount b2 = new BankAccount1L(b1);

        b2.transferFrom(b1);

        assertEquals(b2.balance(), 500);
        assertEquals(b2.owner(), "Joey");

        assertEquals(b1.balance(), 0);
        assertEquals(b1.owner(), "");

    }

    /**
     * Kernal Methods
     */

    /**
     *
     * Tests that deposit correctly updates the balance for an account created
     * with the no-argument constructor.
     *
     * @ensures b1.balance() = 100
     */
    @Test
    public final void depositTestNoArgumentConstructor() {
        BankAccount b1 = new BankAccount1L();
        b1.deposit(100);

        assertEquals(b1.balance(), 100);
    }

    /**
     *
     * Tests that deposit correctly updates the balance and maintains the owner
     * for an account created with the parameterized constructor.
     *
     * @ensures b1.balance() = 200 and b1.owner() = "100000"
     */
    @Test
    public final void depositTestParameterizedConstructor() {
        BankAccount b1 = new BankAccount1L(100, "100000");
        b1.deposit(100);

        assertEquals(b1.balance(), 200);
        assertEquals(b1.owner(), "100000");
    }

    /**
     *
     * Tests that deposit correctly updates the balance for a copied account,
     * while leaving the original account unchanged.
     *
     * @ensures b1.balance() = 100 and b1.owner() = "100000" and b2.balance() =
     *          500 and b2.owner() = "100000"
     */
    @Test
    public final void depositTestBankAccountConstructor() {
        BankAccount b1 = new BankAccount1L(100, "100000");
        BankAccount b2 = new BankAccount1L(b1);

        b2.deposit(400);

        assertEquals(b1.balance(), 100);
        assertEquals(b1.owner(), "100000");

        assertEquals(b2.balance(), 500);
        assertEquals(b2.owner(), "100000");
    }

    /**
     *
     * Tests that withdraw correctly reduces the balance for an account created
     * with the no-argument constructor after a deposit.
     *
     * @ensures b1.balance() = 50
     */
    @Test
    public final void withdrawTestNoArgumentConstructor() {
        BankAccount b1 = new BankAccount1L();
        b1.deposit(100);
        b1.withdraw(50);

        assertEquals(b1.balance(), 50);
    }

    /**
     *
     * Tests that withdraw correctly reduces the balance and maintains the owner
     * for an account created with the parameterized constructor.
     *
     * @ensures b1.balance() = 100 and b1.owner() = "100000"
     */
    @Test
    public final void withdrawTestParameterizedConstructor() {
        BankAccount b1 = new BankAccount1L(200, "100000");
        b1.withdraw(100);

        assertEquals(b1.balance(), 100);
        assertEquals(b1.owner(), "100000");
    }

    /**
     *
     * Tests that withdraw correctly reduces the balance for a copied account,
     * while leaving the original account unchanged.
     *
     * @ensures b1.balance() = 300 and b1.owner() = "100000" and b2.balance() =
     *          200 and b2.owner() = "100000"
     */
    @Test
    public final void withdrawTestBankAccountConstructor() {
        BankAccount b1 = new BankAccount1L(300, "100000");
        BankAccount b2 = new BankAccount1L(b1);

        b2.withdraw(100);

        assertEquals(b1.balance(), 300);
        assertEquals(b1.owner(), "100000");

        assertEquals(b2.balance(), 200);
        assertEquals(b2.owner(), "100000");
    }

    /**
     *
     * Tests that balance returns 0 for an account created with the no-argument
     * constructor.
     *
     * @ensures b1.balance() = 0
     */
    @Test
    public final void balanceTestNoArgumentConstructor() {
        BankAccount b1 = new BankAccount1L();

        assertEquals(b1.balance(), 0);
    }

    /**
     *
     * Tests that balance returns the correct balance and owner for an account
     * created with the parameterized constructor.
     *
     * @ensures b1.balance() = 150 and b1.owner() = "100000"
     */
    @Test
    public final void balanceTestParameterizedConstructor() {
        BankAccount b1 = new BankAccount1L(150, "100000");

        assertEquals(b1.balance(), 150);
        assertEquals(b1.owner(), "100000");
    }

    /**
     *
     * Tests that balance is correctly copied in a new account created with the
     * bank account constructor, and both accounts retain the same balance and
     * owner.
     *
     * @ensures b1.balance() = 250 and b2.balance() = 250 and b1.owner() =
     *          "100000" and b2.owner() = "100000"
     */
    @Test
    public final void balanceTestBankAccountConstructor() {
        BankAccount b1 = new BankAccount1L(250, "100000");
        BankAccount b2 = new BankAccount1L(b1);

        assertEquals(b1.balance(), 250);
        assertEquals(b2.balance(), 250);

        assertEquals(b1.owner(), "100000");
        assertEquals(b2.owner(), "100000");
    }

    /**
     *
     * Tests that owner returns an empty string for an account created with the
     * no-argument constructor.
     *
     * @ensures b1.owner() = ""
     */
    @Test
    public final void ownerTestNoArgumentConstructor() {
        BankAccount b1 = new BankAccount1L();

        // Assuming default owner is an empty string or null
        assertEquals(b1.owner(), "");
    }

    /**
     *
     * Tests that owner returns the correct owner for an account created with
     * the parameterized constructor.
     *
     * @ensures b1.owner() = "100000"
     */
    @Test
    public final void ownerTestParameterizedConstructor() {
        BankAccount b1 = new BankAccount1L(100, "100000");

        assertEquals(b1.owner(), "100000");
    }

    /**
     *
     * Tests that owner is correctly copied when creating a new account using
     * the bank account constructor.
     *
     * @ensures b1.owner() = "100000" and b2.owner() = "100000"
     */
    @Test
    public final void ownerTestBankAccountConstructor() {
        BankAccount b1 = new BankAccount1L(100, "100000");
        BankAccount b2 = new BankAccount1L(b1);

        assertEquals(b1.owner(), "100000");
        assertEquals(b2.owner(), "100000");
    }

    /**
     *
     * Tests that setOwner correctly updates the owner for an account created
     * with the no-argument constructor.
     *
     * @ensures b1.owner() = "555555"
     */
    @Test
    public final void setOwnerTestAfterNoArgumentConstructor() {
        BankAccount b1 = new BankAccount1L();
        b1.setOwner("555555");

        assertEquals(b1.owner(), "555555");
    }

    /**
     *
     * Tests that setOwner correctly updates the owner for an account created
     * with the parameterized constructor, while keeping the balance unchanged.
     *
     * @ensures b1.owner() = "999999" and b1.balance() = 100
     */
    @Test
    public final void setOwnerTestAfterParameterizedConstructor() {
        BankAccount b1 = new BankAccount1L(100, "100000");
        b1.setOwner("999999");

        assertEquals(b1.owner(), "999999");
        assertEquals(b1.balance(), 100);
    }

    /**
     *
     * Tests that setOwner correctly updates the owner for a copied account,
     * while leaving the original account unchanged.
     *
     * @ensures b1.owner() = "original" and b2.owner() = "copy"
     */
    @Test
    public final void setOwnerTestCopiedAccount() {
        BankAccount b1 = new BankAccount1L(200, "original");
        BankAccount b2 = new BankAccount1L(b1);

        b2.setOwner("copy");

        assertEquals(b1.owner(), "original");
        assertEquals(b2.owner(), "copy");
    }

}
