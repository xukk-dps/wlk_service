package com.shop.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import javax.persistence.*;
@ToString
@Getter
@Table(name = "shop_user")
public class ShopUser extends BaseDO{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 昵称
     */
    @Column(name = "nick_name")
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
     * 微信平台唯一id
     */
    @Column(name = "union_id")
    private String unionId;
    /**
     * 小程序openid
     */
    @Column(name = "open_id")
    private String openId;
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
    @Column(name = "user_like")
    private String userLike;

    /**
     * 用户状态0：未认证，1：已认证，2:认证失败 ，3：已锁定
     */
    private Integer status;
    /**
     * 来源
     */
    private Integer source;

    /**
     * 是否删除0：未删除 1：已删除
     */
    @Column(name = "del_flag")
    private Integer delFlag;


    public ShopUser setId(Long id) {
        this.id = id;
        return this;
    }

    public ShopUser setNickName(String nickName) {
        this.nickName = nickName;
        return this;
    }

    public ShopUser setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public ShopUser setUnionId(String unionId) {
        this.unionId = unionId;
        return this;
    }

    public ShopUser setOpenId(String openId) {
        this.openId = openId;
        return this;
    }

    public ShopUser setAccount(String account) {
        this.account = account;
        return this;
    }

    public ShopUser setPassword(String password) {
        this.password = password;
        return this;
    }

    public ShopUser setGender(Integer gender) {
        this.gender = gender;
        return this;
    }

    public ShopUser setBirthday(String birthday) {
        this.birthday = birthday;
        return this;
    }

    public ShopUser setHeight(Double height) {
        this.height = height;
        return this;
    }

    public ShopUser setWeight(Double weight) {
        this.weight = weight;
        return this;
    }

    public ShopUser setSource(Integer source) {
        this.source = source;
        return this;
    }

    public ShopUser setUserLike(String userLike) {
        this.userLike = userLike;
        return this;
    }

    public ShopUser setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public ShopUser setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
        return this;
    }
}