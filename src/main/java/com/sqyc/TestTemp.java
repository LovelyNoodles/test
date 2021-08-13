package com.sqyc;

import org.junit.Test;

import java.util.HashMap;

public class TestTemp {

    @Test
    public void test1() {
        System.out.println(Integer.toBinaryString(-1));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(-Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
//        System.out.println(myAtoi("  -babad"));


    }

    public String myAtoi(String s) {
        boolean start = false;
        boolean negative = false;// 是否为负数
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ('+' != c && '-' != c && (c < '0' || c > '9')) {// 决定数字部分的开始和结尾
                if (start) {
                    break;
                } else {
                    continue;
                }
            }
            start = true;

            if (c == '-' || c == '+' || (c > '0' && c < '9')) {
                if (c == '-') {
                    negative = true;
                }
                result = result * 10 + c;
            } else {
                continue;
            }
        }
        return s;
    }


    @Test
    public void test2() {
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
    public void test3() {
        float size = 9.0f;
        float loadFactor = 0.3f;
        float capacity = size / loadFactor;
        int intCapacity = (int) (size / loadFactor);
        System.out.println("float 精确计算  ");
        System.out.println(capacity);
        System.out.println(capacity * loadFactor);
        System.out.println("int 精确计算  ");
        System.out.println(intCapacity);
        System.out.println(intCapacity * loadFactor);
    }

    @Test
    public void test4() {
        System.out.println(-1 >> 2);
    }

}