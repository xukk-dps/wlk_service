package com.shop.enums;

public enum  SignType {

    MD5("UTF-8", "MD5加密算法");

    private String code;    //类型
    private String message;    //描述

    private SignType(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
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
    public static boolean isContains(String key) {
        if(null == key || "".equals(key)){return  false ;}
        for (Source e: Source.values()){
            if(key.equals(e.getCode())){
                return true;
            }
        }
        return false;
    }
}
