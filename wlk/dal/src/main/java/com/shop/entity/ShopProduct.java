package com.shop.entity;

import lombok.Getter;
import lombok.ToString;

import java.util.Date;
import javax.persistence.*;
@ToString
@Getter
@Table(name = "shop_product")
public class ShopProduct extends BaseDO{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 商品名称
     */
    @Column(name = "pro_name")
    private String proName;

    /**
     * 商品类型
     */
    @Column(name = "pro_type")
    private Integer proType;

    /**
     * 商品logo
     */
    @Column(name = "pro_logo")
    private String proLogo;
    /**
     * 商品详情
     */
    @Column(name = "pro_desc")
    private String proDesc;
    /**
     * 商品价格（分）
     */
    @Column(name = "pro_price")
    private Long proPrice;

    /**
     * 商品状态0：未上架，1：已上架，2：已下架
     */
    @Column(name = "pro_status")
    private Integer proStatus;

    /**
     * 删除状态0：未删除，1：已删除
     */
    @Column(name = "pro_del_status")
    private Integer proDelStatus;

    /**
     * 快递是否免费0：不免费，1：免费
     */
    @Column(name = "pro_courier")
    private Integer proCourier;

    /**
     * 发货地点
     */
    @Column(name = "pro_send_place")
    private String proSendPlace;

    public Long getId() {
        return id;
    }

    public ShopProduct setId(Long id) {
        this.id = id;
        return this;
    }

    public String getProName() {
        return proName;
    }

    public ShopProduct setProName(String proName) {
        this.proName = proName;
        return this;
    }

    public Integer getProType() {
        return proType;
    }

    public ShopProduct setProType(Integer proType) {
        this.proType = proType;
        return this;
    }

    public String getProLogo() {
        return proLogo;
    }

    public ShopProduct setProLogo(String proLogo) {
        this.proLogo = proLogo;
        return this;
    }

    public Long getProPrice() {
        return proPrice;
    }

    public ShopProduct setProPrice(Long proPrice) {
        this.proPrice = proPrice;
        return this;
    }

    public Integer getProStatus() {
        return proStatus;
    }

    public ShopProduct setProStatus(Integer proStatus) {
        this.proStatus = proStatus;
        return this;
    }

    public Integer getProDelStatus() {
        return proDelStatus;
    }

    public ShopProduct setProDelStatus(Integer proDelStatus) {
        this.proDelStatus = proDelStatus;
        return this;
    }

    public ShopProduct setProDesc(String proDesc) {
        this.proDesc = proDesc;
        return this;
    }

    public Integer getProCourier() {
        return proCourier;
    }

    public ShopProduct setProCourier(Integer proCourier) {
        this.proCourier = proCourier;
        return this;
    }

    public String getProSendPlace() {
        return proSendPlace;
    }

    public ShopProduct setProSendPlace(String proSendPlace) {
        this.proSendPlace = proSendPlace;
        return this;
    }
}