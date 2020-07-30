package com.shop.dto.auth;

import com.shop.annonation.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class AuthRequest {

    /**
     * 手机号
     */
    @NotBlank(message = "手机号为空或长度不合法",maxLen = 11)
    private String phone;

    /**
     * 账号
     */
    private String account;

    /**
     * 密码/验证码
     */
    @NotBlank(message = "验证码为空或长度不合法",maxLen = 4)
    private String password;

    /**
     * 微信平台唯一id
     */
    private String unionId;
    /**
     * 小程序openid
     */
    private String openId;

    private String loginIp;

    private Integer source;

}