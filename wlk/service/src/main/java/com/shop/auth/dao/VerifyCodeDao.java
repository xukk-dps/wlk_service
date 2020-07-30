package com.shop.auth.dao;

import com.shop.annonation.RedisAnno;
import com.shop.entity.ShopUser;
import com.shop.entity.VerifyCode;
import com.shop.enums.UserStatus;
import com.shop.mapper.ShopUserMapper;
import com.shop.mapper.VerifyCodeMapper;
import com.shop.redis.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class VerifyCodeDao extends RedisUtils {

    @Autowired
    private VerifyCodeMapper verifyCodeMapper;


    /**
     * 插入数据
     * @param verifyCode
     * @return boolean
     */
    public boolean add(VerifyCode verifyCode) {
        verifyCode.setCreateTime(new Date());
        return verifyCodeMapper.insert(verifyCode) > 0;
    }
}
