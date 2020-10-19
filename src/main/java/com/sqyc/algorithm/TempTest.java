package com.sqyc.algorithm;

import org.junit.Test;

public class TempTest extends SortTest {

    @Test
    public void test() {
        int[] arr = {5, 2, 4, 6, 1, 3};
        int maxIdx;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
    }

}
