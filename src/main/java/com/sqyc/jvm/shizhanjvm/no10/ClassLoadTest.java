package com.sqyc.jvm.shizhanjvm.no10;

import org.junit.Test;

public class ClassLoadTest {

    private String str1 = "a";
    private static String str2 = "b";
    private static int i1;
    private static int i2 = 2;
    private static final String str3 = "c";

    static {
        str2 = "bb";
        System.out.println(i1);
        System.out.println(i2);
    }

    @Test
    public void test() {
        System.out.println("test");
    }

}
