package com.shop.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@ToString
@Getter
@Setter
public class ShopUserVO extends BaseVO{
    private Integer id;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 账号
     */
    private String account;

    /**
     * 密码/验证码
     */
    private String password;

    /**
     * 性别0：未知，1：男， 2：女
     */
    private Integer gender;

    /**
     * 生日
     */
    private String birthday;

    /**
     * 身高CM
     */
    private Double height;

    /**
     * 体重KG
     */
    private Double weight;

    /**
     * 爱好
     */
    private String userLike;

    /**
     * 用户状态0：未认证，1：已认证，2:认证失败 ，3：已锁定
     */
    private Integer status;

    /**
     * 是否删除0：未删除 1：已删除
     */
    private Integer delFlag;


}