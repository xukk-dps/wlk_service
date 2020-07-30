package com.shop.exception;

import com.shop.enums.ExceptionCode;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @author xkk
 */
public class ServiceException extends RuntimeException {

    private ExceptionCode errorCode;



    public ServiceException(ExceptionCode errorCode){
        super(errorCode.getDesc());
        this.errorCode = errorCode;
    }

    public ServiceException(ExceptionCode errorCode, String message){
        super(message);
        this.errorCode = errorCode;
    }

    public ServiceException(ExceptionCode errorCode, Throwable cause, String message){
        super(message, cause);
        this.errorCode = errorCode;
    }

    public ServiceException(Throwable cause){
        super(cause);
    }

    public ExceptionCode getErrorCode() {
        return errorCode;
    }

    public ServiceException setErrorCode(ExceptionCode errorCode) {
        this.errorCode = errorCode;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(errorCode, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
