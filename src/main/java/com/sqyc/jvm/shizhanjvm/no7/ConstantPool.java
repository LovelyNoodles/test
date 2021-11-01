package com.sqyc.jvm.shizhanjvm.no7;

public class ConstantPool {

    public static void main(String[] args) {
        System.out.println(System.identityHashCode(("test" + Integer.toString(0))));
        System.out.println(System.identityHashCode(("test" + Integer.toString(0)).intern()));
//        System.gc();
        System.out.println(System.identityHashCode(("test" + Integer.toString(0)).intern()));
    }

}
