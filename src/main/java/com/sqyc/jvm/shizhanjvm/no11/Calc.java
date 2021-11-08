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
        System.out.println(i.length);
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

    /**
     * new 指令
     */
    @Test
    public void test6() {
        Calc calc = new Calc();
        Calc[] calcs = new Calc[2];
        short[] shorts = new short[2];
        int[] ints = new int[2];
        Object[] objects = new Object[2];


        Object[][] objects1 = new Object[1][2];
        int[][] ints1 = new int[1][2];

    }

    String name;
    static int i;

    /**
     * getfield/putfield/getstatic/putstatic
     */
    @Test
    public void test7() {
        new Calc().test();
        Calc calc = new Calc();
        calc.name = "abc";
        Calc.i = 10;
        System.out.println("abc");
    }


    /**
     * checkcast/instanceof
     */
    @Test
    public void test8() {
        checkcast(null);
    }

    private String checkcast(Object object) {
        if (object instanceof String) {
            return ((String) object);
        } else {
            return null;
        }
    }

    /**
     * if
     */
    @Test
    public void test9() {
        int i = 0;
        if (i < 0) {
            i = -1;
        } else if (i == 0) {
            i = 0;
        } else {
            i = 1;
        }
        System.out.println(i);
    }

    /**
     * switch
     */
    @Test
    public void test10() {
        int i = 0;
        switch (i) {
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
        }

        switch (i) {
            case 400:
                break;
            case 500:
                break;
            case 600:
                break;
        }

        switch4("");
    }

    private void switch4(String s) {
        switch (s) {
            case "aaa":
                System.out.println(s);
                break;
            case "bbb":
                System.out.println(s);
                break;
            case "ccc":
                System.out.println(s);
                break;
            case "ddd":
                System.out.println(s);
                break;
            case "eee":
                System.out.println(s);
                break;
            case "fff":
                System.out.println(s);
                break;
            case "ggg":
                System.out.println(s);
                break;
            default:
        }
    }


}

