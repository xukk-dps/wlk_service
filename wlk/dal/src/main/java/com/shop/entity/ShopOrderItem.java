package com.shop.entity;

import lombok.Getter;
import lombok.ToString;

import java.util.Date;
import javax.persistence.*;

@ToString
@Getter
@Table(name = "shop_order_item")
public class ShopOrderItem extends BaseDO{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 订单号
     */
    @Column(name = "order_no")
    private String orderNo;

    /**
     * 产品属性
     */
    @Column(name = "pro_attribute")
    private String proAttribute;

    /**
     * 商品id
     */
    @Column(name = "pro_id")
    private Long proId;

    /**
     * 商品名称
     */
    @Column(name = "pro_name")
    private String proName;

    /**
     * 订单logo
     */
    @Column(name = "pro_logo")
    private String proLogo;

    /**
     * 商品单价
     */
    @Column(name = "pro_price")
    private Long proPrice;

    /**
     * 商品实际成交总价（总价=订单*数量）
     */
    @Column(name = "pro_sale_price")
    private Long proSalePrice;

    /**
     * 商品数量
     */
    @Column(name = "pro_num")
    private Integer proNum;
    /**
     * 使用的优惠券id
     */
    @Column(name = "coupon_id")
    private Long couponId;

    /**
     * 备注
     */
    private String remark;

    public ShopOrderItem setId(Long id) {
        this.id = id;
        return this;
    }

    public ShopOrderItem setOrderNo(String orderNo) {
        this.orderNo = orderNo;
        return this;
    }

    public ShopOrderItem setProAttribute(String proAttribute) {
        this.proAttribute = proAttribute;
        return this;
    }

    public ShopOrderItem setProId(Long proId) {
        this.proId = proId;
        return this;
    }

    public ShopOrderItem setProName(String proName) {
        this.proName = proName;
        return this;
    }

    public ShopOrderItem setProLogo(String proLogo) {
        this.proLogo = proLogo;
        return this;
    }

    public ShopOrderItem setProPrice(Long proPrice) {
        this.proPrice = proPrice;
        return this;
    }

    public ShopOrderItem setProNum(Integer proNum) {
        this.proNum = proNum;
        return this;
    }

    public ShopOrderItem setProSalePrice(Long proSalePrice) {
        this.proSalePrice = proSalePrice;
        return this;
    }


    public ShopOrderItem setCouponId(Long couponId) {
        this.couponId = couponId;
        return this;
    }

    public ShopOrderItem setRemark(String remark) {
        this.remark = remark;
        return this;
    }
}