// definition of the package in which class is placed
package pl.polsl.lab.subpackage;

/**
 * First class in the 'a' package.
 * 
 * @author Gall Anonim
 * @version 1.1
 * 
 */
public class Class1a {

    /**
     * String representing the class name.
     */
    private String name;

    /**
     * Initiates a {@link Class1a} object using default string.
     */
    public Class1a() {
        name = "Class 1a";
    }

    /**
     * Returns the value of the private field "name"
     * 
     * @return string containing the value of the private field in the {@link Class1a}.
     */
    public String getName() {
        return name;
    }
}