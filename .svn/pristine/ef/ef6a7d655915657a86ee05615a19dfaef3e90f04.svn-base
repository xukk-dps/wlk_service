package com.shop.auth.build;

import com.shop.util.pay.Configure;
import com.shop.util.rest.RestTemplateUtils;

/**
 * 授权相关构建
 * @author xkk
 */
public class AuthBuild {


    /**
     * 获取 openID
     * @param code
     * @return str
     */
    public static String getOpenId(String code){
        StringBuffer url = new StringBuffer("https://api.weixin.qq.com/sns/jscode2session")
            .append("?appid=").append(Configure.getAppID())
            .append("&secret=").append(Configure.getSecret())
            .append("&js_code=").append(code)
            .append("&grant_type=authorization_code");
        return RestTemplateUtils.getInstance().getForObject(url.toString(),String.class);
    }

    public static void main(String[] args) {
        System.out.println(getOpenId("033dRSil2cceqB0piqil2muRil2dRSiP"));
    }
}
