/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import pl.polsl.java.bank.BankException;
import pl.polsl.java.bank.Account;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Gall Anonim
 */
public class AccountTest {

    private Account account;

    @BeforeEach
    public void setUp() {
        account = new Account(100);
    }

    @Test
    public void testPayment() {
        try {
            account.payment(100);
            assertEquals(account.getBalance(), 200, 0.01, "Payment 100 should give a result equals 200.");
        } catch (BankException e) {
            fail("Payment 100 for balance 100 fails");
        }

        try {
            account.payment(-100);
            fail("An exception should be thrown when the amount is non-positive");
        } catch (BankException e) {
        }

        try {
            account.payment(0);
            fail("An exception should be thrown when the amount equals zero");
        } catch (BankException e) {
        }

    }

    @Test
    public void testMonthlyCapitalisation() {
        account.monthlyCapitalisation(3);
        assertEquals(account.getBalance(), (100 + 100 * (3.0 / 100 / 12)), 0.01, "Capitalisation 3% from 100");

        account = new Account(0);
        account.monthlyCapitalisation(3);
        assertEquals(account.getBalance(), 0, 0.01, "Capitalisation 3% from empty account");

        account = new Account(100);
        account.monthlyCapitalisation(0);
        assertEquals(account.getBalance(), 100, 0.01, "Capitalisation 0% from 100");

        account = new Account(100);
        account.monthlyCapitalisation(-3);
        assertEquals(account.getBalance(), 100 - 100 * (3.0 / 100 / 12), 0.01, "Capitalisation -3% from 100");
    }

    @Test
    public void testPayoff() {
        // to implement
    }

    // -------------------------------------------------------------
// Various approaches to exception test
// -------------------------------------------------------------
    @Test
    public void simpleTestOfException() {
        try {
            account.payment(-30);
            fail("An exception should be thrown when the amount is non-positive");
        } catch (BankException e) {
        }
    }

    @Test
    public void extendedTestOfException() {
        try {
            account.payment(-30);
            fail("An exception should be thrown when the amount is non-positive");
        } catch (BankException e) {
            assertEquals(100, account.getBalance(), 0.01, "Balance shouldn't be changed!");
            assertTrue(e.getMessage().contains("Payment"), "Unexpected message!");
        }
    }

    @Test
    public void testOfException() {
        BankException exception = assertThrows(
                BankException.class,
                () -> account.payment(-30));
        assertEquals("Payment: amount of money should be a positive number!", exception.getMessage());
    }

}
