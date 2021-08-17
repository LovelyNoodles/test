package com.sqyc;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TestTemp {

    @Test
    public void test1() {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }
//    0 <= nums.length <= 3000
//    -105 <= nums[i] <= 105

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int target = num - nums[j];

            }
        }
        return null;
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