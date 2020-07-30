package com.shop.order.service;

import com.shop.CheckResult;
import com.shop.annonation.RedisAnno;
import com.shop.dto.product.AddressRequest;
import com.shop.dto.product.ReceiveAddressRequest;
import com.shop.entity.ReceiveAddress;
import com.shop.entity.ShopOrder;
import com.shop.order.dao.OrderDao;
import com.shop.order.dao.ReceiveAddressDao;
import com.shop.redis.RedisUtils;
import com.shop.util.LoginUserUtils;
import com.shop.vo.order.ReceiveAddressVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReceiveAddressService extends RedisUtils {

    @Autowired
    private ReceiveAddressDao receiveAddressDao;
    @Autowired
    private OrderDao orderDao;
    /**
     * 列表
     *
     * @param userId
     * @return list
     */
    public List<ReceiveAddressVO> list(Long userId) {
        CheckResult.illegalParameter(userId, "用户id不能为空");
        List<ReceiveAddress> receiveAddresses = receiveAddressDao.list(new ReceiveAddress().setUserId(userId));
        return convertVOList(receiveAddresses);
    }

    /**
     * 新增收获地址
     * @param request
     */
    @Transactional(rollbackFor = Exception.class)
    public void add(ReceiveAddressRequest request) {
        ReceiveAddress address = new ReceiveAddress();
        BeanUtils.copyProperties(request,address);
        address.setUserId(LoginUserUtils.getUserId());
        address.setDefaultFlag(0);
        receiveAddressDao.add(address);
    }
    @Transactional(rollbackFor = Exception.class)
    public void del(Integer id) {
        receiveAddressDao.del(new ReceiveAddress().setId(id));
    }
    /**
     * 默认收获地址设置
     *
     * @param request
     */
    @Transactional(rollbackFor = Exception.class)
    public void defaultSet(AddressRequest request) {
        ReceiveAddress query = new ReceiveAddress().setUserId(request.getUserId()).setId(request.getId());
        ReceiveAddress receiveAddress = receiveAddressDao.getReceiveAddress(query);
        CheckResult.checkEmpty(receiveAddress, "数据异常：对象不存在");
        //设为默认值
        receiveAddress.setDefaultFlag(1);
        receiveAddressDao.updateByPrimaryKey(receiveAddress);
        //把其他的改为非默认
        receiveAddressDao.setNotDefault(query.setDefaultFlag(0));
        //顺便把订单中的地址也更换掉
        if(null == request.getOrderId()){
            return;
        }
        ShopOrder shopOrder =  orderDao.getShopOrder(new ShopOrder().setId(request.getOrderId()));
        if(null == shopOrder){
            return;
        }
        shopOrder.setReceiveAddress(receiveAddress.getReceiveAddress());
        orderDao.updateShopOrder(shopOrder);
    }

    /**
     * to vo list
     *
     * @param orders
     * @return list
     */
    private List<ReceiveAddressVO> convertVOList(List<ReceiveAddress> orders) {
        List<ReceiveAddressVO> vos = new ArrayList<>();
        if (CollectionUtils.isEmpty(orders)) {
            return vos;
        }
        for (ReceiveAddress address : orders) {
            vos.add(convertVO(address));
        }
        return vos;
    }

    /**
     * to vo
     *
     * @param receiveAddress
     * @return vo
     */
    private ReceiveAddressVO convertVO(ReceiveAddress receiveAddress) {
        ReceiveAddressVO vo = new ReceiveAddressVO();
        BeanUtils.copyProperties(receiveAddress, vo);
        return vo;
    }
}
