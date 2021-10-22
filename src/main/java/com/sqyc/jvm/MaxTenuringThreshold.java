package com.sqyc.jvm;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * -Xmx1024m -Xms1024m -XX:+PrintGCDetails -XX:MaxTenuringThreshold=15 -XX:+PrintHeapAtGC
 */
public class MaxTenuringThreshold {
    public static final int _1M = 1024 * 1024;
    public static final int _1K = 1024;

    public static void main(String[] args) {
        Map<Object, Object> map = new HashMap<>();
        for (int i = 0; i < 5 * _1K; i++) {
            byte[] b = new byte[_1K];
            map.put(i, b);
        }

        for (int i = 0; i < 17; i++) {
            for (int j = 0; j < 270; j++) {
                byte[] g = new byte[_1M];
            }
        }
    }

    @Test
    public void test() {
        System.out.println("年轻代");
        long yd = 0x00000000eab00000L;
        long yu = 0x0000000100000000L;
        System.out.println(yu - yd);
        System.out.println((yu - yd) / 1024);
        System.out.println((yu - yd) / 1024 / 1024);
        System.out.println(341 * 1024 * 1024);// 是否整除
        System.out.println(305664 / 1024);


        System.out.println("老年代");
        long od = 0x00000000c0000000L;
        long ou = 0x00000000eab00000L;
        System.out.println(ou - od);
        System.out.println((ou - od) / 1024 / 1024);


        System.out.println("验算堆大小");
        System.out.println((yu - od));
        System.out.println((yu - od) / 1024 / 1024 );
        System.out.println((yu - od) / 1024 / 1024 / 1024);


        System.out.println("堆空间(M):" + 1073741824 / 1024 / 1024 / 1024);

        System.out.println((305664 + 699392) / 1024);

    }
}
