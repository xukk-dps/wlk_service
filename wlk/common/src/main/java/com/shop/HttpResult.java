package com.shop;

import com.shop.enums.ErrorCode;
import com.shop.enums.ExceptionCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @author gary
 */
@Getter
@Setter
public class HttpResult<T> {

    /**
     * 0:成功 1:失败
     */
    private String code;

    /**
     * SUCCESS | FAIL
     */
    private String message;

    private T data;

    public HttpResult() {
        ExceptionCode errorCode = ErrorCode.SUCCESS;
        this.setCode(errorCode.getCode());
        this.setMessage(errorCode.getDesc());
    }

    public HttpResult(ExceptionCode errorCode, String desc) {
        if (errorCode == null) {
            errorCode = ErrorCode.SUCCESS;
        }
        this.setCode(errorCode.getCode());
        this.setMessage(desc);
    }

    public HttpResult(T data) {
        ExceptionCode errorCode = ErrorCode.SUCCESS;
        this.code = errorCode.getCode();
        this.message = errorCode.getDesc();
        this.data = data;
    }

    public HttpResult(ExceptionCode errorCode, String message, T data) {
        this.code = errorCode.getCode();
        this.message = message;
        this.data = data;
    }

    public static HttpResult ok() {
        return new HttpResult();
    }

    public static <T> HttpResult<T> ok(T data) {
        return new HttpResult<>(data);
    }

    public HttpResult(ExceptionCode errorCode, T data) {
        this.code = errorCode.getCode();
        this.data = data;
        this.message = errorCode.getDesc();
    }

    public static <T> HttpResult ok(T data, String message) {
        return new HttpResult<>(ErrorCode.SUCCESS, message, data);
    }

    public static <T> HttpResult<T> build(ExceptionCode errorCode) {
        if (errorCode == null) {
            errorCode = ErrorCode.SUCCESS;
        }
        return new HttpResult<>(errorCode, errorCode.getDesc());
    }

    public static HttpResult build(String message) {

        return new HttpResult(ErrorCode.SYSTEM_ERROR, message);
    }

    public static HttpResult build(ExceptionCode errorCode, Object data) {
        if (errorCode == null) {
            errorCode = ErrorCode.ILLEGAL_PARAMETER;
        }
        return new HttpResult<>(errorCode, data);
    }

    public static <T> HttpResult<T> build(ExceptionCode errorCode, String message) {
        if (errorCode == null) {
            errorCode = ErrorCode.ILLEGAL_PARAMETER;
        }
        return new HttpResult<>(errorCode, message);
    }

    @Override
    public String toString() {
        return "HttpResult{" + "code=" + code + ", message='" + message + '\'' + ", data=" + data + '}';
    }
}
