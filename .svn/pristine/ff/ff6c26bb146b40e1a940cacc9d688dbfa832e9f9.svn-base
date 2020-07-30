package com.shop.enums;

/**
 * 来源
 *
 */
public enum Source {
    SOURCE_UNKNOW(0, "未知"),
    SOURCE_WECHAT(1, "小程序"),
    SOURCE_ANDROID(2, "安卓"),
    SOURCE_IOS(3, "苹果"),
    SOURCE_WEB(4, "web网站");

    private Integer code;    //类型
    private String message;    //描述

    private Source(Integer code, String message) {
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
     * 是否包含枚举key值
     *
     * @param key
     * @return boolean true：包含，  false：不包含
     */
    public static boolean isContains(Integer key) {
        if(null == key || key == 0){return  false ;}
        for (Source e: Source.values()){
            if(key.equals(e.getCode())){
                return true;
            }
        }
        return false;
    }
}
