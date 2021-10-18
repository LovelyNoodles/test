package com.sqyc.jvm;


import org.junit.Test;

import java.util.ArrayList;

public class JvmAgrsTest {

    /**
     * -Xmx20m
     * -Xms5m
     * -XX:+PrintCommandLineFlags
     * -XX:+PrintGCDetails
     * -XX:+UseSerialGC
     */
    @Test
    public void 打印系统参数() {
        System.out.println("max memory=" + Runtime.getRuntime().maxMemory() + " bytes");
        System.out.println("free memory=" + Runtime.getRuntime().freeMemory() + " bytes");
        System.out.println("total memory=" + Runtime.getRuntime().totalMemory() + " bytes");

        byte[] b = new byte[1024 * 1024];
        System.out.println("分配 1M 空间给数组");

        System.out.println("max memory=" + Runtime.getRuntime().maxMemory() + " bytes");
        System.out.println("free memory=" + Runtime.getRuntime().freeMemory() + " bytes");
        System.out.println("total memory=" + Runtime.getRuntime().totalMemory() + " bytes");

        b = new byte[4 * 1024 * 1024];
        System.out.println("分配 4M 空间给数组");

        System.out.println("max memory=" + Runtime.getRuntime().maxMemory() + " bytes");
        System.out.println("free memory=" + Runtime.getRuntime().freeMemory() + " bytes");
        System.out.println("total memory=" + Runtime.getRuntime().totalMemory() + " bytes");

    }

    /**
     * jclasslib查看局部变量表
     */
    @Test
    public void 局部变量表_槽位复用() {
        {
            int a = 1;
            System.out.println("变量a");
        }
        int b = 1;
    }

    /**
     *
     */
    @Test
    public void 堆信息dump() {
        ArrayList<Object> objects = new ArrayList<>(25);
        for (int i = 0; i < 25; i++) {
            objects.add(new byte[1 * 1024 * 1024]);
        }
    }


}
