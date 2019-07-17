package com.sqyc.io;

import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class WriteFileTest {
    
    @Test
    public void test1() throws IOException {
        //写入相应的文件
        OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream("C:\\Users\\16095\\Desktop\\text.txt"));
        //循环取出数据
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("d");

        for (String s : list) {
            //写入相关文件
            out.write(s);
            out.write("\t\n");
        }
        //清楚缓存
        out.flush();
        out.close();
    }

}
