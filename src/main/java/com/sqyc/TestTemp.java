package com.sqyc;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TestTemp {

    @Test
    public void test1() {
//        int[] nums = {2, 7, 11, 15};
//        int target = 9;
        int[] nums = {3, 2, 4};
        int target = 6;
        int[] ints1 = twoSum1(nums, target);
        int[] ints2 = twoSum2(nums, target);
        System.out.println(Arrays.toString(ints1));
        System.out.println(Arrays.toString(ints2));
    }

    public int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            int b = target - a;
            int indexB = ArrayUtils.indexOf(nums, b);
            if (indexB != i && indexB >= 0) {
                return new int[]{i, indexB};
            }
        }
        return new int[]{-1, -1};
    }

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (m.get(target - nums[i]) != null) {
                return new int[]{m.get(target - nums[i]), i};
            }
            m.put(nums[i], i);
        }
        return new int[]{-1, -1};
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

    }

    @Test
    public void test3() {
        
    }

}
