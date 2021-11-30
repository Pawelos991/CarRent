package pl.polsl.lab;

/** 
 * Class call up writing out the parameters for the console output.
 * 
 * @author Gall Anonim
 * @version 1.0
 */
public class Main {

    /**
     * Main method of writing out the parameters.
     * 
     * @param args program call parameters
     */
    public static void main(String args[]) {
        // number of parameters passed to the program
        int numberOfParameters = args.length;

        System.out.println("Program parameters: ");

        // write all the parameters passed to the program
        for (int i = 0; i < numberOfParameters; i++) {
            System.out.println("parameter " + (i + 1) + ":" + args[i]);
        }
    }
    /**Metoda dodaje
     * 
     * @param a Parametr a
     * @param b Parametr b
     * @param c Parametr c
     * @return suma
     */
    int abc(int a, int b, int c)
    {
        return a+b+c;
    }
}
