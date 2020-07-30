package com.shop.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;

/**
 * @ClassName: MoneyUtils
 * @description: 金钱计算
 * @author: kangkang.xu
 * @date: Created in 17:29 2019/5/10
 * @Version: 1.0
 **/
public class MoneyUtils {

    /**
     * 100
     */
    private static final  Integer ONE_HUNDRED = 100;
    /**
     * 两位小数
     */
    private static final  Integer TEO = 2;


    /**
     * 提供精确的加法运算。
     *
     * @param v1 被加数
     * @param v2 加数
     * @return 两个参数的和
     */

    public static double add(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.add(b2).doubleValue();
    }

    /**
     * 提供精确的减法运算。
     *
     * @param v1 被减数
     * @param v2 减数
     * @return 两个参数的差
     */

    public static double sub(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.subtract(b2).doubleValue();
    }

    /**
     * 费用相关除以100  -处理费用
     *
     * @param fee
     * @return Long
     */
    public static Long feeHandle1(Long fee) {
        if (null == fee) {
            return 0L;
        }
        return fee * ONE_HUNDRED;
    }


    /**
     * 浮点转Long 乘以100
     *
     * @param fee
     * @return Long
     */
    public static Long feeHandleTOLong(BigDecimal fee) {
        if (null == fee) {
            return 0L;
        }
        fee = fee.setScale(TEO, RoundingMode.HALF_UP);
        return fee.multiply(new BigDecimal(ONE_HUNDRED)).longValue();
    }

    /**
     * 浮点类型保留两位小数，四舍五入
     *
     * @param data
     * @return String
     */
    public static String doubleToDecimal(double data) {
        NumberFormat nf = NumberFormat.getNumberInstance();
        // 保留两位小数
        nf.setMaximumFractionDigits(2);
        // 如果不需要四舍五入，可以使用RoundingMode.DOWN
        nf.setRoundingMode(RoundingMode.UP);
        return nf.format(data);
    }

    /**
     * BigDecimal转long
     *
     * @param fee
     * @return Long
     */
    public static Long bigDecimalTOLong(BigDecimal fee) {
        if (null == fee) {
            return 0L;
        }
        return fee.longValue();
    }

    /**
     * BigDecimal to Integer 乘以100
     *
     * @param fee
     * @return Long
     */
    public static Integer feeHandleTOInteger(BigDecimal fee) {
        if (null == fee) {
            return 0;
        }
        fee = fee.setScale(TEO, RoundingMode.HALF_UP);
        return fee.multiply(new BigDecimal(ONE_HUNDRED)).intValue();
    }

    /**
     * Long转浮点，并除以100
     *
     * @return Long
     */
    public static BigDecimal feeBackHandleTOBigDecimal(Long fee) {
        if (null == fee) {
            return BigDecimal.ZERO;
        }
        return BigDecimalUtil.div(BigDecimal.valueOf(fee), BigDecimal.valueOf(ONE_HUNDRED)).setScale(TEO, RoundingMode.HALF_UP);
    }

    /**
     * long to  BigDecimal
     *
     * @param fee
     * @return BigDecimal
     */
    public static BigDecimal longTOBigDecimal(Long fee) {
        if (null == fee) {
            return BigDecimal.ZERO;
        }
        return BigDecimal.valueOf(fee);
    }

    /**
     * Integer转浮点，并除以100
     *
     * @return Integer
     */
    public static BigDecimal feeBackHandleIntegerTOBigDecimal(Integer fee) {
        if (null == fee) {
            return BigDecimal.ZERO;
        }
        return BigDecimalUtil.div(BigDecimal.valueOf(fee), BigDecimal.valueOf(ONE_HUNDRED));
    }

    /**
     * 费用相关乘以100  -还原费用
     *
     * @param fee
     * @return Long
     */
    public static Long feeBackHandle(Long fee) {
        if (null == fee) {
            return 0L;
        }
        return fee / ONE_HUNDRED;
    }
}
