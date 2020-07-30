package com.shop.user.dao;

import com.shop.annonation.RedisAnno;
import com.shop.entity.ShopUser;
import com.shop.entity.UserAccount;
import com.shop.enums.AccountStatus;
import com.shop.enums.UserStatus;
import com.shop.mapper.ShopUserMapper;
import com.shop.mapper.UserAccountMapper;
import com.shop.redis.RedisUtils;
import com.shop.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class UserDao extends RedisUtils {

    @Autowired
    private ShopUserMapper userMapper;

    /**
     * 根据账号查询数据
     *
     * @param account
     * @return UserAccount
     */
//    @RedisAnno(key = "#account",prefix = "user_")
    public ShopUser getUserAccountByAccount(String account) {
        return userMapper.selectOne(new ShopUser().setAccount(account).setDelFlag(UserStatus.NOT_DEL.getCode()));
    }
    /**
     * 根据手机号查询数据
     *
     * @param phone
     * @return UserAccount
     */
//    @RedisAnno(key = "#phone",prefix = "user_")
    public ShopUser getUserAccountByPhone(String phone) {
        return userMapper.selectOne(new ShopUser().setPhone(phone).setDelFlag(UserStatus.NOT_DEL.getCode()));
    }
    /**
     * 更新数据
     *
     * @param user
     * @return boolean
     */
    public boolean updateUser(ShopUser user) {
        user.setUpdateTime(new Date());
        return userMapper.updateByPrimaryKey(user) > 0;
    }

    /**
     * 插入用户
     * @param shopUser
     * @return boolean
     */
    public boolean add(ShopUser shopUser) {
        shopUser.setCreateTime(new Date());
        shopUser.setUpdateTime(new Date());
        shopUser.setStatus(AccountStatus.AUTH_NOT.getCode());
        shopUser.setDelFlag(UserStatus.NOT_DEL.getCode());
        return userMapper.insert(shopUser) > 0;
    }
}
