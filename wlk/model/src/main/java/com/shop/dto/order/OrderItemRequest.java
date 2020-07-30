package com.shop.dto.order;

import com.shop.annonation.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class OrderItemRequest {


    private Long id;

    /**
     * 商品名称
     */
    @NotBlank(message = "商品名称",maxLen = 100)
    private String title;

    /**
     * 商品类型
     */
    private Integer proType;

    /**
     * 商品logo
     */
    @NotBlank(message = "商品logo",maxLen = 100)
    private String imgUrl;
    /**
     * 现价
     */
    @NotBlank(message = "商品价格",maxLen = 100)
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
    @NotBlank(message = "商品数量",minLen = 1,maxLen = 999999999)
    private Integer count;

    /**
     * 备注
     */
    private String remark;

}