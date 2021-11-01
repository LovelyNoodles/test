package com.sqyc.jvm.shizhanjvm.no7;

import java.util.ArrayList;

public class StringInternOOM {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }

}
