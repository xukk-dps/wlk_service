package com.shop.user.service;

import com.shop.CheckResult;
import com.shop.data.factory.UserCheckFactory;
import com.shop.dto.user.ShopUserRequest;
import com.shop.entity.ShopUser;
import com.shop.redis.RedisUtils;
import com.shop.user.dao.UserDao;
import com.shop.vo.ShopUserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends RedisUtils {

    @Autowired
    private UserDao userDao;
    @Autowired
    private UserCheckFactory userCheckFactory;


    public ShopUserVO get(ShopUserRequest request) {
        ShopUserVO shopUserVO = new ShopUserVO();
        ShopUser shopUser = userDao.getUserAccountByPhone(request.getPhone());
        CheckResult.checkEmpty(shopUser);
        BeanUtils.copyProperties(shopUser, shopUserVO);
        return shopUserVO;
    }

}
