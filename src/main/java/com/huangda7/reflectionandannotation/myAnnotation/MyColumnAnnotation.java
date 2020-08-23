package com.huangda7.reflectionandannotation.myAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyColumnAnnotation {
    String value() default "";
    String type() default "";
    int length() default 0;
}
