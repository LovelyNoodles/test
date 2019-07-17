package com.sqyc.datetime;

import org.junit.Test;

import java.time.*;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;

/**
 * @author yanyunpeng
 * @title: DateTimeTest
 * @projectName test
 * @description:
 * @date 2019/4/8 17:32
 */
public class DateTimeTest {

    @Test
    public void 判断日期是周几() {
        LocalDateTime now = LocalDateTime.now();
        DayOfWeek dayOfWeek = now.getDayOfWeek();
        System.out.println(dayOfWeek);
        System.out.println(dayOfWeek.getValue());
        System.out.println(dayOfWeek.getDisplayName(TextStyle.FULL, Locale.CHINESE));
    }

    @Test
    public void 日期加法() {
        LocalDateTime now = DateTimeUtils.date2LocalDateTime(new Date()).plusYears(-3);
        System.out.println(now.plusYears(-3));
        System.out.println(now.plusYears(2));
    }

    @Test
    public void date转localdatetime() {
        Date date = new Date();
        Instant instant = date.toInstant();

        // 转datetime
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        System.out.println(localDateTime);

        LocalDate localDate = localDateTime.toLocalDate();
        System.out.println(localDate);
    }


    @Test
    public void 订单相关值() {

        LocalDateTime after = LocalDateTime.parse("2019-04-16T16:00:01");
        LocalDateTime before = LocalDateTime.parse("2019-04-16T17:00:00");
        long between = ChronoUnit.HOURS.between(before, after);
        System.out.println(between);
        System.out.println(before.isBefore(after));
    }

    @Test
    public void 判断日期是否在某一时间段() {
        LocalDateTime after = LocalDateTime.parse("2019-04-16T16:00:01");
        LocalDateTime before = LocalDateTime.parse("2019-04-16T17:00:00");

        LocalDateTime now = LocalDateTime.now();

        System.out.println(now.isAfter(now));
    }


}
