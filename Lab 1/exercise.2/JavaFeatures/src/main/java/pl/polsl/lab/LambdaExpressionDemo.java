package pl.polsl.lab;

import java.util.*;

/**
 * Simple demonstration of lambda expression
 *
 * @author Gall Anonim
 * @version 1.1
 */
public class LambdaExpressionDemo {

    // specification of the lambda expression with two parameters
    interface IntegerMath {

        int operation(int a, int b);
    }

    // lambda expression as a parameter
    int operateBinary(int a, int b, IntegerMath op) {
        return op.operation(a, b);
    }

    public static void main(String[] args) {

        LambdaExpressionDemo mainObject = new LambdaExpressionDemo();
        // implementations of the lambda expressions
        IntegerMath addition = (a, b) -> a + b;
        // or 
        IntegerMath subtraction = (a, b) -> {
            return a - b;
        };

        System.out.println("40 + 2 = "
                + mainObject.operateBinary(40, 2, addition));
        System.out.println("20 - 10 = "
                + mainObject.operateBinary(20, 10, subtraction));

        // prnting the list - old way
        List<Integer> oldList = Arrays.asList(1, 2, 3, 4);
        for (Integer n : oldList) {
            System.out.println("old: " + n);
        }

        // printing the list with lamda expression
        List<Integer> newList = Arrays.asList(1, 2, 3, 4);
        newList.forEach(n -> System.out.println("new: " + n));

        // simplification with double colon operator 
        newList.forEach(System.out::println);
    }
}
