package com.shop;

import com.shop.enums.ErrorCode;
import com.shop.exception.ServiceException;
import org.apache.commons.lang3.StringUtils;

/**
 * 处理系统对接结果
 * @author xkk
 * @date 2020/3/25
 */
public class CheckResult {

    /**
     * 获取结果
     * @param httpResult
     * @param <T>
     * @return t
     */
    public static <T> T getResult(HttpResult<T> httpResult){
        //熔断异常提示
        if (ErrorCode.HYSTRIX_FALLBACK.getCode().equals(httpResult.getCode())) {
            throw new ServiceException(ErrorCode.HYSTRIX_FALLBACK, httpResult.getMessage() + ErrorCode.HYSTRIX_FALLBACK.getDesc());
        }
        //失败异常提示
        if (!ErrorCode.SUCCESS.getCode().equals(httpResult.getCode())) {
            throw new ServiceException(ErrorCode.getErrorEnum(httpResult.getCode()), httpResult.getMessage());
        }
        return httpResult.getData();
    }

    /**
     * 校验空数据
     * @param t
     * @param <T>
     */
    public static <T> void checkEmpty(T t){
        if(null == t || StringUtils.isBlank(String.valueOf(t))){
            throw new ServiceException(ErrorCode.DATA_NOT_EXIST);
        }
    }
    /**
     * 参数异常
     * @param t 对象
     * @param msg  提示
     * @param <T>
     */
    public static <T> void illegalParameter(T t,String msg){
        if(null == t || StringUtils.isBlank(String.valueOf(t))){
            throw new ServiceException(ErrorCode.ILLEGAL_PARAMETER,msg);
        }
    }
    /**
     * 校验空数据
     * @param t 对象
     * @param msg  提示
     * @param <T>
     */
    public static <T> void checkEmpty(T t,String msg){
        if(null == t || StringUtils.isBlank(String.valueOf(t))){
            throw new ServiceException(ErrorCode.DATA_NOT_EXIST,msg);
        }
    }
    /**
     * 抛出异常
     * @param errorCode
     */
    public static  void throwException(ErrorCode errorCode){
        throw new ServiceException(errorCode);
    }
    /**
     * 抛出异常
     * @param errorCode
     * @param msg 提示
     */
    public static  void throwException(ErrorCode errorCode,String msg){
        throw new ServiceException(errorCode,msg);
    }
}
