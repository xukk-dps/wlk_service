package com.shop.util;

import org.apache.commons.lang3.time.FastDateFormat;

import java.time.Instant;
import java.util.UUID;

/**
 * 订单相关号的创建
 * @author xkk
 */
public class OrderNoUtils {

    private static ThreadLocal<StringBuilder> threadLocal = new ThreadLocal<StringBuilder>();
    private static final FastDateFormat pattern = FastDateFormat.getInstance("yyyyMMddHHmmssSSS");


    /**
     * 创建订单号 10位随机数 + 当前时间
     * @return str
     */
    public static String orderNo(){
        StringBuilder builder = new StringBuilder((int)((Math.random()+1)*1000000000)+DateUtils.dateTimeNow("yyyyMMddHHmmssSSS"));
        threadLocal.set(builder);
        return threadLocal.get().toString();
    }

    /**
     * 随机数
     * @return str
     */
    public static String nonceStr(){
        return UUID.randomUUID().toString();
    }
    /**
     * 创建交易号 14位随机数 + 当前时间
     * @return str
     */
    public static String transactionNo(){
        StringBuilder builder = new StringBuilder((long)((Math.random()+1)*10000000000000L)+DateUtils.dateTimeNow("yyyyMMddHHmmssSSS"));
        threadLocal.set(builder);
        return threadLocal.get().toString();
    }

    /**
     * 签名
     * @return str
     */
    public static String sign(){
        String sign = "";

        return sign;
    }

    public static void main(String[] args) {
        System.out.println(orderNo());
        System.out.println(transactionNo());

    }
}
