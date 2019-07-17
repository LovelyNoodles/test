package com.sqyc.jvm;


import org.junit.Test;

class JvmAgrsTest {

    @Test
    public void 打印系统参数() {
        System.out.println("max memory=" + Runtime.getRuntime().maxMemory() + " bytes");
        System.out.println("free memory" + Runtime.getRuntime().freeMemory() + " bytes");
        System.out.println("total memory" + Runtime.getRuntime().totalMemory() + " bytes");

        byte[] b = new byte[1024 * 1024];
        System.out.println("分配 1M 空间给数组");

        System.out.println("max memory=" + Runtime.getRuntime().maxMemory() + " bytes");
        System.out.println("free memory" + Runtime.getRuntime().freeMemory() + " bytes");
        System.out.println("total memory" + Runtime.getRuntime().totalMemory() + " bytes");

        b = new byte[4 * 1024 * 1024];
        System.out.println("分配 4M 空间给数组");

        System.out.println("max memory=" + Runtime.getRuntime().maxMemory() + " bytes");
        System.out.println("free memory" + Runtime.getRuntime().freeMemory() + " bytes");
        System.out.println("total memory" + Runtime.getRuntime().totalMemory() + " bytes");

    }

}
