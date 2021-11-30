package pl.polsl.lab;

/**
 * Main class of the application realizing the operation of division with own
 * definition of the exception.
 *
 * @author Gall Anonim
 * @version 1.1
 */
public class DivisionWithOwnException {

    /**
     * Main method of the application.
     *
     * @param args first arg - dividend, second arg - divisor
     */
    public static void main(String args[]) {
        int dividend, divisor;
        float ratio = 0;

        if (args.length >= 2) {
            if (args[0].matches("\\d") && args[1].matches("\\d")) {
                dividend = Integer.parseInt(args[0]);
                divisor = Integer.parseInt(args[1]);
                if (divisor != 0) {
                    try {
                        ratio = dividePositiveValues(dividend, divisor);
                        System.out.println(dividend + " : " + divisor + " = " + ratio);
                    } catch (DivisionException ex) {
                        System.err.println(ex.getMessage());
                    }
                } else {
                    System.out.println("Don't divide by zero!");
                }
            } else {
                System.out.println("Parameters contain not only digits!");
            }
        } else {
            System.out.println("Not enough parameters!!!");
        }
    }

    /**
     * Performs division of two numbers given as a parameter.
     *
     * @param dividend value of the dividend that is split
     * @param divisor value by which the dividend is divided
     * @return a result obtained by dividing one quantity by another
     * @throws DivisionException when attempt to divide by zero
     */
    static float dividePositiveValues(int dividend, int divisor) throws DivisionException {
        if ((divisor <= 0) || (dividend <= 0)) { // division by zero
            throw new DivisionException("Numbers are not positive!");
        } else {
            return (float) dividend / divisor;
        }
    }
}

/**
 * Exception class for objects thrown when attempting to divide by zero.
 *
 * @author Gall Anonim
 * @version 1.1
 */
class DivisionException extends Exception {

    /**
     * Non-parameter constructor
     */
    public DivisionException() {
    }

    /**
     * Exception class constructor
     *
     * @param message display message
     */
    public DivisionException(String message) {
        super(message);
    }
}
