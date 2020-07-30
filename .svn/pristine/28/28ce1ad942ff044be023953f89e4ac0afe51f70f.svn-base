package com.shop.entity;

import lombok.Getter;
import lombok.ToString;

import java.util.Date;
import javax.persistence.*;

@ToString
@Getter
@Table(name = "receive_address")
public class ReceiveAddress extends BaseDO{
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 收货人
     */
    @Column(name = "receive_name")
    private String receiveName;

    /**
     * 收货人手机号
     */
    @Column(name = "receive_phone")
    private String receivePhone;

    /**
     * 省
     */
    private String provice;

    /**
     * 市
     */
    private String city;

    /**
     * 区/县
     */
    private String area;

    /**
     * 详细收货地址
     */
    @Column(name = "receive_address")
    private String receiveAddress;

    /**
     * 是否是默认地址0:不是，1:是
     */
    @Column(name = "default_flag")
    private Integer defaultFlag;

    public ReceiveAddress setId(Integer id) {
        this.id = id;
        return this;
    }

    public ReceiveAddress setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public ReceiveAddress setReceiveName(String receiveName) {
        this.receiveName = receiveName;
        return this;
    }

    public ReceiveAddress setReceivePhone(String receivePhone) {
        this.receivePhone = receivePhone;
        return this;
    }

    public ReceiveAddress setDefaultFlag(Integer defaultFlag) {
        this.defaultFlag = defaultFlag;
        return this;
    }

    public ReceiveAddress setProvice(String provice) {
        this.provice = provice;
        return this;
    }

    public ReceiveAddress setCity(String city) {
        this.city = city;
        return this;
    }

    public ReceiveAddress setArea(String area) {
        this.area = area;
        return this;
    }

    public ReceiveAddress setReceiveAddress(String receiveAddress) {
        this.receiveAddress = receiveAddress;
        return this;
    }
}