package com.sqyc.jvm.shizhanjvm.no11;

import org.junit.Test;

public class Calc {
    public int calc() {
        int a = 500;
        int b = 200;
        int c = 50;
        return (a + b) / c;
    }

    /**
     * 常量入栈指令
     */
    @Test
    public void test() {
        System.out.println(Short.MAX_VALUE);
        System.out.println(Short.MIN_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }

    /**
     * xaload 指令
     */
    @Test
    public void test2() {
        print(new int[]{1}, new char[]{'c'}, new short[]{2});
    }

    private void print(int[] i, char[] c, short[] s) {
        System.out.println(i[0]);
        System.out.println(c[0]);
        System.out.println(s[0]);
    }


    /**
     * xneg 指令
     */
    @Test
    public void test3() {
        float i = 8;
        float j = -i;
        i = -j;
    }


    /**
     * iadd
     */
    @Test
    public void test4() {
        int i = 123;
        i = i + 10;
    }

    /**
     * iinc
     */
    @Test
    public void test5() {
        int i = 123;
        i++;
        ++i;
        i--;
        --i;

        int j1 = i++;
        int j2 = ++i;
        int j3 = i--;
        int j4 = --i;
    }

}
