package com.sqyc.annotation;

import com.alibaba.fastjson.JSON;

import java.lang.annotation.Annotation;

@AB
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Class<? extends Main> clazz = main.getClass();
        Annotation[] declaredAnnotations = clazz.getDeclaredAnnotations();
        for (Annotation annotation : declaredAnnotations) {
            System.out.println(JSON.toJSONString(annotation));
        }

        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(JSON.toJSONString(annotation));
        }

        System.out.println(JSON.toJSONString(clazz.getAnnotation(A.class)));
        System.out.println(JSON.toJSONString(clazz.getAnnotation(B.class)));

    }
}
