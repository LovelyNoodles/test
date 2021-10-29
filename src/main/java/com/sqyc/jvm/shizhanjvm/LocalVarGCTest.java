package com.sqyc.jvm.shizhanjvm;

public class LocalVarGCTest {

    public void localvarGc1() throws InterruptedException {
        byte[] a = new byte[6 * 1024 * 1024];
        System.gc();
    }

    public void localvarGc2() {
        byte[] a = new byte[6 * 1024 * 1024];
        a = null;
        System.gc();
    }

    public void localvarGc3() {
        {
            byte[] a = new byte[6 * 1024 * 1024];
        }
        System.gc();
    }

    public void localvarGc4() {
        {
            byte[] a = new byte[6 * 1024 * 1024];
        }
        int c = 10;
        System.gc();
    }

    public void localvarGc5() throws InterruptedException {
        localvarGc1();
        System.gc();
    }

    public static void main(String[] args) throws InterruptedException {
        LocalVarGCTest localVarGC = new LocalVarGCTest();
        localVarGC.localvarGc5();
    }

}
