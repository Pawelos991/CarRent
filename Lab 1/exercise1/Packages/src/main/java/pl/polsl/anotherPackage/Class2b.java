// definition of the package in which class is placed
package pl.polsl.anotherPackage;

/**
 * First class in the 'a' package.
 * 
 * @author Gall Anonim
 * @version 1.1
 * 
 */
public class Class2b {

    /**
     * String representing the class name.
     */
    private String name;

    /**
     * Initiates a {@link Class2b} object using default string.
     */
    public Class2b() {
        name = "Class 2b";
    }

    /**
     * Returns the value of the private field "name"
     * 
     * @return string containing the value of the private field in the {@link Class2b}.
     */
    public String getName() {
        return name;
    }
}