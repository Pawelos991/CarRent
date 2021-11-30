package pl.polsl.lab.main;

import pl.polsl.lab.interfaces.Sortable;

/**
 * Class representing a person, and implementing Sortable interface.
 * 
 * @author Gall Anonim
 * @version 1.0
 */
class Person implements Sortable {

    /** name */
    private String name;
    /** age */
    private int age;

    /**
     * costructor
     * 
     * @param name person name
     * @param age person age
     */
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /*
     * (non-Javadoc)
     * 
     * @see pl.polsl.java.lab1.Sortable#less(pl.polsl.java.lab1.Sortable)
     */
    public boolean less(Sortable item) {
        Person person = (Person) item;
        int value = name.compareTo(person.name);

        if (value < 0) // name < person.name
        {
            return true;
        } else if (value > 0) // name > person.name
        {
            return false;
        }

        return age < person.age;
    }

   
    /**
     * Converts object's state to the text form
     * @return textual representation of the object
     */
    public String toString() {
        return ("Name:" + name + " age:" + age);
    }
}

/**
 * Main class of the program.
 * 
 * @author Gall Anonim
 * @version 1.0
 */
public class Sorter {

    /** 
     * Main method of program 
     * 
     * @param args command line parameters
     */
    public static void main(String args[]) {
        Person john = new Person("John", 40);
        Person mary = new Person("Mary", 30);

        Sorter sorter = new Sorter();
        Person person = (Person) sorter.min(john, mary);

        System.out.println(person);
    }

    /** 
     * Compares a person and as a result of lower returns 
     * 
     * @param one first object in the comparison
     * @param two second object in the comparison
     * @return less of two objects given by method parameters
     */
    public Sortable min(Sortable one, Sortable two) {
        if (one.less(two)) {
            return one;
        }

        return two;
    }
}
