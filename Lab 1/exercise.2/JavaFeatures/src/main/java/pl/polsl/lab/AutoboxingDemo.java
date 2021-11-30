package pl.polsl.lab;

/**
 * Demonstration of autoboxing. 
 * 
 * @author Gall Anonim
 * @version 1.
 */
public class AutoboxingDemo {

    public static void main(String[] args) {

        Integer obj = 17; // box, the assignment
        obj++; // unpacking, increment, packaging
        obj += 3; // unpacking, adding, packaging

        // summing the simple types and objects
        Integer a = new Integer(12);
        // a = null;
        int b = 7;
        // b = null;
        Integer c = a + b;
        int d = a + b;
        System.out.println("" + c + ", " + d);

        fun(4); // package-match method call arguments
    }

    public static void fun(Integer arg) {
        System.out.println(arg);
    }
}
