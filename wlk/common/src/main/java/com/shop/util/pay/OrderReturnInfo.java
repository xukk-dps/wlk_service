package com.shop.util.pay;

import lombok.Getter;
import lombok.Setter;

/**
 * 接收统一下单调用微信接口返回的参数
 *
 * @author Administrator
 */
@Setter
@Getter
public class OrderReturnInfo {

    private String return_code;
    private String return_msg;
    private String result_code;
    private String appid;
    private String mch_id;
    private String nonce_str;
    private String sign;
    private String prepay_id;
    private String trade_type;
    private String err_code;
    private String err_code_des;


}