package com.shop.vo.order;

import com.shop.vo.BaseVO;
import com.shop.vo.product.ProductVO;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 订单回显
 */
@Getter
@Setter
public class OrderShowVO extends BaseVO {


    /**
     * 订单id
     */
    private Long id;
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
     * 商品信息
     */
    private List<ProductVO> productVOS;
    /**
     * 订单原价
     */
    private BigDecimal proPrice;
    /**
     * 应付金额
     */
    private BigDecimal payable;
    /**
     * 订单实际成交价
     */
    private BigDecimal proSalePrice;
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
     * 交易起始时间
     */
    private String timeStart;

    /**
     * 交易结束时间
     */
    private String timeExpire;

    /**
     * 支付方式
     */
    private Integer payMethod;

    /**
     * 订单状态
     */
    private String status;

    /**
     * 备注
     */
    private String remark;
}