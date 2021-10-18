package com.sqyc.jvm;

import org.junit.Test;

public class NewSizeTest {

    public static void main(String[] args) {
        byte[] b = null;
        for (int i = 0; i < 10; i++) {
            b = new byte[1 * 1024 * 1024];
        }
    }

    @Test
    public void test() {
        int old = 19456;
        int xxn = 1024;
        System.out.println((old + xxn) / 1024);

        System.out.println(7 * 1024);
        System.out.println(18 * 1024);
        System.out.println(18688 / 1024);

        System.out.println(12288/1024);
        System.out.println(15/2);
    }
}
