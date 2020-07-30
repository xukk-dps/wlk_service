package com.shop.util.pay;

/**
 * 随机字符串生成
 * @author xkk
 */

import java.util.Random;
import java.util.UUID;

/**
 * 随机字符串生成
 *
 */
public class RandomStringGenerator {


    public static void main(String[] args) {
        System.out.println(UUID.randomUUID().toString().replace("-","").substring(0,32));
        System.out.println(getRandomStringByLength(32));
    }

    /**
     * 获取一定长度的随机字符串
     *
     * @param length 指定字符串长度
     * @return 一定长度的字符串
     */
    public static String getRandomStringByLength(int length) {
        String base = "qwertyuihgfdescjkligrasbmas";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
}