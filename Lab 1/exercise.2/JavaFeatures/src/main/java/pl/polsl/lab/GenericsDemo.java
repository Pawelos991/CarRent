package pl.polsl.lab;

import java.util.*;

/**
 * GenericsDemo features
 *
 * @author Gall Anonim
 * @version 1.1
 */
public class GenericsDemo {

  
    public static void main(String[] args) {

        // standard collection
        List list = new ArrayList();
        list.add(66);
        list.add(13);
        // The compiler doesn't check the type of argument 
        list.add("cat");
        int sum = 0;
        for (Object element : list) {
            sum += (Integer) element;
        }
        System.out.println("Sum = " + sum);

        // Type-safe collection  
        List<Integer> safeList = new ArrayList<>();
        safeList.add(66);
        safeList.add(13);
        // The compiler checks the type of argument. Uncomment next line! 
        // safeList.add("cat");
        for (int element : safeList) {
            sum += element;
        }
        System.out.println("Sum = " + sum);

        // own generic type
        Box<String> stringBox = new Box<>();
        NumberBox<Integer> numberBox = new NumberBox<>();
        numberBox.add(13);
        numberBox.add(7);
        System.out.println("sum = " + numberBox.sum());

        //NumberBox<String> stringBoxOfNumberBox = new NumberBox<String>();
    }
}

class Box<T> {

    List<T> contents;
}

class NumberBox<N extends Number> {

    List<N> contents;

    NumberBox() {
        contents = new LinkedList<>();
    }

    public void add(N obj) {
        contents.add(obj);
    }

    public N get(int index) {
        return contents.get(index);
    }

    public double sum() {
        double total = 0;
        Iterator<N> i = contents.iterator();
        while (i.hasNext()) {
            total += ((Integer) i.next()).doubleValue();
        }
        return total;
    }
}
