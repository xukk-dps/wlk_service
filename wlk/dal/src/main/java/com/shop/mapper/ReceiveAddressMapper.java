package com.shop.mapper;

import com.shop.entity.ReceiveAddress;
import tk.mybatis.mapper.common.Mapper;

public interface ReceiveAddressMapper extends Mapper<ReceiveAddress> {

    /**
     * 把除本身其他地址设为非默认
     * @param receiveAddress
     */
    public void setNotDefault(ReceiveAddress receiveAddress);
}