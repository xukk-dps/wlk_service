package com.shop.util;

import com.alibaba.fastjson.JSONObject;
import com.shop.dto.HeaderEntity;
import com.shop.dto.auth.ShopUserDTO;
import com.shop.util.enc.AESSecurityDecrypt;

/**
 * 获取登录用户信息
 */
public class LoginUserUtils {

    /**
     * 头部信息
     */
    public static HeaderEntity header() {
        return new HeaderEntity()
                .setSource(HttpServletUtils.getRequestHeader("source"))
                .setToken(HttpServletUtils.getRequestHeader("token"));
    }

    /**
     * 从token中获取登录用户基本信息
     *
     * @return LotteryUserDTO
     */
    public static ShopUserDTO getLotteryUserDTO() {
        String token = header().getToken();
        return JSONObject.parseObject(AESSecurityDecrypt.decrypt(token), ShopUserDTO.class);
    }

    public static Long getUserId() {
        return getLotteryUserDTO().getId();
    }

    public static String getAccount() {
        return getLotteryUserDTO().getAccount();
    }
    public static String getUserName() {
        return getLotteryUserDTO().getUserName();
    }
    public static String getIp() {
        return HttpServletUtils.getRequestIp();
    }

}
