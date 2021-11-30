package pl.polsl.lab;

// packages containing class definitions 
import pl.polsl.lab.subpackage.Class1a;
import pl.polsl.lab.subpackage.Class2a;
import pl.polsl.anotherPackage.*;

/**
 * Presents the use of classes belonging to different packages.
 * 
 * @author Gall Anonim
 * @version 1.1 
 */
public class PackageDemo {

    /**
     * Main method of application uses the classes defined in different
     * packages.
     * 
     * @param args command line parameters
     */
    public static void main(String args[]) {
        // creating the instances of classes 
        Class1a object1a = new Class1a();
        Class2a object2a = new Class2a();
        Class1b object1b = new Class1b();
        Class2b object2b = new Class2b();

        // displaying the information of object fields
        System.out.println("Class name 1a: " + object1a.getName());
        System.out.println("Class name 2a: " + object2a.getName());
        System.out.println("Class name 1b: " + object1b.getName());
        System.out.println("Class name 2b: " + object2b.getName());
    }
}