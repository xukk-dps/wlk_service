package com.shop.product.dao;

import com.shop.entity.ProductType;
import com.shop.entity.ShopProduct;
import com.shop.mapper.ProductTypeMapper;
import com.shop.mapper.ShopProductMapper;
import com.shop.redis.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Component
public class ProductDao extends RedisUtils {

    @Autowired
    private ShopProductMapper productMapper;
    @Autowired
    private ProductTypeMapper productTypeMapper;

    /**
     * 产品分类列表
     * @return list
     */
    public List<ProductType> typeList(){
        return productTypeMapper.selectAll();
    }

    /**
     * list
     * @param account
     * @return UserAccount
     */
    public List<ShopProduct> list(String account) {
        List<ShopProduct> list =  productMapper.select(new ShopProduct());
        return list;
    }
    public List<ShopProduct> pageList(Example example){
        return productMapper.selectByExample(example);
    }

    public ShopProduct info(Long id) {
        return productMapper.selectOne(new ShopProduct().setId(id).setProStatus(1).setProDelStatus(0));
    }
}
