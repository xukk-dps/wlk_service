package com.shop.vo.product;

import com.shop.vo.BaseVO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class ShopProductVO extends BaseVO {


    private Long id;

    /**
     * 商品名称
     */
    private String proName;

    /**
     * 商品类型
     */
    private Integer proType;

    /**
     * 商品logo
     */
    private String proLogo;
    /**
     * 商品详情
     */
    private String proDesc;
    /**
     * 商品价格（分）
     */
    private Long proPrice;

    /**
     * 商品状态0：未上架，1：已上架，2：已下架
     */
    private Integer proStatus;

    /**
     * 删除状态0：未删除，1：已删除
     */
    private Integer proDelStatus;

    /**
     * 快递是否免费0：不免费，1：免费
     */
    private Integer proCourier;

    /**
     * 发货地点
     */
    private String proSendPlace;



}