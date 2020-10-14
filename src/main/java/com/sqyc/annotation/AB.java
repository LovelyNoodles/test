package com.sqyc.annotation;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@A
@B
public @interface AB {

//    @AliasFor(attribute = "value", annotation = A.class)
//    String value() default "";

//    @AliasFor(attribute = "value", annotation = A.class)
//    String[] value() default {};

}
