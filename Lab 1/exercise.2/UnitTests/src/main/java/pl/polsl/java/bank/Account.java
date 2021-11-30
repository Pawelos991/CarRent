package pl.polsl.java.bank;

/**
 * Bank account
 *
 * @author Gall Anonim
 * @version 1.0
 *
 */
public class Account {

    /**
     * amount of money
     */
    private float balance;

    /**
     * Creates the account
     *
     * @param balance initial amount of money
     */
    public Account(float balance) {
        this.balance = balance;
    }

    /**
     * Increases the account balance
     *
     * @param amount amount of money paid into the bank
     * @throws BankException if the amount of money that change account balance
     * is negative or equals zero.
     */
    public void payment(float amount) throws BankException {
        if (amount > 0) {
            balance += amount;
        } else {
            throw new BankException("Payment: amount of money should be a positive number!");
        }
    }

    /**
     * Decreases the account balance
     *
     * @param amount amount of money paid from the bank
     * @throws BankException if amount of money that change account balance is
     * non-positive, or the amount of money is lower the the current balance.
     */
    public void payoff(float amount) throws BankException {

        if (amount <= 0) {
            throw new BankException("Payoff: Amount of money should be a positive number!");
        } else if (amount < balance) {
            throw new BankException("Payoff: Not enough money!");
        } else {
            balance -= amount;
        }
    }

    /**
     * realizes monthly capitalization
     *
     * @param yearPercent value of the year percentage
     */
    public void monthlyCapitalisation(float yearPercent) {
        balance += (yearPercent / 100 / 12) * balance;
    }

    /**
     * Getter for the 'balance' field
     *
     * @return current value of account balance
     */
    public float getBalance() {
        return this.balance;
    }
}
