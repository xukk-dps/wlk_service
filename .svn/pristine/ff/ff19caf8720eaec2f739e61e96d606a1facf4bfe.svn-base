package com.shop.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import javax.persistence.*;
@ToString
@Getter
@Table(name = "shop_transaction")
public class ShopTransaction {
    /**
     * 交易号
     */
    @Column(name = "transaction_no")
    private String transactionNo;

    /**
     * 小程序ID
     */
    private String appid;

    /**
     * 商户号
     */
    @Column(name = "mch_id")
    private String mchId;

    /**
     * 随机字符串
     */
    @Column(name = "nonce_str")
    private String nonceStr;

    /**
     * 签名
     */
    private String sign;

    /**
     * 签名类型
     */
    @Column(name = "sign_type")
    private String signType;

    /**
     * 商品描述
     */
    private String body;

    /**
     * 商户订单号
     */
    @Column(name = "out_trade_no")
    private String outTradeNo;

    /**
     * 标价金额(分)
     */
    @Column(name = "total_fee")
    private Long totalFee;

    /**
     * 终端IP
     */
    @Column(name = "spbill_create_ip")
    private String spbillCreateIp;

    /**
     * 通知地址
     */
    @Column(name = "notify_url")
    private String notifyUrl;

    /**
     * 交易类型
     */
    @Column(name = "trade_type")
    private String tradeType;

    /**
     * 流水号
     */
    @Column(name = "serial_no")
    private String serialNo;

    /**
     * 用户
     */
    private Long user;

    /**
     * 商品ID
     */
    @Column(name = "product_id")
    private Long productId;

    /**
     * 支付方式1:微信，2:支付宝,3:ios,4:银行卡
     */
    @Column(name = "pay_method")
    private Integer payMethod;

    /**
     * 交易状态0：初始状态，1:支付成功，2:支付失败
     */
    @Column(name = "transaction_status")
    private Integer transactionStatus;

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

    public ShopTransaction setTransactionNo(String transactionNo) {
        this.transactionNo = transactionNo;
        return this;
    }

    public ShopTransaction setAppid(String appid) {
        this.appid = appid;
        return this;
    }

    public ShopTransaction setMchId(String mchId) {
        this.mchId = mchId;
        return this;
    }

    public ShopTransaction setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
        return this;
    }

    public ShopTransaction setSign(String sign) {
        this.sign = sign;
        return this;
    }

    public ShopTransaction setSignType(String signType) {
        this.signType = signType;
        return this;
    }

    public ShopTransaction setBody(String body) {
        this.body = body;
        return this;
    }

    public ShopTransaction setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
        return this;
    }

    public ShopTransaction setTotalFee(Long totalFee) {
        this.totalFee = totalFee;
        return this;
    }

    public ShopTransaction setSpbillCreateIp(String spbillCreateIp) {
        this.spbillCreateIp = spbillCreateIp;
        return this;
    }

    public ShopTransaction setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
        return this;
    }

    public ShopTransaction setTradeType(String tradeType) {
        this.tradeType = tradeType;
        return this;
    }

    public ShopTransaction setSerialNo(String serialNo) {
        this.serialNo = serialNo;
        return this;
    }

    public ShopTransaction setUser(Long user) {
        this.user = user;
        return this;
    }

    public ShopTransaction setProductId(Long productId) {
        this.productId = productId;
        return this;
    }

    public ShopTransaction setPayMethod(Integer payMethod) {
        this.payMethod = payMethod;
        return this;
    }

    public ShopTransaction setTransactionStatus(Integer transactionStatus) {
        this.transactionStatus = transactionStatus;
        return this;
    }

    public ShopTransaction setTimeStart(Date timeStart) {
        this.timeStart = timeStart;
        return this;
    }

    public ShopTransaction setTimeExpire(Date timeExpire) {
        this.timeExpire = timeExpire;
        return this;
    }
}