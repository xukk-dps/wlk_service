package com.shop.entity;

import lombok.Getter;
import lombok.ToString;

import java.util.Date;
import javax.persistence.*;

@ToString
@Getter
@Table(name = "shop_order")
public class ShopOrder extends BaseDO{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 用户名
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 交易号
     */
    @Column(name = "transaction_no")
    private String transactionNo;

    /**
     * 支付流水号
     */
    @Column(name = "serial_no")
    private String serialNo;

    /**
     * 订单号
     */
    @Column(name = "order_no")
    private String orderNo;

    /**
     * 订单总金额
     */
    @Column(name = "order_total")
    private Long orderTotal;

    /**
     * 使用的优惠券id
     */
    @Column(name = "coupon_id")
    private Long couponId;

    /**
     * 收货地址
     */
    @Column(name = "receive_address")
    private String receiveAddress;

    /**
     * 收货人姓名
     */
    @Column(name = "receive_name")
    private String receiveName;

    /**
     * 收货人手机号
     */
    @Column(name = "receive_phone")
    private String receivePhone;

    /**
     * 订单状态0：待付款，1：待发货，2：待确认收获，3：待评价，4：已完成，5：已取消，6:已退款
     */
    @Column(name = "order_status")
    private Integer orderStatus;

    /**
     * 来源
     */
    private Integer source;

    /**
     * 交易起始时间
     */
    @Column(name = "time_start")
    private Date timeStart;

    /**
     * 交易结束时间
     */
    @Column(name = "time_expire")
    private Date timeExpire;

    /**
     * 支付方式1:微信，2:支付宝,3:ios,4:银行卡
     */
    @Column(name = "pay_method")
    private Integer payMethod;

    /**
     * 备注
     */
    private String remark;

    public ShopOrder setId(Long id) {
        this.id = id;
        return this;
    }

    public ShopOrder setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public ShopOrder setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public ShopOrder setTransactionNo(String transactionNo) {
        this.transactionNo = transactionNo;
        return this;
    }

    public ShopOrder setSerialNo(String serialNo) {
        this.serialNo = serialNo;
        return this;
    }

    public ShopOrder setOrderNo(String orderNo) {
        this.orderNo = orderNo;
        return this;
    }

    public ShopOrder setOrderTotal(Long orderTotal) {
        this.orderTotal = orderTotal;
        return this;
    }

    public ShopOrder setCouponId(Long couponId) {
        this.couponId = couponId;
        return this;
    }

    public ShopOrder setReceiveAddress(String receiveAddress) {
        this.receiveAddress = receiveAddress;
        return this;
    }

    public ShopOrder setReceiveName(String receiveName) {
        this.receiveName = receiveName;
        return this;
    }

    public ShopOrder setReceivePhone(String receivePhone) {
        this.receivePhone = receivePhone;
        return this;
    }

    public ShopOrder setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
        return this;
    }

    public ShopOrder setSource(Integer source) {
        this.source = source;
        return this;
    }

    public ShopOrder setTimeStart(Date timeStart) {
        this.timeStart = timeStart;
        return this;
    }

    public ShopOrder setTimeExpire(Date timeExpire) {
        this.timeExpire = timeExpire;
        return this;
    }

    public ShopOrder setPayMethod(Integer payMethod) {
        this.payMethod = payMethod;
        return this;
    }

    public ShopOrder setRemark(String remark) {
        this.remark = remark;
        return this;
    }
}