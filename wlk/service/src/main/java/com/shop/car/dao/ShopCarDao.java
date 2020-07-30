package com.shop.car.dao;

import com.shop.entity.ShopCar;
import com.shop.mapper.ShopCarMapper;
import com.shop.redis.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Component
public class ShopCarDao extends RedisUtils {

    @Autowired
    private ShopCarMapper shopCarMapper;

    /**
     * 列表
     *
     * @param shopCar
     * @return list
     */
    public List<ShopCar> list(ShopCar shopCar) {
        return shopCarMapper.select(shopCar);
    }

    /**
     * 加入购物车
     *
     * @param shopCar
     */
    @Transactional(rollbackFor = Exception.class)
    public void add(ShopCar shopCar) {
        shopCar.setProNum(1);
        shopCar.setCarStatus(0);
        shopCar.setCreateTime(new Date());
        shopCar.setUpdateTime(new Date());
        shopCarMapper.insert(shopCar);
    }

    /**
     * 查询购物车数量
     * @param shopCar
     * @return int
     */
    public ShopCar getShopCar(ShopCar shopCar){
        shopCar.setCarStatus(0);
        return shopCarMapper.selectOne(shopCar);
    }
    /**
     * 更新购物车
     *
     * @param shopCar
     */
    @Transactional(rollbackFor = Exception.class)
    public void update(ShopCar shopCar) {
        shopCar.setUpdateTime(new Date());
        shopCarMapper.updateByPrimaryKey(shopCar);
    }

    /**
     * 删除购物车
     *
     * @param shopCar
     */
    @Transactional(rollbackFor = Exception.class)
    public void del(ShopCar shopCar) {
        if (null == shopCar || null == shopCar.getUserId()) {
            return;
        }
        shopCarMapper.delete(shopCar);
    }
}
