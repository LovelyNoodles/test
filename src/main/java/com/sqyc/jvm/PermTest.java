package com.sqyc.jvm;

public class PermTest {

    public static void main(String[] args) {
        int i = 0;
        for (int j = 0; j < 10_0000; j++) {
            try {
//                CglibBean bean = new CglibBean("" + i, new HashMap<>());

            } catch (Exception e) {
                System.out.println("total create count:" + i);
            }
        }
    }
}
