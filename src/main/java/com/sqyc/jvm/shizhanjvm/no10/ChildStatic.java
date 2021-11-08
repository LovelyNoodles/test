package com.sqyc.jvm.shizhanjvm.no10;

public class ChildStatic extends SimpleStatic {

    static {
        number = 2;
    }

    public static void main(String[] args) {
        System.out.println(number);
    }
}
