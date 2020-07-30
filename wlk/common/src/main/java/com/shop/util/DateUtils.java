package com.shop.util;


import org.apache.commons.lang3.StringUtils;

import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @ClassName: DateUtils
 * @description: 时间工具类
 * @author: kangkang.xu
 * @date: Created in 16:32 2019/4/16
 * @Version: 1.0
 **/
public class DateUtils {

    /**
     * 月份
     */
    private static final String MONTH_DATE_FORMAT = "yyyy-MM";

    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    private static final String DATE_DAY_FORMAT = "yyyy-MM-dd";

    private static final String DATE_FORMAT_YMDHS = "yyyyMMddHHmmss";

    private static final String DATE_UTC_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'";

    private static ThreadLocal<DateFormat> THREADLOCAL_YMDHS = new ThreadLocal<>();

    private static ThreadLocal<DateFormat> THREADLOCAL = new ThreadLocal<>();

    private static ThreadLocal<DateFormat> THREAD_DAY_LOCAL = new ThreadLocal<>();

    /**
     * 月份
     */
    private static ThreadLocal<DateFormat> THREADMONTHLOCAL = new ThreadLocal<>();


    private static ThreadLocal<DateFormat> THREADLOCAL_UTC = new ThreadLocal<>();


    /**
     * 获取当月0点时间戳
     *
     * @return long
     */
    public static Long monthTimeInMillis() {
        // 获取当前日期
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, 0);
        calendar.add(Calendar.MONTH, 0);
        // 设置为1号,当前日期既为本月第一天
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Long time = calendar.getTimeInMillis();
        return time;
    }

    /**
     * 获取两个时间之间的天
     * 时间格式 yyyy-MM-dd
     */
    public static List<String> getAllDays(String start, String ends) {
        List<String> result = new ArrayList<String>();
        Calendar tempStart = Calendar.getInstance();
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        Date begin;
        Date end;
        try {
            begin = fmt.parse(start);
            end = fmt.parse(ends);
        } catch (ParseException e) {
            e.printStackTrace();
            return result;
        }
        tempStart.setTime(begin);
        while (begin.getTime() <= end.getTime()) {
            result.add(fmt.format(tempStart.getTime()));
            tempStart.add(Calendar.DAY_OF_YEAR, 1);
            begin = tempStart.getTime();
        }
        return result;

    }

    public static final String dateTimeNow(final String format) {
        return parseDateToStr(format, new Date());
    }

    public static final String parseDateToStr(final String format, final Date date) {
        return new SimpleDateFormat(format).format(date);
    }

    /**
     * 获取当天0点时间戳 Created by Wenhui Huang 2019/02/28
     *
     * @return Long
     */
    private static Long dayTimeInMillis() {
        // 获取当前日期
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Long time = calendar.getTimeInMillis();
        return time;
    }

    /**
     * 获取当年0点时间戳 Created by Wenhui Huang 2019/02/28
     */
    private static Long yearTimeInMillis() {
        // 获取当前日期
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, 0);
        calendar.add(Calendar.DATE, 0);
        calendar.add(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_YEAR, 1);
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Long time = calendar.getTimeInMillis();
        return time;
    }

    /**
     * @Description: 获得“今天”零点时间戳 获得2点的加上2个小时的毫秒数就行
     */
    public static Long getTodayZeroPointTimestamps() {
        Long currentTimestamps = System.currentTimeMillis();
        Long oneDayTimestamps = Long.valueOf(60 * 60 * 24 * 1000);
        return currentTimestamps - (currentTimestamps + 60 * 60 * 8 * 1000) % oneDayTimestamps;
    }

    /**
     * 获取两个时间之间的所有月份
     *
     * @param minDate
     * @param maxDate
     * @return list
     */
    public static List<String> getMonthBetween(String minDate, String maxDate) {
        List<String> result = new ArrayList<String>();
        try {
            if (StringUtils.isBlank(minDate) || StringUtils.isBlank(maxDate)) {
                return result;
            }
            DateFormat sdf = getMonthDateFormat();
            Calendar min = Calendar.getInstance();
            Calendar max = Calendar.getInstance();

            min.setTime(sdf.parse(minDate));
            min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);

            max.setTime(sdf.parse(maxDate));
            max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);

            Calendar curr = min;
            while (curr.before(max)) {
                result.add(sdf.format(curr.getTime()));
                curr.add(Calendar.MONTH, 1);
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return result;
        }

    }

    /**
     * 处理日期 2019-06
     *
     * @return String
     */
    private static String addMonth(String date, int num) {
        Date retDate = parseMonthDateStr(date);
        Format f = getMonthDateFormat();
        Calendar c = Calendar.getInstance();
        c.setTime(retDate);
        c.add(Calendar.MONTH, num);
        retDate = c.getTime();
        return f.format(retDate);
    }

    /**
     * 获取当前时间戳毫秒级
     *
     * @return Long
     */
    public static Long getNowTimeMillis() {
        return System.currentTimeMillis();
    }

    /**
     * 分钟转为毫秒
     *
     * @return Long
     */
    public static Long minuteToMS(Long date) {
        if (null == date) {
            return null;
        }
        return date * 60000;
    }

    /**
     * 小时转为毫秒
     *
     * @return Long
     */
    public static Long hourToMS(Long date) {
        if (null == date) {
            return null;
        }
        return date * 60000 * 60;
    }

    /**
     * 毫秒转为分钟
     *
     * @return Long
     */
    public static Long msToMinute(Long date) {
        if (null == date) {
            return null;
        }
        return date / 60000;
    }

    /**
     * 毫秒转为小时
     *
     * @return Long
     */
    public static Long msToHour(Long date) {
        if (null == date) {
            return null;
        }
        return date / 60000 / 60;
    }

    /**
     * 给时间加上几个小时
     *
     * @param day  当前时间 格式：yyyy-MM-dd HH:mm:ss
     * @param hour 需要加的时间
     * @return String
     */
    public static String addDateHour(String day, int hour) {
        DateFormat format = getDateFormat();
        Date date = null;
        try {
            date = format.parse(day);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (date == null) {
            return "";
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        //24小时制
        cal.add(Calendar.HOUR, hour);
        date = cal.getTime();
        //显示更新后的日期
        cal = null;
        return format.format(date);

    }

    /**
     * 本地时间格式转UTC时间格式
     *
     * @param date
     * @return String
     */
    public static String convertToUTC(String date) {
        DateFormat dateFormat = getDateUTCFormat();
//        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return dateFormat.format(parseDateStr(date));
    }

    /**
     * 获取当前时间，格式为yyyyMMddHHmmss
     *
     * @return String
     */
    public static String getNowDate() {
        DateFormat dateFormat = getDateFormatYMDHS();
        return dateFormat.format(new Date());
    }

    /**
     * 使用线程安全对象格式化时间
     * yyyy-MM-dd'T'HH:mm:ss'Z'
     *
     * @return DateFormat
     */
    public static DateFormat getDateUTCFormat() {
        DateFormat df = THREADLOCAL_UTC.get();
        if (df == null) {
            df = new SimpleDateFormat(DATE_UTC_FORMAT);
            THREADLOCAL_UTC.set(df);
        }
        return df;
    }

    /**
     * 使用线程安全对象格式化时间
     * yyyy-MM-dd HH:mm:ss
     *
     * @return DateFormat
     */
    public static DateFormat getDateFormat() {
        DateFormat df = THREADLOCAL.get();
        if (df == null) {
            df = new SimpleDateFormat(DATE_FORMAT);
            THREADLOCAL.set(df);
        }
        return df;
    }

    /**
     * 获日期格式 yyyy-MM-dd
     *
     * @return DateFormat
     */
    public static DateFormat getDayDateFormat() {
        DateFormat df = THREAD_DAY_LOCAL.get();
        if (df == null) {
            df = new SimpleDateFormat(DATE_DAY_FORMAT);
            THREAD_DAY_LOCAL.set(df);
        }
        return df;
    }

    /**
     * 使用线程安全对象格式化时间
     * yyyy-MM
     *
     * @return DateFormat
     */
    public static DateFormat getMonthDateFormat() {
        DateFormat df = THREADMONTHLOCAL.get();
        if (df == null) {
            df = new SimpleDateFormat(MONTH_DATE_FORMAT);
            THREADMONTHLOCAL.set(df);
        }
        return df;
    }

    /**
     * 使用线程安全对象格式化时间
     * yyyyMMddHHmmss
     *
     * @return DateFormat
     */
    public static DateFormat getDateFormatYMDHS() {
        DateFormat df = THREADLOCAL_YMDHS.get();
        if (df == null) {
            df = new SimpleDateFormat(DATE_FORMAT_YMDHS);
            THREADLOCAL_YMDHS.set(df);
        }
        return df;
    }

    /**
     * date to str
     *
     * @param date
     * @return String
     */
    public static String formatDate(Date date) {
        return getDateFormat().format(date);
    }

    /**
     * str to  date
     *
     * @param strDate
     * @return Date
     */
    public static Date parseDateStr(String strDate) {
        try {
            return getDateFormat().parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * str to  date
     *
     * @param strDate
     * @return Date
     */
    public static Date parseMonthDateStr(String strDate) {
        try {
            return getMonthDateFormat().parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取7天前时间戳
     */
    public static Long getBeforeSevenDaysStamp(int past) {
        String pastDateFormat = getPastDate(past);
        Long aLong = dateToStamp(pastDateFormat);
        return aLong;
    }

    /**
     * 获取过去第几天的日期(- 操作) 或者 未来 第几天的日期( + 操作)
     *
     * @param pastDay
     * @return
     */
    public static String getPastDate(int pastDay) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - pastDay);
        Date today = calendar.getTime();
        DateFormat format = getDateFormat();
        String result = format.format(today);
        return result;
    }

    /**
     * 将时间转换为时间戳
     */
    public static Long dateToStamp(String s) {
        long ts = System.currentTimeMillis();
        System.out.println("ts:" + ts);
        Date date = null;
        try {
            DateFormat simpleDateFormat = getDateFormat();
            date = simpleDateFormat.parse(s);
            ts = date.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return ts;
    }

    /**
     * 将时间戳转换为时间（毫秒级）yyyy-MM-dd HH:mm:ss
     */
    public static String stampToDateMS(Long s) {
        try {
            if (null == s) {
                return "";
            }
            DateFormat simpleDateFormat = getDateFormat();
            Date date = new Date(s);
            return simpleDateFormat.format(date);
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * 将时间戳转换为时间（毫秒级）yyyy-MM
     */
    public static String stampToMonthDate(Long s) {
        try {
            if (null == s) {
                return "";
            }
            DateFormat simpleDateFormat = getMonthDateFormat();
            Date date = new Date(s);
            return simpleDateFormat.format(date);
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * 将时间戳转换为时间（秒级）
     */
    public static String stampToDate(long s) {
        DateFormat simpleDateFormat = getDateFormat();
        Date date = new Date(s / 1000);
        return simpleDateFormat.format(date);
    }

    /**
     * 将时间戳转换为时间（yyyy-MM-dd）
     */
    public static String stampToDayDate(long s) {
        DateFormat simpleDateFormat = getDayDateFormat();
        Date date = new Date(s);
        return simpleDateFormat.format(date);
    }


    /**
     * 当前日期倒推完整6个月
     *
     * @return
     */
    public static List<String> getDefaultMonth() {
        //获取当前时间
        LocalDateTime currentDay = LocalDateTime.now();
        LocalDateTime preFiveMonth = currentDay.minus(5, ChronoUnit.MONTHS);
        return DateUtils.getMonthBetween(
                DateUtils.stampToMonthDate(localDateTime2Millis(preFiveMonth)),
                DateUtils.stampToMonthDate(localDateTime2Millis(currentDay)));
    }

    public static Long getCurrentDay() {
        LocalDateTime currentDay = LocalDateTime.now();
        return localDateTime2Millis(currentDay);
    }


    public static Long getPreFiveMonthDay() {
        LocalDateTime currentDay = LocalDateTime.now();
        LocalDateTime preFiveMonth = currentDay.minus(5, ChronoUnit.MONTHS);
        return localDateTime2Millis(preFiveMonth);
    }

    public static Long getPreSixDay() {
        LocalDateTime currentDay = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
        LocalDateTime preFiveDay = currentDay.minus(6, ChronoUnit.DAYS);
        return localDateTime2Millis(preFiveDay);
    }

    /**
     * 类型转换 LocalDate to long
     *
     * @param localDate
     * @return
     */
    public static Long localDate2Millis(LocalDate localDate) {
        return LocalDateTime.of(localDate, LocalTime.MIN).toInstant(ZoneOffset.ofHours(8)).toEpochMilli();
    }


    /**
     * 类型转换 LocalDateTime to long
     *
     * @param localDateTime
     * @return
     */
    public static Long localDateTime2Millis(LocalDateTime localDateTime) {
        return localDateTime.toEpochSecond(ZoneOffset.of("+8"));
    }


    public static void main(String[] args) {
        System.out.println(getTodayZeroPointTimestamps());
        System.out.println(getCurrentDay() * 1000);
        System.out.println(getPreSixDay());
    }

}
