package com.sqyc.jvm.shizhanjvm.no11;

public class SyncAdd {
    private int i = 0;

    public synchronized void add1() {
        i++;
    }

    public void add2() {
        synchronized (this) {
            i++;
        }
    }

    public static void main(String[] args) {
        SyncAdd syncAdd = new SyncAdd();
        syncAdd.add1();
        syncAdd.add2();
    }
}
