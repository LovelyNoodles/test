package com.sqyc;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class TestTemp {

    @Test
    public void test1() {
        Set<String> set = new HashSet<>();
        System.out.println(set.add("1"));
        System.out.println(set.add("1"));
        System.out.println(set.add("1"));
        System.out.println(set.add("1"));

    }

}
