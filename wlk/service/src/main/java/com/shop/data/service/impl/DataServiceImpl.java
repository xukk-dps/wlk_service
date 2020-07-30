package com.shop.data.service.impl;

import com.shop.CheckResult;
import com.shop.data.dao.DataDao;
import com.shop.data.factory.UserCheckFactory;
import com.shop.data.service.IDataService;
import com.shop.dto.UserAccountRequest;
import com.shop.entity.UserAccount;
import com.shop.redis.RedisUtils;
import com.shop.vo.UserAccountVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataServiceImpl extends RedisUtils implements IDataService {

    @Autowired
    private DataDao dataDao;
    @Autowired
    private UserCheckFactory userCheckFactory;


    @Override
    public UserAccountVO get(UserAccountRequest accountRequest) {
        UserAccountVO userAccountVO = new UserAccountVO();
        UserAccount userAccount = dataDao.getUserAccountByAccount(accountRequest.getAccount());
        CheckResult.checkEmpty(userAccount);
        //用户校验
        userCheckFactory.setCheck(accountRequest, userAccount);
        //查询上游接口
        //解析数据
        //过滤用户资源
        //返回结果
        //扣除费用
        userCheckFactory.deduction(userAccount);
        userAccount.setBalance(userCheckFactory.getBalance(userAccount.getAccount()));
        BeanUtils.copyProperties(userAccount, userAccountVO);
        return userAccountVO;
    }

}
