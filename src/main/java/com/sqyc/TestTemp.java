package com.sqyc;

import org.junit.Test;

import java.util.*;

public class TestTemp {

    @Test
    public void test1() {
//        int[] nums = {-1, 0, 1, 2, -1, -4};
        int[] nums = {-1, -6, -3, 3, 3, 1, 7, -6, -2, -1};
        System.out.println(threeSum(nums));
        Arrays.sort(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }
//    0 <= nums.length <= 3000
//    -105 <= nums[i] <= 105

    public List<List<Integer>> threeSum(int[] nums) {
        // result 内的格式为{[first,second,third],[first,second,third],[first,second,third]}
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) {
            return result;
        }

        // 因为first + second + third = 0，所以其中必有一个为负数，所以在这里假设first <= 0，则second < third ;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int first = nums[i];
            if (first > 0) {// first不为负数则结束
                break;
            }
            if (i > 0 && first == nums[i - 1]) {// 按first过滤计算过的数，多所以不提前过滤到重复值，是因为可能存在：a+b+c=a+a+(-2*a)=0
                continue;
            }
            int left = i + 1, right = nums.length - 1;
            int target = -first;
            while (left < right) {
                // 先用再去重，防止存在[-2, 1, 1]这种类型的数据出现
                int second = nums[left];
                int third = nums[right];
                if (second + third == target) {// 如果 second + third = target，过滤到相同组合的[second, third]，指针指向新数值对
                    result.add(Arrays.asList(first, second, third));
                    while (second == nums[left + 1]) {
                        left++;
                    }
                    while (third == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (second + third < target) {// 如果 second + third < target，则要后有序数线，随着 second 的增大，second + third 接近 target
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
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
        System.out.println(-1 >> 2);
    }

}