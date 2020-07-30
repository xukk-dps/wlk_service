package com.shop.util;

import java.math.BigDecimal;

/**
 * @ClassName: BigDecimalUtil
 * @description: 浮点工具类
 * @author: kangkang.xu
 * @date: Created in 17:22 2019/5/22
 * @Version: 1.0
 **/
public class BigDecimalUtil {

    private static final int DEF_DIV_SCALE = 10;

    private BigDecimalUtil(){}

    /**
     * 精准的加法运算
     * @param v1
     * @param v2
     * @return double
     */
    public static double add(double v1,double v2){
        BigDecimal b1 = BigDecimal.valueOf(v1);
        BigDecimal b2 = BigDecimal.valueOf(v2);
        return b1.add(b2).doubleValue();
    }

    /**
     * 精确减法计算
     * @param v1
     * @param v2
     * @return double
     */
    public static double sub(double v1,double v2){
        BigDecimal b1 = BigDecimal.valueOf(v1);
        BigDecimal b2 = BigDecimal.valueOf(v2);
        return b1.subtract(b2).doubleValue();
    }

    /**
     * 精确乘法计算
     * @param v1
     * @param v2
     * @return double
     */
    public static double mul(double v1,double v2){
        BigDecimal b1 = BigDecimal.valueOf(v1);
        BigDecimal b2 = BigDecimal.valueOf(v2);
        return b1.multiply(b2).doubleValue();
    }

    /**
     * 精确除法计算
     * @param b1
     * @param b2
     * @return double
     */
    public static BigDecimal div(BigDecimal b1,BigDecimal b2){
        return b1.divide(b2,DEF_DIV_SCALE,BigDecimal.ROUND_HALF_UP);
    }


    public static void main(String[] args) {
        double d1 = 12.897;
        double d2 = 3.87;
        System.out.println(BigDecimalUtil.add(d1,d2));
        System.out.println(BigDecimalUtil.sub(d1, d2));
        System.out.println(BigDecimalUtil.mul(d1, d2));
    }
}
