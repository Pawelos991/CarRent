package pl.polsl.lab;

import pl.polsl.lab.annotations.Description;
import java.lang.reflect.*;
import java.util.*;

/**
 * Annotation feature.
 *
 * @author Gall Anonim
 * @version 1.1
 *
 */
public class AnnotationsDemo {

    public static void main(String[] args) {
        Sub sub = new Sub();

        // deprecated method
        sub.deprecatedMethod();

        // read your own annotation
        try {
            Class<?> c = Class.forName("pl.polsl.lab.Sub");
            AnnotatedElement element = c.getMethod("describedMethod");
            if (element.isAnnotationPresent(Description.class)) {
                Description desc = element.getAnnotation(Description.class);
                String who = desc.author();
                System.out.println("Author of method is " + who);
                String item = desc.item();
                System.out.println("Item: " + item);
                Description.Importance importance = desc.importance();
                System.out.println("Importance: " + importance);
            } else {
                System.out.println("No annotation!");
            }
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            System.err.println(e.getMessage());
        }
    }
}

// Use of standard annotations
class Base {

    void overriddenMethod() {
    }
}

class Sub extends Base {

    List list;

    Sub() {
        list = new ArrayList();
    }

    @Override
    public void overriddenMethod() {
    }

    //@Deprecated
    void deprecatedMethod() {
    }

    //@SuppressWarnings("unchecked")
    public void collect(Object obj) {
        list.add(obj);
    }

    @Description(importance = Description.Importance.LOW, item = "Sample method decription", author = "NOWAK")
    public void describedMethod() {
    }
}
