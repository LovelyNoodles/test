//package com.sqyc.jvm.shizhanjvm.no8;
//
//import java.util.concurrent.CountDownLatch;
//import java.util.concurrent.atomic.AtomicLong;
//
//public class Atomic {
//
//    private static final int MAX_THREADS = 3;// 线程数
//    private static final int TASK_COUNT = 3;// 任务数
//    private static final int TARGET_COUNT = 1000_0000;// 目标总数
//
//    private AtomicLong  acount = new AtomicLong(0L);// 无锁的原子操作
//    private long count = 0;
//
//    static CountDownLatch  cdlsync = new CountDownLatch(TASK_COUNT);
//    static CountDownLatch  cdlatomic = new CountDownLatch(TASK_COUNT);
//
//    protected synchronized long inc() {
//        return ++count;
//    }
//
//    protected synchronized long getCount() {
//        return count;
//    }
//
//    public void clearCount() {
//        count = 0;
//    }
//
//    public class SyncThread implements Runnable {
//
//        protected String name;
//        protected long starttime;
//        AtomicLess out;
//
//        public SyncThread(long starttime, AtomicLess out) {
//            this.starttime = starttime;
//            this.out = out;
//        }
//
//        @Override
//        public void run() {
//            out.getCount();
//        }
//    }
//
//
//
//}
