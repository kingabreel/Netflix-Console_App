package org.proway.util.annotations;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Doc {
    String author();
    String date();
    String version() default "1.0";
    String description() default "";
}
