package pl.polsl.java.bank;

/**
 * Exception class representing all abnormal situations in bank operations
 * 
 * @author Gall Anonim
 * @version 1.0
 */
public class BankException extends Exception {

    public BankException(String message) {
        super(message);
    }
    
}
