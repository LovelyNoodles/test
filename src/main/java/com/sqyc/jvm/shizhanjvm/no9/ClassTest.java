package com.sqyc.jvm.shizhanjvm.no9;

import org.junit.Test;

@Deprecated
public class ClassTest {


    /**
     * access_flags是通过多个标记值进行或（|）操作，计算出最后的access_flag值的
     */
    @Test
    public void test1() {
        int ACC_PUBLIC = 0x0001;
        int ACC_STATIC = 0x0008;
        int ACC_FINAL = 0x0010;

        System.out.println(Integer.toHexString(ACC_FINAL | ACC_STATIC | ACC_PUBLIC));
        System.out.println(Integer.toBinaryString(ACC_FINAL | ACC_STATIC | ACC_PUBLIC));


        System.out.println(0x0001);
        System.out.println(0x0002);
        System.out.println(0x0004);
        System.out.println(0x0008);
        System.out.println(0x0010);
        System.out.println(0x0040);
        System.out.println(0x0080);
        System.out.println(0x1000);
        System.out.println(0x4000);

    }


    @Test
    public void test2() throws Exception, RuntimeException {
        int a = 1;
        try {
            a = a / 0;
            System.out.println(a);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(a);
        }
    }


    /**
     * StackMapTable
     */
    public static void append1() {
        int i = 0;
        int j = 0;
        if (i > 0) {
            j++;
        }
    }

    @Deprecated
    public static void append2() {
        int i = 0;
        int j = 0;
        if (i > 0) {
            long k = 0;
            if (j == 0) {
                k++;
            }
            int t = 0;

        }
    }


    /**
     * InnerClasses
     */
    public static class Inner {

        private String name;

        class Son {
            private int i;
        }

    }
}

