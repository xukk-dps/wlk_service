package com.shop.dto.auth;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class ShopUserDTO {

    private Long id;

    private Long pid;
    /**
     * 账号
     */
    private String account;

    /**
     * 手机号
     */
    private String phone;
    /**
     * 小程序openid
     */
    private String openId;
    /**
     * 密码
     */
    private String password;

    /**
     * 用户简称
     */
    private String userName;

    /**
     * 来源 1:安卓，2:ios，3:小程序，4:web
     */
    private Integer source;

    private Long t = System.currentTimeMillis();


}