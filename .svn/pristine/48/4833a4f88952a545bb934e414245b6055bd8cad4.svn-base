package com.shop.validtion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 是否包含非法字符
 * @a
 */
public class IllegalCharacter {

    /**
     * 判断是否含有特殊字符
     *
     * @param str
     * @return true为包含，false为不包含
     */
    public static boolean isSpecialChar(String str) {
        StringBuilder regEx = new StringBuilder("[`]");
        regEx.append("|delete|insert|select|<script");
        regEx.append("|<script");
        Pattern p = Pattern.compile(regEx.toString());
        Matcher m = p.matcher(str);
        return m.find();
    }
}
