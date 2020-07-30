package com.shop.order.dao;

import com.shop.entity.ShopOrder;
import com.shop.entity.ShopOrderItem;
import com.shop.entity.ShopTransaction;
import com.shop.mapper.ShopOrderItemMapper;
import com.shop.mapper.ShopOrderMapper;
import com.shop.mapper.ShopTransactionMapper;
import com.shop.redis.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

@Component
public class OrderDao extends RedisUtils {

    @Autowired
    private ShopOrderMapper orderMapper;
    @Autowired
    private ShopOrderItemMapper itemMapper;
    @Autowired
    private ShopTransactionMapper transactionMapper;

    /**
     * 订单列表
     * @param shopOrder
     * @return list
     */
    public List<ShopOrder> list(ShopOrder shopOrder) {
        return orderMapper.select(shopOrder);
    }
    /**
     * 订单列表分页
     * @param example
     * @return list
     */
    public List<ShopOrder> pages(Example example) {
        return orderMapper.selectByExample(example);
    }

    public ShopOrder getShopOrder(ShopOrder query){
        return orderMapper.selectOne(query);
    }
    public List<ShopOrderItem> getShopOrderItem(String orderNo){
        return itemMapper.select(new ShopOrderItem().setOrderNo(orderNo));
    }
    /**
     * 订单入库
     *
     * @param shopOrder
     */
    @Transactional(rollbackFor = Exception.class)
    public void add(ShopOrder shopOrder) {
        shopOrder.setCreateTime(new Date());
        shopOrder.setUpdateTime(new Date());
        orderMapper.insert(shopOrder);
    }
    @Transactional(rollbackFor = Exception.class)
    public void batchInsertShopOrderItem(List<ShopOrderItem> items){
        if(CollectionUtils.isEmpty(items)){
            return;
        }
        for(ShopOrderItem item:items){
            addShopOrderItem(item);
        }
    }
    /**
     * 订单子项入库
     *
     * @param orderItem
     */
    @Transactional(rollbackFor = Exception.class)
    public void addShopOrderItem(ShopOrderItem orderItem) {
        orderItem.setCreateTime(new Date());
        orderItem.setUpdateTime(new Date());
        itemMapper.insert(orderItem);
    }
    /**
     * 删除
     *
     * @param shopOrder
     */
    @Transactional(rollbackFor = Exception.class)
    public void del(ShopOrder shopOrder) {
        orderMapper.delete(shopOrder);
    }


    /**
     * 添加交易记录
     * @param transaction
     */
    public void addTransaction(ShopTransaction transaction){
        //初始状态为0 1:支付成功，2:支付失败
        transaction.setTransactionStatus(0);
        transaction.setTimeStart(new Date());
        transactionMapper.insert(transaction);
    }
    @Transactional(rollbackFor = Exception.class)
    public void updateShopOrder(ShopOrder shopOrder){
        orderMapper.updateByPrimaryKey(shopOrder);
    }
}
