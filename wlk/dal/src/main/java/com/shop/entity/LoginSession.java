package com.shop.entity;

import lombok.Getter;
import lombok.ToString;

import java.util.Date;
import javax.persistence.*;

@ToString
@Getter
@Table(name = "login_session")
public class LoginSession extends BaseDO{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 账号
     */
    private String account;

    /**
     * 微信openId
     */
    @Column(name = "open_id")
    private String openId;

    /**
     * 微信平台唯一id
     */
    @Column(name = "union_id")
    private String unionId;

    /**
     * 登录token，有效期30天
     */
    private String token;

    /**
     * 登录ip
     */
    @Column(name = "login_ip")
    private String loginIp;

    /**
     * 来源
     */
    private Integer source;
    /**
     * 第一次登录时间戳
     */
    @Column(name = "first_login_time")
    private Long firstLoginTime;

    /**
     * 最后一次更新时间
     */
    @Column(name = "login_updte_time")
    private Long loginUpdteTime;


    public LoginSession setId(Long id) {
        this.id = id;
        return this;
    }

    public LoginSession setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public LoginSession setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public LoginSession setAccount(String account) {
        this.account = account;
        return this;
    }

    public LoginSession setOpenId(String openId) {
        this.openId = openId;
        return this;
    }

    public LoginSession setUnionId(String unionId) {
        this.unionId = unionId;
        return this;
    }

    public LoginSession setToken(String token) {
        this.token = token;
        return this;
    }

    public LoginSession setLoginIp(String loginIp) {
        this.loginIp = loginIp;
        return this;
    }

    public LoginSession setFirstLoginTime(Long firstLoginTime) {
        this.firstLoginTime = firstLoginTime;
        return this;
    }

    public LoginSession setLoginUpdteTime(Long loginUpdteTime) {
        this.loginUpdteTime = loginUpdteTime;
        return this;
    }

    public LoginSession setSource(Integer source) {
        this.source = source;
        return this;
    }
}