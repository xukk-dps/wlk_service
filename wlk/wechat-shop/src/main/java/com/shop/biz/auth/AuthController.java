package com.shop.biz.auth;

import com.alibaba.fastjson.JSONObject;
import com.shop.HttpResult;
import com.shop.auth.service.AuthService;
import com.shop.auth.service.LoginSessionService;
import com.shop.biz.BaseController;
import com.shop.dto.auth.AuthRequest;
import com.shop.dto.auth.CodeRequest;
import com.shop.dto.auth.ConfirmRequest;
import com.shop.dto.auth.PhoneRequest;
import com.shop.enums.ErrorCode;
import com.shop.enums.ExceptionCode;
import com.shop.exception.ServiceException;
import com.shop.validtion.ValidationUtil;
import com.shop.vo.auth.OpenIdVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@Controller
@ResponseBody
@RequestMapping("/auth")
public class AuthController extends BaseController {

    @Autowired
    private AuthService authService;
    @Autowired
    private LoginSessionService loginSessionService;

    /**
     * 确认授权
     *
     * @param confirmRequest
     */
    @PostMapping("/confirm")
    public HttpResult confirm(@RequestBody ConfirmRequest confirmRequest) {
        long st = System.currentTimeMillis();
        HttpResult result;
        try {
            log.info("confirm request ,{}", confirmRequest);
            ValidationUtil.validate(confirmRequest);
            confirmRequest.setSource(getResource());
            authService.confirm(confirmRequest);
            result = HttpResult.ok();
        } catch (ServiceException e) {
            ExceptionCode errorCode = e.getErrorCode();
            String desc = e.getMessage();
            result = HttpResult.build(errorCode, desc);
            log.error("confirm occurred ServiceException.errorCode:{},errorDesc:{}", e.getErrorCode(), desc);
        } catch (Exception e) {
            log.error("confirm occurred Exception.", e);
            result = HttpResult.build(ErrorCode.SYSTEM_ERROR);
        }
        log.info("confirm.resultCode:{} resultMessage:{} use time:{}", result.getCode(), result.getMessage(), (System.currentTimeMillis() - st) + " ms");
        return result;
    }
    @PostMapping("/getOpenId")
    public HttpResult<OpenIdVO> getOpenId(@RequestBody CodeRequest request) {
        long st = System.currentTimeMillis();
        HttpResult<OpenIdVO> result;
        try {
            log.info("getOpenId request ,{}", request);
            result = HttpResult.ok(authService.getToken(request));
        } catch (ServiceException e) {
            ExceptionCode errorCode = e.getErrorCode();
            String desc = e.getMessage();
            result = HttpResult.build(errorCode, desc);
            log.error("getOpenId occurred ServiceException.errorCode:{},errorDesc:{}", e.getErrorCode(), desc);
        } catch (Exception e) {
            log.error("getOpenId occurred Exception.", e);
            result = HttpResult.build(ErrorCode.SYSTEM_ERROR);
        }
        log.info("getOpenId.resultCode:{} resultMessage:{} use time:{}", result.getCode(), result.getMessage(), (System.currentTimeMillis() - st) + " ms");
        return result;
    }
    @PostMapping("/getPhone")
    public HttpResult<JSONObject> getPhone(@RequestBody PhoneRequest request) {
        long st = System.currentTimeMillis();
        HttpResult<JSONObject> result;
        try {
            log.info("getPhone request ,{}", request);
            ValidationUtil.validate(request);
            request.setSource(1);
            result = HttpResult.ok(authService.getPhone(request));
        } catch (ServiceException e) {
            ExceptionCode errorCode = e.getErrorCode();
            String desc = e.getMessage();
            result = HttpResult.build(errorCode, desc);
            log.error("getPhone occurred ServiceException.errorCode:{},errorDesc:{}", e.getErrorCode(), desc);
        } catch (Exception e) {
            log.error("getPhone occurred Exception.", e);
            result = HttpResult.build(ErrorCode.SYSTEM_ERROR);
        }
        log.info("getPhone.resultCode:{} resultMessage:{} use time:{}", result.getCode(), result.getMessage(), (System.currentTimeMillis() - st) + " ms");
        return result;
    }
    /**
     * 获取验证码
     *
     * @param token
     */
    @GetMapping("/check/{token}")
    public HttpResult  checkToken(@PathVariable("token") String token) {
        long st = System.currentTimeMillis();
        HttpResult result;
        try {
            log.info("checkToken request ,{}", token);
            result = HttpResult.ok(loginSessionService.checkToken(token));
        } catch (ServiceException e) {
            ExceptionCode errorCode = e.getErrorCode();
            String desc = e.getMessage();
            result = HttpResult.build(errorCode, desc);
            log.error("checkToken occurred ServiceException.errorCode:{},errorDesc:{}", e.getErrorCode(), desc);
        } catch (Exception e) {
            log.error("checkToken occurred Exception.", e);
            result = HttpResult.build(ErrorCode.SYSTEM_ERROR);
        }
        log.info("checkToken.resultCode:{} resultMessage:{} use time:{}", result.getCode(), result.getMessage(), (System.currentTimeMillis() - st) + " ms");
        return result;
    }
    /**
     * 获取验证码
     *
     * @param phone
     */
    @GetMapping("/code/{phone}")
    public HttpResult<String> getVerifyCode(@PathVariable("phone") String phone) {
        long st = System.currentTimeMillis();
        HttpResult<String> result;
        try {
            log.info("getVerifyCode request ,{}", phone);
            result = HttpResult.ok(authService.getVerifyCode(phone,getResource()));
        } catch (ServiceException e) {
            ExceptionCode errorCode = e.getErrorCode();
            String desc = e.getMessage();
            result = HttpResult.build(errorCode, desc);
            log.error("getVerifyCode occurred ServiceException.errorCode:{},errorDesc:{}", e.getErrorCode(), desc);
        } catch (Exception e) {
            log.error("getVerifyCode occurred Exception.", e);
            result = HttpResult.build(ErrorCode.SYSTEM_ERROR);
        }
        log.info("getVerifyCode.resultCode:{} resultMessage:{} use time:{}", result.getCode(), result.getMessage(), (System.currentTimeMillis() - st) + " ms");
        return result;
    }

    @PostMapping()
    public HttpResult<String> auth(@RequestBody AuthRequest authRequest) {
        long st = System.currentTimeMillis();
        HttpResult<String> result;
        try {
            log.info("auth request ,{}", authRequest);
            ValidationUtil.validate(authRequest);
            authRequest.setLoginIp(getIp());
            authRequest.setSource(getResource());
            result = HttpResult.ok(authService.auth(authRequest));
        } catch (ServiceException e) {
            ExceptionCode errorCode = e.getErrorCode();
            String desc = e.getMessage();
            result = HttpResult.build(errorCode, desc);
            log.error("auth occurred ServiceException.errorCode:{},errorDesc:{}", e.getErrorCode(), desc);
        } catch (Exception e) {
            log.error("auth occurred Exception.", e);
            result = HttpResult.build(ErrorCode.SYSTEM_ERROR);
        }
        log.info("auth.resultCode:{} resultMessage:{} use time:{}", result.getCode(), result.getMessage(), (System.currentTimeMillis() - st) + " ms");
        return result;
    }

    /**
     * 认证过期
     */
    @RequestMapping("/authFailure")
    public HttpResult authFailure() {
        long st = System.currentTimeMillis();
        HttpResult result;
        try {
            log.info("authFailure ");
            result = HttpResult.build(ErrorCode.AUTH_FAILURE);
        } catch (ServiceException e) {
            ExceptionCode errorCode = e.getErrorCode();
            String desc = e.getMessage();
            result = HttpResult.build(errorCode, desc);
            log.error("authFailure occurred ServiceException.errorCode:{},errorDesc:{}", e.getErrorCode(), desc);
        } catch (Exception e) {
            log.error("authFailure occurred Exception.", e);
            result = HttpResult.build(ErrorCode.SYSTEM_ERROR);
        }
        log.info("authFailure.resultCode:{} resultMessage:{} use time:{}", result.getCode(), result.getMessage(), (System.currentTimeMillis() - st) + " ms");
        return result;
    }
}
