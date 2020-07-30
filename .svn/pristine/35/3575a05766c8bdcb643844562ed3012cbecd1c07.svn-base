package com.shop.order.dao;

import com.shop.annonation.RedisAnno;
import com.shop.dto.product.AddressRequest;
import com.shop.entity.ReceiveAddress;
import com.shop.mapper.ReceiveAddressMapper;
import com.shop.redis.RedisUtils;
import com.shop.util.LoginUserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

@Component
public class ReceiveAddressDao extends RedisUtils {


    @Autowired
    private ReceiveAddressMapper addressMapper;

    /**
     * 列表
     *
     * @param receiveAddress
     * @return list
     */
    public List<ReceiveAddress> list(ReceiveAddress receiveAddress) {
        return addressMapper.select(receiveAddress);
    }

    @Transactional(rollbackFor = Exception.class)
    public void add(ReceiveAddress receiveAddress) {
        receiveAddress.setCreateTime(new Date());
        addressMapper.insert(receiveAddress);
    }
    @Transactional(rollbackFor = Exception.class)
    public void del(ReceiveAddress address) {
        address.setUserId(LoginUserUtils.getUserId());
        addressMapper.delete(address);
    }

    public void updateByPrimaryKey(ReceiveAddress receiveAddress) {
        receiveAddress.setUpdateTime(new Date());
        addressMapper.updateByPrimaryKey(receiveAddress);
    }

    public ReceiveAddress getReceiveAddress(ReceiveAddress receiveAddress) {
        return addressMapper.selectOne(receiveAddress);
    }

    /**
     * 把其他地址设为非默认
     *
     * @param receiveAddress
     */
    public void setNotDefault(ReceiveAddress receiveAddress) {
      addressMapper.setNotDefault(receiveAddress);
    }
}
