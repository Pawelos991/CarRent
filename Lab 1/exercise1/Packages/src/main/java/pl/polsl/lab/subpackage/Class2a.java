// definition of the package in which class is placed
package pl.polsl.lab.subpackage;

/**
 * First class in the 'a' package.
 * 
 * @author Gall Anonim
 * @version 1.1
 * 
 */
public class Class2a {

    /**
     * String representing the class name.
     */
    private String name;

    /**
     * Initiates a {@link Class2a} object using default string.
     */
    public Class2a() {
        name = "Class 2a";
    }

    /**
     * Returns the value of the private field "name"
     * 
     * @return string containing the value of the private field in the {@link Class2a}.
     */
    public String getName() {
        return name;
    }
}