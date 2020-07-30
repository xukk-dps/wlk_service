package com.shop.dto.order;

import com.shop.annonation.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderRequest {


    /**
     * 用户id
     */
    private Long userId;

    /**
     * 用户名称
     */
    private String userName;
    /**
     * 收货人姓名
     */
    @NotBlank(message = "收货人姓名",minLen = 1,maxLen = 50)
    private String receiveName;
    /**
     * 收货人手机号
     */
    @NotBlank(message = "收货人手机号",minLen = 5,maxLen = 11)
    private String receivePhone;
    /**
     * 收货地址
     */
    @NotBlank(message = "收货地址",minLen = 5,maxLen = 200)
    private String receiveAddress;
    /**
     * 来源
     */
    private Integer source;
    /**
     * 订单集合
     */
    private List<OrderItemRequest> itemRequestList;

}