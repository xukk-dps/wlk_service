package com.shop.util.rest;

import org.springframework.web.client.RestTemplate;

/**
 * 静态内部类实现单例
 * @author xkk
 */
public class RestTemplateUtils {


    private static class RestTemplateHoler{
        private static RestTemplate INSTANCE = new RestTemplate();
    }
    public static RestTemplate getInstance(){
        return RestTemplateHoler.INSTANCE;
    }

    public static <T> T post(String url,Class<T> responseType){
       return getInstance().getForObject(url,responseType);
    }

}
