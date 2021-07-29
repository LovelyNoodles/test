package com.sqyc.algorithm.binary;

import org.junit.Test;

public class BinaryTemp {

    @Test
    public void test1() {
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
        System.out.println(Integer.valueOf("40000000", 16));
        System.out.println(Integer.toBinaryString(Integer.valueOf("40000000", 16)));
        // 0b01000000_00000000_00000000_00000000
        // 1073741824

        // 1073741824   536870912
        // 0b01000000_00000000_00000000_00000000
        // 0b00100000_00000000_00000000_00000000
    }

    @Test
    public void test2() {
        short a = (short) 34520;
        System.out.println(Integer.toBinaryString(a));
        a = (short) (((a & 0xAAAA) >> 1) | ((a & 0x5555) << 1));
        System.out.println(Integer.toBinaryString(a) + "奇数位：" + Integer.toBinaryString(0xAAAA) + "偶数位：" + Integer.toBinaryString(0x5555));
        a = (short) (((a & 0xCCCC) >> 2) | ((a & 0x3333) << 2));
        System.out.println(Integer.toBinaryString(a) + "奇数位：" + Integer.toBinaryString(0xCCCC) + "偶数位：" + Integer.toBinaryString(0x3333));
        a = (short) (((a & 0xF0F0) >> 4) | ((a & 0x0F0F) << 4));
        System.out.println(Integer.toBinaryString(a) + "奇数位：" + Integer.toBinaryString(0xF0F0) + "偶数位：" + Integer.toBinaryString(0x0F0F));
        a = (short) (((a & 0xFF00) >> 8) | ((a & 0x00FF) << 8));
        System.out.println(Integer.toBinaryString(a) + "奇数位：" + Integer.toBinaryString(0xFF00) + "偶数位：" + Integer.toBinaryString(0x00FF));

        // 1000011011011000
        // 0001101101100001

    }

    @Test
    public void test3() {
        int a = 34520;
        System.out.println(Integer.toBinaryString(a));
        int count = 0;
        while (a > 0) {
            a = a & (a - 1);
            System.out.println(Integer.toBinaryString(a));
            count++;
        }
        System.out.println(count);
    }

    @Test
    public void test4() {

    }

}
