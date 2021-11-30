package pl.polsl.lab;

/**
 * Main class of the application realizing the operation of division with
 * exceptions.
 *
 * @author Gall Anonim
 * @version 1.1
 */
public class DivisionWithExceptions {

    /**
     * Main method of application.
     *
     * @param args first arg - dividend, second arg - divisor
     */
    public static void main(String args[]) {
        /** value of the dividend */
        int dividend = 0;
        /** divisor value */
        int divisor = 0;
        /** value ratio */
        float ratio = 0;
        /** true when the error occurred */
        boolean error = false;

        try {
            // parse numbers to share
            dividend = Integer.parseInt(args[0]);
            divisor = Integer.parseInt(args[1]);
        } // "exit" out of an array of args, which means that two parameters are
        // not passed
        catch (ArrayIndexOutOfBoundsException e) {
            error = true;
            System.err.println("No arguments !!!");
        } // error in the conversion, which means not being provided with two
        // numbers of type int
        catch (NumberFormatException e) {
            error = true;

            System.err.println("No numbers of type int!!!");
        } finally {
            System.out.println("I finished downloading the parameters");
        }

        if (!error) { // passed two numbers of type int, divide them
            try {
                ratio = dividend / divisor;
            } catch (ArithmeticException e) {// divide by zero error
                error = true;
                System.err.println("Don't divide by zero !!!");
            }

            if (!error) { // performed properly divide, write result
                System.out.println(dividend + " : " + divisor + " = " + ratio);
            }
        }
    }
}
