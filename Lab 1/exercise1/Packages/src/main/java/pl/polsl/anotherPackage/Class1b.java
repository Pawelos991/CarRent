// definition of the package in which class is placed
package pl.polsl.anotherPackage;

/**
 * First class in the 'a' package.
 * 
 * @author Gall Anonim
 * @version 1.1
 * 
 */
public class Class1b {

    /**
     * String representing the class name.
     */
    private String name;

    /**
     * Initiates a {@link Class1b} object using default string.
     */
    public Class1b() {
        name = "Class 1b";
    }

    /**
     * Returns the value of the private field "name"
     * 
     * @return string containing the value of the private field in the {@link Class1b}.
     */
    public String getName() {
        return name;
    }
}