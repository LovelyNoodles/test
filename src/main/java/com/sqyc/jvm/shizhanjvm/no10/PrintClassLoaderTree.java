package com.sqyc.jvm.shizhanjvm.no10;

import org.junit.Test;

public class PrintClassLoaderTree {
    public static void main(String[] args) {
        ClassLoader classLoader = PrintClassLoaderTree.class.getClassLoader();
        while (classLoader != null) {
            System.out.println(classLoader);
            classLoader = classLoader.getParent();
        }
    }

    @Test
    public void test() throws ClassNotFoundException {
        System.out.println(String.class.getClassLoader());
        Class<?> aClass = PrintClassLoaderTree.class.getClassLoader().loadClass("com.sqyc.jvm.shizhanjvm.no10.ClassLoaderTest");

    }
}
