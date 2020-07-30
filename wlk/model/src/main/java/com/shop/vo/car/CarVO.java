package com.shop.vo.car;

import com.shop.vo.BaseVO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@ToString
@Getter
@Setter
public class CarVO extends BaseVO {


    private Long id;

    /**
     * 商品名称
     */
    private String title;

    /**
     * 商品类型
     */
    private Integer proType;

    /**
     * 商品logo
     */
    private String imgUrl;
    /**
     * 现价
     */
    private BigDecimal current;
    /**
     * 门市价
     */
    private BigDecimal original;

    /**
     * 已购
     */
    private Integer num;
    /**
     * 剩余
     */
    private Integer nums;

    private Boolean isSelect;
    /**
     * 数量
     */
    private Integer count;
}