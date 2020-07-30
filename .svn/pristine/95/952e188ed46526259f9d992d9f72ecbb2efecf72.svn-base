package com.shop.util;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName: DateUtils
 * @description: 时间工具类
 * @author: kangkang.xu
 * @date: Created in 16:32 2019/4/16
 * @Version: 1.0
 **/
public class HandleDateUtil {

    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";


    private static ThreadLocal<DateFormat> THREADLOCAL = new ThreadLocal<>();

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
     * 将时间戳转换为时间（秒级）
     */
    public static String dataToStr(Date data) {
        DateFormat simpleDateFormat = getDateFormat();
        return simpleDateFormat.format(data);
    }

}
