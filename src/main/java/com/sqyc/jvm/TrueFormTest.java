package com.sqyc.jvm;


import org.junit.Test;

class TrueFormTest {
    @Test
    public void 打印整数储存格式() {
        int a = -10;// 计算机存的是补码
        for (int i = 0; i < 32; i++) {
            int t = (a & 0x80000000 >>> i) >>> (31 - i);
            System.out.print(t);
        }
        System.out.println();
        System.out.println(Integer.toBinaryString(a));
    }

    @Test
    public void 打印float比特位格式() {
        float f = -5;
        System.out.println(Integer.toBinaryString(Float.floatToRawIntBits(f)));
    }

}
