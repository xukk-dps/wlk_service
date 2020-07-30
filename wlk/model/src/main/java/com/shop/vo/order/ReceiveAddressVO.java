package com.shop.vo.order;

import com.shop.vo.BaseVO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class ReceiveAddressVO extends BaseVO{
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
     * 省
     */
//    private String provice;
//
//    /**
//     * 市
//     */
//    private String city;
//
//    /**
//     * 区/县
//     */
//    private String area;

    /**
     * 详细收货地址
     */
    private String receiveAddress;

    /**
     * 是否是默认地址0:不是，1:是
     */
    private Integer defaultFlag;
}