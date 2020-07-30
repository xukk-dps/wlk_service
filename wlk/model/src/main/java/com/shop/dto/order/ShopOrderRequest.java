package com.shop.dto.order;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class ShopOrderRequest {



    /**
     * 用户id
     */
    private Long userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 交易号
     */
    private String transactionNo;

    /**
     * 流水号
     */
    private String serialNo;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 商品属性
     */
    private String proAttribute;
    /**
     * 商品id
     */
    private Long proId;
    /**
     * 商品名称
     */
    private String proName;

    /**
     * 订单logo
     */
    private String proLogo;

    /**
     * 订单原价
     */
    private BigDecimal proPrice;

    /**
     * 订单实际成交价
     */
    private BigDecimal proSalePrice;

    /**
     * 使用的优惠券id
     */
    private Long couponId;

    /**
     * 收货地址
     */
    private String receiveAddress;

    /**
     * 收货人姓名
     */
    private String receiveName;

    /**
     * 收货人手机号
     */
    private String receivePhone;

    /**
     * 订单状态0：待付款，1：待发货，2：待确认收获，3：待评价，4：已完成，5：已取消，6:已退款
     */
    private Integer orderStatus;

    /**
     * 来源
     */
    private Integer source;

    /**
     * 交易起始时间
     */
    private Date timeStart;

    /**
     * 交易结束时间
     */
    private Date timeExpire;

    /**
     * 支付方式
     */
    private Integer payMethod;

    /**
     * 备注
     */
    private String remark;

}