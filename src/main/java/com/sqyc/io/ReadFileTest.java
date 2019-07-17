package com.sqyc.io;

import org.junit.Test;

import java.io.*;

public class ReadFileTest {

    @Test
    public void test1() {
        String path1 = "C:\\Users\\16095\\Desktop\\codedeal\\沃兰多2天券\\";
        String path2 = "C:\\Users\\16095\\Desktop\\codedeal\\沃兰多5天券\\";
        String path3 = "C:\\Users\\16095\\Desktop\\codedeal\\沃兰多7天券\\";
        String path4 = "C:\\Users\\16095\\Desktop\\codedeal\\沃兰多15天券\\";
        String path5 = "C:\\Users\\16095\\Desktop\\codedeal\\沃兰多30天券\\";

        dealCouponCodes(path1);
        dealCouponCodes(path2);
        dealCouponCodes(path3);
        dealCouponCodes(path4);
        dealCouponCodes(path5);
    }

    @Test
    public void test2(){
        String path1 = "C:\\Users\\16095\\Desktop\\test\\";
        dealCouponCodes(path1);
    }

    @Test
    public void test3(){
        String path1 = "C:\\Users\\16095\\Desktop\\dev\\";
        dealCouponCodes(path1);
    }

    private void dealCouponCodes(String path) {
        String code;
        long tempCode = 0L;
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(path + "coupon_codes.txt")));
             OutputStreamWriter invalidWriter = new OutputStreamWriter(new FileOutputStream(path + "code_invalid.txt"));
             OutputStreamWriter validWriter = new OutputStreamWriter(new FileOutputStream(path + "code_valid.txt"))) {
            while ((code = reader.readLine()) != null) {
                long aLong = Long.valueOf(code);
                if ((++tempCode) == aLong) {
                    //写入无效文件
                    invalidWriter.write(String.valueOf(aLong));
                    invalidWriter.write("\t\n");
                } else {
                    tempCode = aLong;
                    //写入有效文件
                    validWriter.write(String.valueOf(aLong));
                    validWriter.write("\t\n");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
