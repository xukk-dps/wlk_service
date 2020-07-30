package com.shop.dto.product;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class ReceiveAddressRequest {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 收货人
     */
    private String receiveName;

    /**
     * 收货人手机号
     */
    private String receivePhone;

    /**
     * 详细收货地址
     */
    private String receiveAddress;

}