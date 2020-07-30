package com.shop.entity;

import lombok.Getter;
import lombok.ToString;

import java.util.Date;
import javax.persistence.*;
@ToString
@Getter
@Table(name = "verify_code")
public class VerifyCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 验证码
     */
    @Column(name = "verify_code")
    private String verifyCode;

    /**
     * 来源
     */
    private Integer source;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;


    public VerifyCode setId(Long id) {
        this.id = id;
        return this;
    }

    public VerifyCode setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public VerifyCode setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
        return this;
    }

    public VerifyCode setSource(Integer source) {
        this.source = source;
        return this;
    }

    public VerifyCode setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }
}