package com.sqyc;

import org.junit.Test;

import java.util.*;
import java.util.function.Function;

public class TestTemp {

    @Test
    public void test1() {
        long begin = System.currentTimeMillis();
//        System.out.println(multiply("0", "0"));
//        System.out.println(multiply("2", "3"));
        System.out.println(multiply("123", "456"));
//        System.out.println(multiply("13249871239412983", "1192834129873182"));
//        System.out.println(multiply("6964594125027226699998128707627435007621143975736747759751", "333791918659904899647584436187733004125181273682766434"));
        System.out.println(System.currentTimeMillis() - begin);
    }

    public String multiply(String num1, String num2) {
        int length1 = num1.length();
        int length2 = num2.length();
        if (length1 == 0 || length2 == 0) {
            return "";
        }
        Function<String, Integer> func = str -> {
            int index = 0;
            while (index < str.length() && str.charAt(index) == '0') {
                index++;
            }
            return index;
        };

        if (func.apply(num1) == num1.length() || func.apply(num2) == num2.length()) {
            return "0";
        }

        String result = "";
        for (int b = 0; b < length2; b++) {
            for (int a = 0; a < length1; a++) {
                int n2 = Character.digit(num2.charAt(length2 - 1 - b), 10);
                int n1 = Character.digit(num1.charAt(length1 - 1 - a), 10);
                StringBuilder temp = new StringBuilder(String.valueOf(n1 * n2));
                if (a + b > 0) {
                    for (int i = 0; i < a + b; i++) {
                        temp.append(0);
                    }
                }

                result = add(result, temp.toString());
            }
        }

        return result.substring(func.apply(result));
    }

    private String add(String result, String temp) {
        StringBuilder add = new StringBuilder();
        for (int i = 0; i < Math.max(result.length(), temp.length()); i++) {
            int e = i < add.length() ? Character.digit(add.charAt(add.length() - 1 - i), 10) : 0;
            int n1 = i < result.length() ? Character.digit(result.charAt(result.length() - 1 - i), 10) : 0;
            int n2 = i < temp.length() ? Character.digit(temp.charAt(temp.length() - 1 - i), 10) : 0;

            String n = String.valueOf(n1 + n2 + e);
            if (e == 0) {
                add.insert(0, n);
            } else {
                add.replace(0, 1, n);
            }
        }

        return add.toString();
    }

    @Test
    public void test() {
        System.out.println(new StringBuilder("12345").replace(1, 3, "abcdefg"));
        System.out.println(add("123", "99"));
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

}