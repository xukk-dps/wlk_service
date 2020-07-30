package com.shop.data.factory;

import com.shop.CheckResult;
import com.shop.constant.UserConstant;
import com.shop.dto.UserAccountRequest;
import com.shop.entity.UserAccount;
import com.shop.enums.ErrorCode;
import com.shop.redis.RedisUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

/**
 * 用户校验
 */
@Component
public class UserCheckFactory extends RedisUtils {


    private UserAccountRequest request;
    private UserAccount userAccount;

    /**
     * 校验用户
     *
     * @param request
     * @param userAccount
     */
    public void setCheck(UserAccountRequest request, UserAccount userAccount) {
        this.request = request;
        this.userAccount = userAccount;
        check();
    }

    /**
     * 用户校验
     */
    private void check() {
        //校验ip白名单
        this.checkIpAddress();
        //校验用户状态
        this.checkUserStatus();
        //校验密码
        this.checkUserPassword();
        //校验余额
        this.checkBalance();
        //校验当日上线
        this.checkDayMaxMum();
        //校验最大上线
        this.checkMaxMum();

    }

    /**
     * 校验IP是否是白名单
     */
    private void checkIpAddress() {
        if (StringUtils.isBlank(userAccount.getIpAddress())) {
            CheckResult.throwException(ErrorCode.USER_NOT_SET_IP_WHITE);
        }
        if (!userAccount.getIpAddress().contains(request.getIpAddress())) {
            CheckResult.throwException(ErrorCode.USER_IP_NOT_WHITE);
        }
    }

    /**
     * 校验用户状态 1：正常，0:注销(未激活)
     */
    private void checkUserStatus() {
        if (null == userAccount.getStatus() || userAccount.getStatus() == 0) {
            CheckResult.throwException(ErrorCode.USER_LOCKED);
        }
    }

    /**
     * 校验用户密码
     */
    private void checkUserPassword() {
        if (StringUtils.isBlank(userAccount.getPassword())) {
            CheckResult.throwException(ErrorCode.USER_PWD_ERROR);
        }
        if (!userAccount.getPassword().equals(request.getPassword())) {
            CheckResult.throwException(ErrorCode.USER_PWD_ERROR);
        }
    }

    /**
     * 校验余额
     */
    private void checkBalance() {
        //根据账号从缓存中分别取出用户信息，用户余额，然后计算，公式为 余额 - 单价 < 0 为余额不足
        double balance = getBalance(userAccount.getAccount());
        Double price = userAccount.getPrice() == null ? 0 : userAccount.getPrice();
        if (balance - price < 0) {
            CheckResult.throwException(ErrorCode.USER_BALANCE_ARREARS);
        }
    }

    /**
     * 校验当日最大调用限制
     */
    private void checkDayMaxMum() {

    }

    /**
     * 校验最大调用限制
     */
    private void checkMaxMum() {

    }

    /**
     * 扣款
     */
    public void deduction(UserAccount userAccount) {
        setT(UserConstant.USER_PREFIX + userAccount.getAccount(), getBalance(userAccount.getAccount()) - userAccount.getPrice());
    }

    /**
     * 获取余额
     *
     * @return long
     */
    public double getBalance(String account) {
        Double balance = getT(UserConstant.USER_PREFIX + account);
        if (null != balance) {
            return balance;
        }
        // 如果缓存中余额为空，则重新计算余额
        //todo 临时数据
        balance = 10000D;
        setT(UserConstant.USER_PREFIX + account, balance);
        return balance;
    }
}
