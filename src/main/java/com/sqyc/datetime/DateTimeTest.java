package com.sqyc.datetime;

import org.junit.Test;
import sun.util.locale.provider.LocaleProviderAdapter;

import java.text.DateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

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

    @Test
    public void test1() {
//        String businessHours = "00:00-20:00";
        String businessHours = "08:00-22:00";

        String[] split = businessHours.split("-");
        LocalTime begin = LocalTime.parse(split[0], DateTimeFormatter.ISO_LOCAL_TIME);// 营业开始时间
        LocalTime end = LocalTime.parse(split[1], DateTimeFormatter.ISO_LOCAL_TIME);// 营业结束时间

        LocalDateTime gainTime = LocalDateTime.parse("2019-09-28T07:00:00");
        if (LocalTime.now().isAfter(end) && gainTime.toLocalTime().isBefore(begin.plusHours(4))) {// 在门店下班之后，只能下门店上班日间+4小时后的单
            System.out.println("在门店下班之后，只能下门店上班日间+4小时后的单");
        }
    }

    @Test
    public void test2() {
        LocalDate begin = LocalDate.parse("2019-10-07", DateTimeFormatter.ISO_LOCAL_DATE);// 营业开始时间
        LocalDate end = LocalDate.parse("2019-10-07", DateTimeFormatter.ISO_LOCAL_DATE);// 营业结束时间

        System.out.println(LocalDate.now().isBefore(begin));
        System.out.println(LocalDate.now().isAfter(end));
    }

    @Test
    public void test3() {
        System.out.println(LocaleProviderAdapter.getResourceBundleBased().getLocaleResources(Locale.getDefault(Locale.Category.FORMAT)).getDateTimePattern(DateFormat.FULL, DateFormat.FULL, Calendar.getInstance(TimeZone.getDefault(), Locale.getDefault(Locale.Category.FORMAT))));
        System.out.println(LocaleProviderAdapter.getResourceBundleBased().getLocaleResources(Locale.getDefault(Locale.Category.FORMAT)).getDateTimePattern(DateFormat.LONG, DateFormat.LONG, Calendar.getInstance(TimeZone.getDefault(), Locale.getDefault(Locale.Category.FORMAT))));
        System.out.println(LocaleProviderAdapter.getResourceBundleBased().getLocaleResources(Locale.getDefault(Locale.Category.FORMAT)).getDateTimePattern(DateFormat.MEDIUM, DateFormat.MEDIUM, Calendar.getInstance(TimeZone.getDefault(), Locale.getDefault(Locale.Category.FORMAT))));
        System.out.println(LocaleProviderAdapter.getResourceBundleBased().getLocaleResources(Locale.getDefault(Locale.Category.FORMAT)).getDateTimePattern(DateFormat.SHORT, DateFormat.SHORT, Calendar.getInstance(TimeZone.getDefault(), Locale.getDefault(Locale.Category.FORMAT))));
    }

}
