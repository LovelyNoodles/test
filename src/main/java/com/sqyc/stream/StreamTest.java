package com.sqyc.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


class StreamTest {

    /**
     * @Title: test1 @Description: 斐波纳契元组序列 @return void @throws
     */
    @Test
    public void test1() {
        Stream.iterate(new int[]{0, 1}, arr -> new int[]{arr[1], arr[0] + arr[1]}).limit(20)
                .mapToInt(arr -> arr[0]).forEach(System.out::println);
    }

    @Test
    public void test2() {
        Stream.generate(Math::random).limit(20).forEach(System.out::println);
    }

    @Test
    public void test3() {
        String string = "1234,asdf";
        Set<String> set = Arrays.stream(string.split(",")).collect(Collectors.toSet());
        System.out.println(set);
    }

}
