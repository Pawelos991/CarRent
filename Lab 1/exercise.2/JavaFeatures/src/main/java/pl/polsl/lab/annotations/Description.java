package pl.polsl.lab.annotations;

import java.lang.annotation.*;

/**
 * Description interface. The annotation consists of the internal enumeration
 * and three attributes.
 *
 * @author Gall Anonim
 * @version 1.1
 *
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Description {

    public enum Importance {

        HIGH, AVERAGE, LOW
    };

    Importance importance() default Importance.AVERAGE;

    String item();

    String author();
}
