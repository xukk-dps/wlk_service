package com.shop.entity;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@ToString
@Getter
@Table(name = "shop_car")
public class ShopCar extends BaseDO{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    /**
     * 商品名称
     */
    @Column(name = "pro_name")
    private String proName;

    /**
     * 商品id
     */
    @Column(name = "pro_id")
    private Long proId;

    /**
     * 商品logo
     */
    @Column(name = "pro_logo")
    private String proLogo;

    /**
     * 价格（分）
     */
    @Column(name = "pro_price")
    private Long proPrice;

    /**
     * 商品数量
     */
    @Column(name = "pro_num")
    private Integer proNum;

    /**
     * 来源
     */
    private Integer source;

    /**
     * 购物车状态0：未删除，1：已删除
     */
    @Column(name = "car_status")
    private Integer carStatus;

    public ShopCar setId(Long id) {
        this.id = id;
        return this;
    }

    public ShopCar setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public ShopCar setProName(String proName) {
        this.proName = proName;
        return this;
    }

    public ShopCar setProId(Long proId) {
        this.proId = proId;
        return this;
    }

    public ShopCar setProLogo(String proLogo) {
        this.proLogo = proLogo;
        return this;
    }

    public ShopCar setProPrice(Long proPrice) {
        this.proPrice = proPrice;
        return this;
    }

    public ShopCar setProNum(Integer proNum) {
        this.proNum = proNum;
        return this;
    }

    public ShopCar setSource(Integer source) {
        this.source = source;
        return this;
    }

    public ShopCar setCarStatus(Integer carStatus) {
        this.carStatus = carStatus;
        return this;
    }
}