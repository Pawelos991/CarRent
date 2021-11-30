package pl.polsl.lab;

/**
 * Main class of the application realizing the operation of division without
 * exceptions.
 *
 * @author Gall Anonim
 * @version 1.2
 */
public class SafeDivision {

    /**
     * Main method of the application.
     *
     * @param args first arg - dividend, second arg - divisor
     */
    public static void main(String args[]) {
        int dividend, divisor;
        float ratio;

        if (args.length >= 2) {
            if (args[0].matches("\\d") && args[1].matches("\\d")) {
                dividend = Integer.parseInt(args[0]);
                divisor = Integer.parseInt(args[1]);
                if (divisor != 0) {
                    ratio = dividend / divisor;
                    System.out.println(dividend + " : " + divisor + " = " + ratio);
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
}
