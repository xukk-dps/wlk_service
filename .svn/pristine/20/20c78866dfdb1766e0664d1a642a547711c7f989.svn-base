package com.shop.data.dao;

import com.shop.entity.UserAccount;
import com.shop.mapper.UserAccountMapper;
import com.shop.redis.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataDao extends RedisUtils {

    @Autowired
    private UserAccountMapper accountMapper;

    /**
     * 根据账号查询数据
     * @param account
     * @return UserAccount
     */
    public UserAccount getUserAccountByAccount(String account) {
        UserAccount userAccount = getT(account);
//        if(null != userAccount){
//            System.out.println("查询缓存");
//            return userAccount;
//        }
        userAccount = accountMapper.selectOne(new UserAccount().setAccount(account));
        System.out.println("查询数据库");
        setT(account,userAccount);
        return userAccount;
    }


}
