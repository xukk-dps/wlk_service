package com.shop.dto.car;

import com.shop.dto.BaseDTO;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;

@ToString
@Getter
public class ShopCarRequest extends BaseDTO {


    private Long id;

    private Long userId;

    /**
     * 商品名称
     */
    private String proName;

    /**
     * 商品id
     */
    private Long proId;

    /**
     * 商品logo
     */
    private String proLogo;

    /**
     * 价格
     */
    private BigDecimal proPrice;

    /**
     * 商品数量
     */
    private Integer proNum;

    /**
     * 来源
     */
    private Integer source;

    /**
     * 购物车状态0：未删除，1：已删除
     */
    private Integer carStatus;

    public ShopCarRequest setId(Long id) {
        this.id = id;
        return this;
    }

    public ShopCarRequest setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public ShopCarRequest setProName(String proName) {
        this.proName = proName;
        return this;
    }

    public ShopCarRequest setProId(Long proId) {
        this.proId = proId;
        return this;
    }

    public ShopCarRequest setProLogo(String proLogo) {
        this.proLogo = proLogo;
        return this;
    }

    public ShopCarRequest setProPrice(BigDecimal proPrice) {
        this.proPrice = proPrice;
        return this;
    }

    public ShopCarRequest setProNum(Integer proNum) {
        this.proNum = proNum;
        return this;
    }

    public ShopCarRequest setSource(Integer source) {
        this.source = source;
        return this;
    }

    public ShopCarRequest setCarStatus(Integer carStatus) {
        this.carStatus = carStatus;
        return this;
    }
}