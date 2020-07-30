package com.shop.enums;

/**
 * 异常码
 * 9xx系统级异常
 * 8xx用户级异常
 * 1xxx参数级异常
 * @author xkk
 */
public enum ErrorCode  implements ExceptionCode {

    /**defined*/
    SYSTEM_ERROR("999", "系统异常"),
    HYSTRIX_FALLBACK("991", " service is temporarily inaccessible"),
    SUCCESS("1000","成功"),
    USER_ILLEGAL("880", "非法用户"),
    USER_NOT_SET_IP_WHITE("881", "用户未配置白名单"),
    USER_IP_NOT_WHITE("882", "当前IP不是白名单"),
    USER_LOCKED("883", "用户已锁定"),
    USER_PWD_ERROR("884", "密码不正确"),
    USER_BALANCE_ARREARS("885", "余额不足"),
    USER_MORE_DAY_MAX_NUM("886", "超过当日最大调用上限"),
    USER_MORE_MAX_NUM("887", "超过最大调用上限"),
    USER_CREATE_FAIL("889", "用户创建失败"),
    USER_CONFIRM_FAIL("890", "确认失败"),
    DATA_NOT_EXIST("1002","数据不存在"),
    AUTH_VERY_CODE_ERROR("700","验证码错误"),
    AUTH_ALREADY_SEND_VERY_CODE("701","验证码已发送【有效期3分钟】"),
    AUTH_FAIL("702","认证失败"),
    AUTH_FAILURE("703","认证过期"),
    ORDER_END("600","订单已完成"),
    UNKNOWN_EXCEPTION ("998","未知异常"),
    ILLEGAL_CHARACTER("8000","含有非法字符"),
    ILLEGAL_PARAMETER("8001","参数异常");

    private String code;

    private String desc;

    ErrorCode(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    /**
     * 根据返回码取出枚举类型
     * @param code
     * @return ErrorCode
     */
    public static ErrorCode getErrorEnum(String code){
        for (ErrorCode e : ErrorCode.values()) {
            if(code.equals(e.getCode())){
                return e;
            }
        }
        return UNKNOWN_EXCEPTION;
    }
}
