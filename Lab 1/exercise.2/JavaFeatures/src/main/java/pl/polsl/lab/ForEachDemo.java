package pl.polsl.lab;

import java.util.*;

/**
 * ForEachDemo feature.
 *
 * @author Gall Anonim
 * @version 1.1
 */
public class ForEachDemo {

    public static void main(String[] args) {
        // Array iteration
        int[] tab = {2, 3, 5, 1, 7, 3, 3, 7, 5, 7};
        int sum = 0;
        for (int element : tab) {
            sum += element;
        }
        System.out.println(sum);

        // iterating through the collection
        List<String> list = new ArrayList<>();
        list.add("cat");
        list.add("dog");
        list.add("mouse");
        System.out.print("List: ");
        for (String element : list) {
            System.out.print(element + ", ");
        }
        System.out.println();

        // iterating through the collection
        TreeSet<String> tree = new TreeSet<>();
        tree.add("cat");
        tree.add("dog");
        tree.add("mouse");
        System.out.print("Tree: ");
        for (String element : tree) {
            System.out.print(element + ", ");
        }
        System.out.println();

        // iterating through the collection
        Person worker = new Person("Jan", "Nowak", 29, 2222.2f);
        System.out.print("Person: ");
        for (String atrybut : worker) {
            System.out.print(atrybut + ", ");
        }
        System.out.println();

        System.out.println("toString: " + worker);

    }
}

class Person implements Iterable<String>, Iterator<String> {

    private String name, surname;
    private int age;
    private float salary;
    private int index;

    public Person(String name, String surname, int age, float salary) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public Iterator<String> iterator() {
        index = 0;
        return this;
    }

    @Override
    public boolean hasNext() {
        return index < 4;
    }

    @Override
    public String next() {
        switch (index++) {
            case 0:
                return name;
            case 1:
                return surname;
            case 2:
                return "" + age;
            case 3:
                return "" + salary;
            default:
                return null;
        }
    }

    @Override
    public void remove() {
    }

    public String toString() {
        return name + ", " + surname + ", " + age + ", " + salary;
    }

}
