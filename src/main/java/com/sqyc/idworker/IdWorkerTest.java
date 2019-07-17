package com.sqyc.idworker;

import com.imadcn.framework.idworker.generator.IdGenerator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/idworker.xml")
public class IdWorkerTest {

    @Autowired
    public IdGenerator generator;

    @Test
    public void id() {
        long id = generator.nextId(); // Long型ID(64进制UUID不支持)，随着时间推移，ID长度为7-19位
        long[] ids = generator.nextId(100_000); // 批量Long型ID(64进制UUID不支持)，最多10w个

        String strId = generator.nextStringId(); // 字符串格式ID
        String fixedId = generator.nextFixedStringId(); // 固定19位长度字符串Id

        System.out.println(id);
        System.out.println(strId);
        System.out.println(fixedId);
        System.out.println(1234);
    }

    @Test
    public void test() throws IOException {
        int count = 2200_0000;
        Set<Long> set = new HashSet<>();

        //写入相应的文件
        OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream("C:\\Users\\16095\\Desktop\\text.txt"));

        LinkedList<Long> longs = new LinkedList<>();
        for (int i = 0; i < count; i++) {
            long id = generator.nextId();

            //写入相关文件
            out.write(String.valueOf(id));
            out.write("\t\n");

            if (!set.add(id)) {
                longs.add(id);
            }
            System.out.println(id);
        }

        System.out.println(longs);
        System.out.println("end");

        //清楚缓存
        out.flush();
        out.close();
    }

    @Test
    public void test2() {
        for (int i = 0; i < 100; i++) {
            long id = generator.nextId();
            String str = String.valueOf(id);
            System.out.println(id);
            System.out.println(str.length());
        }
    }

    @Test
    public void test3(){
        System.out.println(123%1);
        System.out.println(123%4);
        System.out.println(123%99);
    }
}
