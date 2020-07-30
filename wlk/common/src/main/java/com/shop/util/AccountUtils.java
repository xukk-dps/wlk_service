package com.shop.util;

public class AccountUtils {

    /**
     * 创建账号 wlk + 下划线 + 手机号后6位
     * @param phone
     * @return str
     */
    public static String createAccount(String phone){
        return "wlk_"+phone.substring(phone.length()-6,phone.length());
    }
}
