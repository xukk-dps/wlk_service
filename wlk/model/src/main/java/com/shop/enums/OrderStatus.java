package com.shop.enums;

/**
 * 订单状态0：待付款，1：待发货，2：待确认收获，3：待评价，4：已完成，5：已取消，6：已退款
 */
public enum OrderStatus {
    WAIT_PAY(0, "待付款"),
    WAIT_SEND(1, "待发货"),
    WAIT_CONFIRM(2, "待确认收获"),
    WAIT_PJ(3, "待评价"),
    SUCCESS(4, "已完成"),
    CANCEL(5, "已取消"),
    REFUNDED(6, "已退款");

    private Integer code;    //类型
    private String message;    //描述

    private OrderStatus(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    /**
     * 根据key获取枚举描述
     *
     * @param key
     * @return str
     */
    public static String getMessage(Integer key) {
        if(null == key){return  "未知" ;}
        for (OrderStatus e: OrderStatus.values()){
            if(key.equals(e.getCode())){
                return e.getMessage();
            }
        }
        return "未知";
    }
}
