package com.sqyc.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest extends Thread {
    public static void main(String[] args) {
        // https://www.cnblogs.com/xrq730/p/4979021.html
        // CountDownLatch、CyclicBarrier、Sempahore

        ReentrantLock reentrantLock = new ReentrantLock();
        LockTest t1 = new LockTest("TryLockTest1");
        LockTest t2 = new LockTest("TryLockTest2");

        t1.start();
        t2.start();
    }

    public static ReentrantLock lock = new ReentrantLock();

    public LockTest(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            if (lock.tryLock(5, TimeUnit.SECONDS)) {
                Thread.sleep(6000);
            } else {
                System.out.println(this.getName() + " get lock failed");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (lock.isHeldByCurrentThread()) {
                System.out.println("lock.isHeldByCurrentThread: " + this.getName());
                lock.unlock();
            }
        }
    }

}
