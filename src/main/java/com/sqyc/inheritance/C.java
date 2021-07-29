package com.sqyc.inheritance;

public class C extends B {

    public void print() {
        System.out.println(C.class.getSimpleName());
    }

    public void customPrint() {
//        A.this.print();
    }

}
