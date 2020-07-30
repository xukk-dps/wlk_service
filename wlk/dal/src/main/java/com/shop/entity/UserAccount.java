package com.shop.entity;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;
@ToString
@Getter
@Table(name = "user_account")
public class UserAccount {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 用户领域类型（1：自然人，2：法人）
     */
    private Integer type;

    /**
     * 账号
     */
    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户简称
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 用户类型
     */
    @Column(name = "user_type")
    private Integer userType;

    /**
     * 用户状态1：正常，0:注销
     */
    private Integer status;

    /**
     * 接口调用次数上限
     */
    @Column(name = "max_mum")
    private Long maxMum;

    private Double price;

    /**
     * 账单邮箱
     */
    private String email;

    /**
     * 是否开启手机号验证，1：开启，0：不开启
     */
    @Column(name = "verification_phone")
    private Integer verificationPhone;

    /**
     * 地址
     */
    @Column(name = "ip_address")
    private String ipAddress;

    /**
     * 公司名称
     */
    @Column(name = "company_name")
    private String companyName;

    /**
     * 每天最大调用限制
     */
    @Column(name = "day_max_num")
    private Integer dayMaxNum;

    /**
     * 余额
     */
    private Double balance;

    /**
     * 剩余次数
     */
    @Column(name = "surplus_count")
    private Long surplusCount;
    /**
     * 资源配置
     */
    private String resources;

    public UserAccount setId(String id) {
        this.id = id;
        return this;
    }

    public UserAccount setType(Integer type) {
        this.type = type;
        return this;
    }

    public UserAccount setAccount(String account) {
        this.account = account;
        return this;
    }

    public UserAccount setPassword(String password) {
        this.password = password;
        return this;
    }

    public UserAccount setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public UserAccount setUserType(Integer userType) {
        this.userType = userType;
        return this;
    }

    public UserAccount setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public UserAccount setMaxMum(Long maxMum) {
        this.maxMum = maxMum;
        return this;
    }

    public UserAccount setPrice(Double price) {
        this.price = price;
        return this;
    }

    public UserAccount setEmail(String email) {
        this.email = email;
        return this;
    }

    public UserAccount setVerificationPhone(Integer verificationPhone) {
        this.verificationPhone = verificationPhone;
        return this;
    }

    public UserAccount setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
        return this;
    }

    public UserAccount setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public UserAccount setDayMaxNum(Integer dayMaxNum) {
        this.dayMaxNum = dayMaxNum;
        return this;
    }

    public UserAccount setBalance(Double balance) {
        this.balance = balance;
        return this;
    }

    public UserAccount setSurplusCount(Long surplusCount) {
        this.surplusCount = surplusCount;
        return this;
    }

    public UserAccount setResources(String resources) {
        this.resources = resources;
        return this;
    }
}