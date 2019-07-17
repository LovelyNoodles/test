package com.sqyc.datetime;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FormatterTest {

    @Test
    public void test1() {

        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("MM月dd日");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("HH:mm");

        LocalDateTime now = LocalDateTime.now();

        System.out.println(formatter1.format(now));
        System.out.println(formatter2.format(now));


    }

}
