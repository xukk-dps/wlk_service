package com.shop.auth.dao;

import com.shop.entity.LoginSession;
import com.shop.entity.VerifyCode;
import com.shop.mapper.LoginSessionMapper;
import com.shop.mapper.VerifyCodeMapper;
import com.shop.redis.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

@Component
public class LoginSessionDao extends RedisUtils {

    @Autowired
    private LoginSessionMapper loginSessionMapper;

    /**
     * 查询最新一条登录信息
     * @param phone
     * @param source
     * @return LoginSession
     */
    public LoginSession getLoginSessionBySource(String phone,int source){
        Example example = new Example(LoginSession.class);
        example.setOrderByClause(" id desc limit 1 ");
        Example.Criteria criteria =example.createCriteria();
        criteria.andEqualTo("phone",phone);
        criteria.andEqualTo("source",source);
        List<LoginSession> list = loginSessionMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(list)){
           return null;
        }
        return list.get(0);
    }
    /**
     * 更加token查询数据
     * @param token
     * @return  LoginSession
     */
    public LoginSession getLoginSessionByToken(String token){
       return loginSessionMapper.selectOne(new LoginSession().setToken(token));
    }
    /**
     * 插入数据
     * @param loginSession
     * @return boolean
     */
    public boolean add(LoginSession loginSession) {
        loginSession.setFirstLoginTime(System.currentTimeMillis());
        loginSession.setLoginUpdteTime(System.currentTimeMillis());
        loginSession.setCreateTime(new Date());
        loginSession.setUpdateTime(new Date());
        return loginSessionMapper.insert(loginSession) > 0;
    }
    /**
     * 插入数据
     * @param loginSession
     * @return boolean
     */
    public boolean update(LoginSession loginSession) {
        loginSession.setUpdateTime(new Date());
        return loginSessionMapper.updateByPrimaryKey(loginSession) > 0;
    }
}
