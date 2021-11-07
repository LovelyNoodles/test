package com.sqyc;

import org.junit.Test;

import java.util.*;

public class TestTemp {

    @Test
    public void test1() {
        System.out.println(multiply("2", "3"));
        System.out.println(multiply("123", "456"));
    }

    public String multiply(String num1, String num2) {
        int length1 = num1.length();
        int length2 = num2.length();
        if (length1 == 0 || length2 == 0) {
            return "";
        }
        int[] result = new int[length1 + length2];
        for (int i = 0; i < result.length; i++) {
            result[i] = 0;
        }

        for (int b = length2 - 1; b >= 0; b--) {
            for (int a = length1 - 1; a >= 0; a--) {
                int weight = 0;
            }
        }


        return "";
    }


    @Test
    public void test2() {

        Random random = new Random();
        List<Integer> objects = new ArrayList<>(15);
        int[] pre = {-1, 1};
        for (int j = 0; j < 10; j++) {
            objects.add(pre[(random.nextInt(1000)) & 1] * random.nextInt(10));
        }
        System.out.println(objects);
        objects.sort(Integer::compareTo);
        System.out.println(objects);
    }

    @Test
    public void test3() {
        HashMap<Object, Object> map = new HashMap<>(4);

        Integer a = 0b0000_0000_0000_0000__0000_0000_0000_1010;
        Integer b = 0b0000_0000_1000_0000__0000_0000_0000_1010;
        Integer c = 0b0000_1000_0000_0000__0000_0000_0000_1010;
        Integer d = 0b0000_1000_1000_0000__0000_0000_0000_1010;
//        Integer a = 0b0000_0000_0000_0000__0000_0000_0000_1010;
//        Integer b = 0b0000_0000_0000_0100__0000_0000_0000_1010;

        map.put(a, a);
        map.put(b, b);
        map.put(c, c);
        map.put(d, d);
        System.out.println(map);
    }

    @Test
    public void test4() {
        Map<Object, Object> map = new HashMap<>();
        Set<Map.Entry<Object, Object>> entries = map.entrySet();
        for (Map.Entry<Object, Object> entry : entries) {
            Object key = entry.getKey();
            Object value = entry.getValue();
        }
    }


    @Test
    public void test5() {
        System.out.println(Integer.toBinaryString(-1));
        System.out.println(Integer.toBinaryString(6));
        System.out.println(Integer.toBinaryString(-6));
    }

}