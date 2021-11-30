package pl.polsl.lab;

import java.util.*;
// import of static class members!
import static java.util.Collections.*;

/**
 * This demo resents set of useful methods operating on collections.
 *
 * @author Gall Anonim
 * @version 1.1
 */
public class CollectionFeaturesDemo {

    public static void main(String args[]) {

        Integer[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<Integer> list = new ArrayList<>();

        addAll(list, array);
        System.out.println("init:      " + list);
        shuffle(list);
        System.out.println("shuffled:  " + list);
        sort(list);
        System.out.println("sorted:    " + list);
        rotate(list, 3);
        System.out.println("rotated:   " + list);
        sort(list);
        System.out.println("sorted:    " + list);
        reverse(list);
        System.out.println("reversed:  " + list);
        swap(list, 1, 2);
        System.out.println("swapped:   " + list);
        replaceAll(list, 0, 7);
        System.out.println("replaced:  " + list);
        System.out.println("Maximum:   " + max(list));
        System.out.println("Minimum:   " + min(list));
        System.out.println("element '7' exists " + frequency(list, 7) + " times");
    }
}
