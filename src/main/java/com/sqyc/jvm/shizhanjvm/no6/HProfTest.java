package com.sqyc.jvm.shizhanjvm.no6;

public class HProfTest {

    public void slowMethod() {
        try {
            Thread.sleep(1000);// 模拟一个很慢的方法
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void slowerMethod() {
        try {
            Thread.sleep(10000);// 模拟一个更慢的方法
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void fastMethod() {
        try {
            Thread.yield();// 一个很快的方法
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        HProfTest test = new HProfTest();
        test.fastMethod();// 分别运行这些方法
        test.slowMethod();
        test.slowerMethod();
    }

}
