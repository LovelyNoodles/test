package com.sqyc.datetime;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * 日期时间工具类
 */
public class DateTimeUtils {

    public static LocalDateTime date2LocalDateTime(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    public static Date localDateTime2Date(LocalDateTime localDateTime) {
        Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
        return Date.from(instant);
    }

    public static Date atStartOfDay(Date date) {
        return localDateTime2Date(date2LocalDateTime(date).toLocalDate().atStartOfDay());
    }

    public static Date atEndOfDay(Date date) {
        return localDateTime2Date(LocalDateTime.of(date2LocalDateTime(date).toLocalDate(), LocalTime.MAX));
    }

    public static Date atSomeTimeOfDay(Date date, LocalTime localTime) {
        return localDateTime2Date(LocalDateTime.of(date2LocalDateTime(date).toLocalDate(), localTime));
    }

    public static Date plusYears(Date date, long years) {
        LocalDateTime localDateTime = date2LocalDateTime(date);
        return localDateTime2Date(localDateTime.plusYears(years));
    }

    public static Date plusMonths(Date date, long months) {
        LocalDateTime localDateTime = date2LocalDateTime(date);
        return localDateTime2Date(localDateTime.plusMonths(months));
    }

    public static Date plusWeeks(Date date, long weeks) {
        LocalDateTime localDateTime = date2LocalDateTime(date);
        return localDateTime2Date(localDateTime.plusWeeks(weeks));
    }

    public static Date plusDays(Date date, long days) {
        LocalDateTime localDateTime = date2LocalDateTime(date);
        return localDateTime2Date(localDateTime.plusDays(days));
    }

    public static Date plusHours(Date date, long hours) {
        LocalDateTime localDateTime = date2LocalDateTime(date);
        return localDateTime2Date(localDateTime.plusHours(hours));
    }

    public static Date plusMinutes(Date date, long minutes) {
        LocalDateTime localDateTime = date2LocalDateTime(date);
        return localDateTime2Date(localDateTime.plusMinutes(minutes));
    }

    public static Date plusSeconds(Date date, long seconds) {
        LocalDateTime localDateTime = date2LocalDateTime(date);
        return localDateTime2Date(localDateTime.plusSeconds(seconds));
    }

}
