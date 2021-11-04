package com.sqyc.jvm.shizhanjvm.no8;

import java.util.ArrayList;
import java.util.List;

public class ThreadUnSafe {

    public static List<Integer> numberList = new ArrayList<>();
//    public static List<Integer> numberList = new Vector<>();

    public static class AddToList implements Runnable {

        int startNum = 0;

        public AddToList(int startNum) {
            this.startNum = startNum;
        }

        @Override
        public void run() {
            int count = 0;
            while (count < 100_0000) {
                numberList.add(startNum);
                startNum += 2;
                count++;
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new AddToList(0)).start();
        new Thread(new AddToList(1)).start();
    }
}
