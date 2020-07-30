package com.shop.auth.service;

import com.alibaba.fastjson.JSONObject;
import com.shop.CheckResult;
import com.shop.auth.build.AuthBuild;
import com.shop.auth.dao.VerifyCodeDao;
import com.shop.dto.auth.AuthRequest;
import com.shop.dto.auth.CodeRequest;
import com.shop.dto.auth.ConfirmRequest;
import com.shop.dto.auth.PhoneRequest;
import com.shop.entity.ShopUser;
import com.shop.entity.VerifyCode;
import com.shop.enums.AccountStatus;
import com.shop.enums.ErrorCode;
import com.shop.redis.RedisUtils;
import com.shop.user.dao.UserDao;
import com.shop.util.AccountUtils;
import com.shop.util.pay.Configure;
import com.shop.util.pay.HttpRequestClient;
import com.shop.vo.auth.OpenIdVO;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.AlgorithmParameters;
import java.security.Security;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class AuthService extends RedisUtils {

    /**
     * 手机号key前缀
     */
    private String authPrefix = "auth_";
    /**
     * 验证码过期时间（180s）
     */
    private long expireTime = 180L;

    @Autowired
    private UserDao userDao;
    @Autowired
    private VerifyCodeDao verifyCodeDao;
    @Autowired
    private LoginSessionService loginSessionService;

    /**
     * 确认
     *
     * @param request
     */
    @Transactional
    public void confirm(ConfirmRequest request) {
        //校验是否已经确认过
        ShopUser shopUser = userDao.getUserAccountByPhone(request.getPhone());
        if (null != shopUser) {
            return;
        }
        //执行新增
        shopUser = new ShopUser()
                .setPhone(request.getPhone())
                .setAccount(AccountUtils.createAccount(request.getPhone()))
                .setOpenId(request.getOpenId())
                .setSource(request.getSource())
                .setUnionId(request.getUnionId());
        if (!userDao.add(shopUser)) {
            CheckResult.throwException(ErrorCode.USER_CONFIRM_FAIL);
        }
    }
    public OpenIdVO getToken(CodeRequest request){
        log.info("getToken code : {}",request.getCode());
        String result = AuthBuild.getOpenId(request.getCode());
        log.info("getToken result : {}",result);
        OpenIdVO vo = JSONObject.parseObject(result,OpenIdVO.class);
        return vo;
    }
    /**
     *
     * @param request
     * @return str
     */
    public JSONObject getPhone(PhoneRequest request) {
        JSONObject  jsonObject = getPhoneNumber(request.getSession_key(),request.getEncryptedData(),request.getIv());
        if(null == jsonObject){
            return null;
        }
        return jsonObject;
    }
    /**
     * 解密手机号
     * @author kemi
     * @param session_key
     * @param encryptedData
     * @param iv
     * @return json
     */
    private JSONObject getPhoneNumber(String session_key, String encryptedData, String iv ){
        byte[] dataByte = Base64.decode(encryptedData);
        byte[] keyByte = Base64.decode(session_key);
        byte[] ivByte = Base64.decode(iv);
        try {
            int base = 16;
            if (keyByte.length % base != 0) {
                int groups = keyByte.length / base + (keyByte.length % base != 0 ? 1 : 0);
                byte[] temp = new byte[groups * base];
                Arrays.fill(temp, (byte) 0);
                System.arraycopy(keyByte, 0, temp, 0, keyByte.length);
                keyByte = temp;
            }
            // 初始化
//            Security.addProvider(new BouncyCastleProvider());
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            SecretKeySpec spec = new SecretKeySpec(keyByte, "AES");
            AlgorithmParameters parameters = AlgorithmParameters.getInstance("AES");
            parameters.init(new IvParameterSpec(ivByte));
            cipher.init(Cipher.DECRYPT_MODE, spec, parameters);
            byte[] resultByte = cipher.doFinal(dataByte);
            if (null != resultByte && resultByte.length > 0) {
                String result = new String(resultByte, "UTF-8");
                return JSONObject.parseObject(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  null;
    }
    /**
     * 获取验证码
     *
     * @param phone
     * @return str
     */
    @Transactional
    public String getVerifyCode(String phone, int source) {
        CheckResult.illegalParameter(phone, "手机号为空");
        //如果验证码没有过期，则给出提示，已经获取过验证码
        String veryCode = getT(handleKey(source, phone));
        if (StringUtils.isNotBlank(veryCode)) {
            CheckResult.throwException(ErrorCode.AUTH_ALREADY_SEND_VERY_CODE);
        }
        String code = createVerifyCode();
        code = "1234";
        //验证码入库记录
        verifyCodeDao.add(new VerifyCode().setPhone(phone).setVerifyCode(code).setSource(source));
        //插入缓存
        setT(handleKey(source, phone), code, expireTime);
        return code;
    }

    /**
     * 认证
     *
     * @param request
     */
    @Transactional
    public String auth(AuthRequest request) {
        String verifyCode = getT(handleKey(request.getSource(), request.getPhone()));
        CheckResult.checkEmpty(verifyCode, "请重新获取验证码");
        if (!request.getPassword().equals(verifyCode)) {
            CheckResult.throwException(ErrorCode.AUTH_VERY_CODE_ERROR);
        }
        //认证成功后删除验证码
        remove(handleKey(request.getSource(), request.getPhone()));
        //把验证码/认证状态更新到用户表
        ShopUser shopUser = userDao.getUserAccountByPhone(request.getPhone());
        if (null == shopUser) {
            CheckResult.throwException(ErrorCode.AUTH_FAIL, "请重新确认授权");
        }
        //执行修改
        shopUser.setPassword(verifyCode);
        shopUser.setStatus(AccountStatus.AUTH_ALREADY.getCode());
        if (!userDao.updateUser(shopUser)) {
            CheckResult.throwException(ErrorCode.AUTH_FAIL, "账户修改失败");
        }
        //认证通过后，把认证信息保存起来，有效期30天
        return loginSessionService.updateLoginSession(request.getLoginIp(),request.getSource(), shopUser);
    }


    /**
     * 组装缓存key
     * 前缀+来源+手机号
     *
     * @param phone
     * @return str
     */
    private String handleKey(int source, String phone) {
        return authPrefix + source + "_" + phone;
    }

    /**
     * 获取四位验证码
     *
     * @return str
     */
    private String createVerifyCode() {
        return String.valueOf((int) ((Math.random() * 9 + 1) * 1000));
    }


}
