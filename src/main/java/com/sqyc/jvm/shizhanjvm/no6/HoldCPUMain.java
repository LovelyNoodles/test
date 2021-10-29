package com.sqyc.jvm.shizhanjvm.no6;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class HoldCPUMain {

    public static class HoldCPUTask implements Runnable {
        @Override
        public void run() {
            while (true) {
                double a = Math.random() * Math.random();// 占用CPU
            }
        }
    }


    public static class HoldIOTask implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    FileOutputStream fos = new FileOutputStream(new File("temp"));
                    for (int i = 0; i < 1_0000; i++) {
                        fos.write(i);// 大量的写操作
                    }
                    fos.close();
                    FileInputStream fis = new FileInputStream(new File("temp"));
                    while (fis.read() != -1) ;// 大量的读操作
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class LazyTask implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {// 空闲线程
                }
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new HoldCPUTask()).start();// 开启线程，占用CPU
        new Thread(new LazyTask()).start();// 空闲线程
        new Thread(new LazyTask()).start();// 空闲线程
        new Thread(new LazyTask()).start();// 空闲线程

//        new Thread(new HoldIOTask()).start();// 开启占用IO的线程
//        new Thread(new LazyTask()).start();// 开启空闲线程
//        new Thread(new LazyTask()).start();
//        new Thread(new LazyTask()).start();
    }


}

