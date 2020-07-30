package com.shop.car.service;

import com.shop.CheckResult;
import com.shop.car.dao.ShopCarDao;
import com.shop.constant.ProductConstant;
import com.shop.dto.car.DelCarRequest;
import com.shop.dto.car.ShopCarRequest;
import com.shop.entity.ShopCar;
import com.shop.redis.RedisUtils;
import com.shop.util.MoneyUtils;
import com.shop.util.ToolUtils;
import com.shop.vo.car.CarVO;
import com.shop.vo.car.ShopCarVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShopCarService extends RedisUtils {

    @Autowired
    private ShopCarDao shopCarDao;


    /**
     * 购物车列表
     *
     * @param userId
     * @return list
     */
    public List<CarVO> list(Long userId) {
        CheckResult.illegalParameter(userId, "用户标识为空");
        List<ShopCar> shopUserList = shopCarDao.list(new ShopCar().setUserId(userId).setCarStatus(0));
        return convertVOList(shopUserList);
    }

    /**
     * to vo list
     * @param shopUserList
     * @return list
     */
    private List<CarVO> convertVOList(List<ShopCar> shopUserList){
        List<CarVO> shopCarVOS = new ArrayList<>();
        if(CollectionUtils.isEmpty(shopUserList)){
            return  shopCarVOS;
        }
        for(ShopCar shopCar:shopUserList){
            shopCarVOS.add(convertVO(shopCar));
        }
        return shopCarVOS;
    }

    /**
     * to vo
     * @param shopCar
     * @return vo
     */
    private CarVO convertVO(ShopCar shopCar){
        CarVO shopCarVO = new CarVO();
        shopCarVO.setId(shopCar.getProId());
        shopCarVO.setCount(shopCar.getProNum());
        shopCarVO.setTitle(shopCar.getProName());
        shopCarVO.setImgUrl(shopCar.getProLogo());
        shopCarVO.setNum(ProductConstant.num);
        shopCarVO.setNums(ProductConstant.nums);
        shopCarVO.setIsSelect(ProductConstant.isSelect);
        shopCarVO.setCurrent(MoneyUtils.feeBackHandleTOBigDecimal(shopCar.getProPrice()));
        shopCarVO.setOriginal(MoneyUtils.feeBackHandleTOBigDecimal(shopCar.getProPrice()*ProductConstant.priceMultiple));
        return shopCarVO;
    }
    /**
     * 加入购物车
     *
     * @param request
     */
    public void add(ShopCarRequest request) {
        //如果已经加入购物车，则直接修改数量
        ShopCar shopCar = shopCarDao.getShopCar(new ShopCar().setProId(request.getProId()).setUserId(request.getUserId()));
        if(shopCar != null){
            shopCar.setProNum(ToolUtils.integerAdd(shopCar.getProNum(),1));
            shopCarDao.update(shopCar);
            return;
        }
        shopCarDao.add(convertDO(request));
    }

    /**
     * to do
     *
     * @param request
     * @return do
     */
    private ShopCar convertDO(ShopCarRequest request) {
        ShopCar shopCar = new ShopCar();
        BeanUtils.copyProperties(request, shopCar);
        //价格转为分入库
        shopCar.setProPrice(MoneyUtils.feeHandleTOLong(request.getProPrice()));
        return shopCar;
    }
    /**
     * 清空购物车
     *
     * @param request
     */
    public void del(DelCarRequest request) {
        ShopCar shopCar = new ShopCar().setUserId(request.getUserId());
        //删除
        if(!CollectionUtils.isEmpty(request.getProIds())){
            ShopCar result;
            for(Long id:request.getProIds()){
                shopCar.setProId(id);
                result = shopCarDao.getShopCar(shopCar);
                if(null == result){
                    return;
                }
                //1 查询数量，如果数量为大于1，数量-1
                if(null != result.getProNum() && result.getProNum() > 1){
                    result.setProNum(ToolUtils.subtraction(result.getProNum(),1));
                    shopCarDao.update(result);
                    continue;
                }
                //2 则删除数据
                shopCarDao.del(shopCar);
            }
            return;
        }
        //清空用户的购物车
        shopCarDao.del(shopCar);
    }
}
