package com.shop.auth.service;

import com.shop.auth.dao.VerifyCodeDao;
import com.shop.entity.VerifyCode;
import com.shop.redis.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VerifyCodeService extends RedisUtils {


    @Autowired
    private VerifyCodeDao verifyCodeDao;

    /**
     * 插入验证码
     * @param verifyCode
     * @return boolean
     */
    public boolean add(VerifyCode verifyCode){
        return verifyCodeDao.add(verifyCode);
    }
}
