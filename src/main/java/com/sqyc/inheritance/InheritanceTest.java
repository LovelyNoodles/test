package com.sqyc.inheritance;

import org.junit.Test;

public class InheritanceTest {

    @Test
    public void test1() {
        A a = new A();
        A.As as = a.new As();
        as.print();

    }
}
