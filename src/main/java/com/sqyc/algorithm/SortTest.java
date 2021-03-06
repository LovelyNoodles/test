package com.sqyc.algorithm;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * 冒泡排序[Bubble sort]: O(n²)
 * <p>
 * 选择排序[Selection sort]: O(n²)
 * <p>
 * 插入排序[Insertion sort]: O(n²)
 * <p>
 * 希尔排序[Shell's sort]: O(n1.5)
 * <p>
 * 快速排序[Quick sort]: O(N*logN)
 * <p>
 * 归并排序[Merge sort]: O(N*logN)
 * <p>
 * 堆排序[Heap sort]: O(N*logN)
 * <p>
 * 基数排序[Radix sort]: O(d(n+r))
 */
public class SortTest {

    /**
     * 插入排序：增量法，每次循环新增一个元素，形成一个待循环的子数组
     * <p>
     * java源码中，小数据量的排序用的此算法
     */
    @Test
    public void insertion() {
        int[] arr = {5, 2, 4, 6, 1, 3};
        for (int current = 1; current < arr.length; current++) {
            System.out.print(arr[current] + "-----");
            for (int compared = current; compared > 0 && (arr[compared - 1] > arr[compared]); compared--) {
                int temp = arr[compared];
                arr[compared] = arr[compared - 1];
                arr[compared - 1] = temp;
            }
            System.out.println(JSON.toJSONString(arr));
        }
        System.out.println(JSON.toJSONString(arr));
    }

    /**
     * 合并排序：分治法，用递归将大问题切分成若干个小问题，即：分割，解决，合并
     * <p>
     * java源码中，大数据量的排序用的此算法
     */
    @Test
    public void test1() {

    }

}


