package com.sqyc.jvm;

public class UseTLAB {

    public static void alloc() {
        byte[] b = new byte[2];
        b[0] = 1;
    }

    /**
     * -XX:+UseTLAB -Xcomp -XX:-BackgroundCompilation -XX:-DoEscapeAnalysis -server
     */
    public static void main(String[] args) {
        long b = System.currentTimeMillis();
        for (int i = 0; i < 1000_0000; i++) {
            alloc();
        }
        long e = System.currentTimeMillis();
        System.out.println(e - b);
    }
}
