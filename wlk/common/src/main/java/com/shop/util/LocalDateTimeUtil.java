package com.shop.util;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

/**
 * java8日期工具
 *
 * @author pitt
 * @version $Id: LocalDateTimeUtil.java, v 0.1 2018年10月27日 00:10 AM pitt Exp $
 **/
public final class LocalDateTimeUtil {

    private LocalDateTimeUtil(){

    }

    /**
     * Date转换为LocalDateTime.
     *
     * @param date
     * @return java.time.LocalDateTime
     */
    public static LocalDateTime convertDateToLDT(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    /**
     * LocalDateTime转换为Date.
     *
     * @param time
     * @return java.util.Date
     */
    public static Date convertLDTToDate(LocalDateTime time) {
        return Date.from(time.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 获取指定日期的毫秒.
     *
     * @param time
     * @return java.lang.Long
     */
    public static Long getMilliByTime(LocalDateTime time) {
        return time.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    /**
     * 获取指定日期的秒.
     *
     * @param time
     * @return java.lang.Long
     */
    public static Long getSecondsByTime(LocalDateTime time) {
        return time.atZone(ZoneId.systemDefault()).toInstant().getEpochSecond();
    }

    /**
     * 获取指定时间的指定格式.
     *
     * @param time
     * @param pattern
     * @return java.lang.String
     */
    public static String formatTime(LocalDateTime time, String pattern) {
        if (StringUtils.isBlank(pattern)) {
            pattern = "";
        }
        return time.format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 获取当前时间的指定格式.
     *
     * @param pattern
     * @return java.lang.String
     */
    public static String formatNow(String pattern) {
        return formatTime(LocalDateTime.now(), pattern);
    }

    /**
     * 日期加上一个数,根据field不同加不同值,field为ChronoUnit.*.
     *
     * @param time
     * @param number
     * @param field
     * @return java.time.LocalDateTime
     */
    public static LocalDateTime plus(LocalDateTime time, long number, TemporalUnit field) {
        return time.plus(number, field);
    }

    /**
     * 日期减去一个数,根据field不同减不同值,field参数为ChronoUnit.*.
     *
     * @param time
     * @param number
     * @param field
     * @return java.time.LocalDateTime
     */
    public static LocalDateTime minu(LocalDateTime time, long number, TemporalUnit field) {
        return time.minus(number, field);
    }

    /**
     * 获取两个日期的差 field参数为ChronoUnit.*.
     *
     * @param startTime
     * @param endTime
     * @param field
     * @return long
     */
    public static long betweenTwoTime(LocalDateTime startTime, LocalDateTime endTime, ChronoUnit field) {
        Period period = Period.between(LocalDate.from(startTime), LocalDate.from(endTime));
        if (field == ChronoUnit.YEARS) {
            return period.getYears();
        }
        if (field == ChronoUnit.MONTHS) {
            return period.getYears() * 12L + period.getMonths();
        }
        return field.between(startTime, endTime);
    }

    /**
     * 获取一天的开始时间，2018,10,22 00:00.
     *
     * @param time
     * @return java.time.LocalDateTime
     */
    public static LocalDateTime getDayStart(LocalDateTime time) {
        return time.withHour(0).withMinute(0).withSecond(0).withNano(0);
    }

    /**
     * 获取一天的结束时间，2018,10,22 23:59:59.999999999.
     *
     * @param time
     * @return java.time.LocalDateTime
     */
    public static LocalDateTime getDayEnd(LocalDateTime time) {
        return time.withHour(23).withMinute(59).withSecond(59).withNano(999999999);
    }

    public static Long now() {
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = LocalDateTime.now().atZone(zone).toInstant();
        return instant.toEpochMilli();
    }

    /**
     * 获取当前时间离一天结束剩余秒数
     * @param currentDate
     * @return
     */
    public static Integer getRemainSecondsOneDay(Date currentDate) {
        LocalDateTime midnight = LocalDateTime.ofInstant(currentDate.toInstant(),
                ZoneId.systemDefault()).plusDays(1).withHour(0).withMinute(0)
                .withSecond(0).withNano(0);
        LocalDateTime currentDateTime = LocalDateTime.ofInstant(currentDate.toInstant(),
                ZoneId.systemDefault());
        long seconds = ChronoUnit.SECONDS.between(currentDateTime, midnight);
        return (int) seconds;
    }
}
