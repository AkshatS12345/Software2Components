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

}
