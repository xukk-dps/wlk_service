package com.shop.auth.service;

import com.alibaba.fastjson.JSONObject;
import com.shop.auth.dao.LoginSessionDao;
import com.shop.dto.auth.ShopUserDTO;
import com.shop.entity.LoginSession;
import com.shop.entity.ShopUser;
import com.shop.util.MD5Utils;
import com.shop.util.enc.AESSecurityEncrypt;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginSessionService {


    @Autowired
    private LoginSessionDao loginSessionDao;

    /**
     * 查询最新一条登录信息
     * @param phone
     * @param source
     * @return LoginSession
     */
    public LoginSession getLoginSessionBySource(String phone,int source){
       return loginSessionDao.getLoginSessionBySource(phone,source);
    }
    /**
     * 校验token
     * @param token
     */
    public boolean checkToken(String token){
        if(StringUtils.isBlank(token)){
            return false;
        }
        //先根据token查询登录数据
        LoginSession loginSession = loginSessionDao.getLoginSessionByToken(token);
        if(null == loginSession){
            return false;
        }
        Long loginUpdteTime = loginSession.getLoginUpdteTime();
        //校验过期时间，获取30天前的时间戳
        long expreTime = null == loginUpdteTime?0:loginUpdteTime+86400000*30L;
        //如果最后一次登录时间+30天  在当前时间之前，则为过期
        if(expreTime < System.currentTimeMillis()){
            return false;
        }
        return true;
    }

    /**
     * 更新token有效时间
     * @param token
     */
    public void updateLoginSession(String token){
        LoginSession loginSession = loginSessionDao.getLoginSessionByToken(token);
        if(null == loginSession){
            return;
        }
        loginSession.setLoginUpdteTime(System.currentTimeMillis());
        loginSessionDao.update(loginSession);
    }
    /**
     * 把同端登录的认证信息无效化
     * 保存认证信息，有效期30天
     * @param shopUser
     */
    public String updateLoginSession(String ip,int source,ShopUser shopUser){
        //查询同端认证信息
        LoginSession loginSession = getLoginSessionBySource(shopUser.getPhone(),source);
        if(null != loginSession){
            loginSession.setLoginUpdteTime(System.currentTimeMillis());
            //把旧认证信息设为无效
            loginSession.setLoginUpdteTime(0L);
            loginSessionDao.update(loginSession);
        }
        //如果没有认证信息，则创建
        LoginSession ls = buildLoginSession(ip,shopUser);
        loginSessionDao.add(ls);
        return ls.getToken();
    }
    /**
     * 构建登录session
     * @param shopUser
     * @return LoginSession
     */
    private LoginSession buildLoginSession(String ip,ShopUser shopUser){
        LoginSession loginSession = new LoginSession();
        BeanUtils.copyProperties(shopUser,loginSession);
        loginSession.setId(null);
        loginSession.setLoginIp(ip);
        loginSession.setUserId(shopUser.getId());
        loginSession.setSource(shopUser.getSource());
        loginSession.setToken(buildToken(shopUser));
        return loginSession;
    }

    /**
     * 构建token
     * 规则：MD5(token_手机号 + 验证码+ openId + t(当前时间戳))
     * @param user 用户信息
     * @return str
     */
    private  String buildToken(ShopUser user){
        ShopUserDTO userDTO = new ShopUserDTO();
        BeanUtils.copyProperties(user,userDTO);
        userDTO.setUserName(user.getNickName());
        return AESSecurityEncrypt.encrypt(JSONObject.toJSONString(userDTO));

    }
}
