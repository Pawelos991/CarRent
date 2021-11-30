package pl.polsl.lab;

import static java.lang.System.*;

/**
 * VarArgsDemo feature.
 *
 * @author Gall Anonim
 * @version 1.0
 */
public class VarArgsDemo {

    public static void main(String[] args) {

        VarArgsDemo varArgsDemo = new VarArgsDemo();
        out.println(varArgsDemo.sum());
        out.println(varArgsDemo.sum(1));
        out.println(varArgsDemo.sum(1, 7, 5, 23, 4));
        out.println(varArgsDemo.sum(new int[]{3, 7, 2, 5}));

        int[] tab = new int[3];
        tab[0] = 66;
        out.println(varArgsDemo.sum(tab));
    }

    int sum(int... args) {
        int suma = 0;
        for (int i = 0; i < args.length; i++) {
            suma += args[i];
        }
        return suma;
    }
}
