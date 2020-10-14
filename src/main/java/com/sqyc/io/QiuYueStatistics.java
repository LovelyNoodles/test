package com.sqyc.io;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class QiuYueStatistics {

    @Test
    public void test1() {
        List<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("C:\\Users\\16095\\Desktop\\test.txt")))) {
            String name;
            while (StringUtils.isNotBlank((name = reader.readLine()))) {
                if (name.contains("*2")) {
                    name = name.replace("*2", "").replace("\"", "");
                    list.add(name);
                    list.add(name);
                } else {
                    list.add(name);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Map<String, Long> collect = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        List<Map.Entry<String, Long>> sorted = collect.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder())).collect(Collectors.toList());
        for (Map.Entry<String, Long> entry : sorted) {
            System.out.println(entry.getKey() + "   次数:" + entry.getValue() + "     金额：" + entry.getValue() * 20);
        }

        System.out.println("总数：" + list.size());
        System.out.println("总金额：" + list.size() * 20);
    }


    @Test
    public void test2() {
        List<String> list = new ArrayList<>();
        list.add("abc");
        list.add("yyp");
        list.add("yyp");
        list.add("234");
        list.add("yyp");
        list.add("234");
        list.add("234");
        list.add("234");

        Map<String, Long> collect = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect);

        List<Map.Entry<String, Long>> sorted = collect.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder())).collect(Collectors.toList());
        System.out.println(sorted);

    }
}
