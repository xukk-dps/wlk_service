package com.shop.enums;

import org.omg.PortableInterceptor.INACTIVE;

/**
 * 账户状态
 */
public enum AccountStatus {
    AUTH_NOT(0, "未认证"),
    AUTH_ALREADY(1, "已认证"),
    AUTH_FAIL(2, "认证失败"),
    LOCK(3, "已锁定");

    private Integer code;    //类型
    private String message;    //描述

    private AccountStatus(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
