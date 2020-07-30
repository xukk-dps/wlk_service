package com.shop.product;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.shop.CheckResult;
import com.shop.constant.ProductConstant;
import com.shop.dto.PageResult;
import com.shop.dto.product.ShopProductRequest;
import com.shop.entity.ProductType;
import com.shop.entity.ShopProduct;
import com.shop.product.dao.ProductDao;
import com.shop.redis.RedisUtils;
import com.shop.util.MoneyUtils;
import com.shop.util.ToolUtils;
import com.shop.vo.product.ProductTypeVO;
import com.shop.vo.product.ProductVO;
import com.shop.vo.product.ShopProductVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService extends RedisUtils {


    @Autowired
    private ProductDao productDao;


    public List<ShopProduct> list(String account) {
        return productDao.list(account);
    }


    /**
     * 产品分类导航
     * @return list
     */
    public List<ProductTypeVO> navList(){
        return toList(productDao.typeList());
    }
    private List<ProductTypeVO> toList(List<ProductType> dos){
        List<ProductTypeVO> vos = new ArrayList<>();
        if(CollectionUtils.isEmpty(dos)){
            return vos;
        }
        ProductTypeVO vo;
        for(ProductType productType:dos){
            vo = new  ProductTypeVO();
            vo.setId(productType.getId());
            vo.setBrand_name(productType.getTypeName());
            vo.setImgUrl(productType.getTypeLogo());
            vos.add(vo);
        }
        return vos;
    }
    /**
     * 分页显示
     *
     * @param query
     */
    public PageResult<ProductVO> queryPage(ShopProductRequest query) {
        Example example = handleParam(query);
        Page<ShopProduct> page = PageHelper.startPage(query.getPageNo(),
                query.getPageSize()).doSelectPage(() -> productDao.pageList(example));
        PageResult<ProductVO> pageResult = new PageResult<>();
        pageResult.setPageNum(page.getPageNum());
        pageResult.setPageSize(page.getPageSize());
        pageResult.setTotal(page.getTotal());
        pageResult.setList(convertVOList(page.getResult()));
        return pageResult;
    }
    /**
     * 产品详情
     * @param id
     * @return ShopProductVO
     */
    public ProductVO info(Long id) {
        CheckResult.illegalParameter(id, "id为空");
        ShopProduct shopProduct = productDao.info(id);
        CheckResult.checkEmpty(shopProduct,"未找到相关产品");
        return convertVO(shopProduct);
    }



    /**
     * to vo list
     *
     * @param shopProductList
     * @return volist
     */
    private List<ProductVO> convertVOList(List<ShopProduct> shopProductList) {
        List<ProductVO> shopProductVOS = new ArrayList<>();
        if (CollectionUtils.isEmpty(shopProductList)) {
            return shopProductVOS;
        }
        for (ShopProduct shopProduct : shopProductList) {
            shopProductVOS.add(convertVO(shopProduct));
        }
        return shopProductVOS;
    }

    /**
     * to vo
     *
     * @param shopProduct
     * @return vo
     */
    private ProductVO convertVO(ShopProduct shopProduct) {
        ProductVO shopProductVO = new ProductVO();
        shopProductVO.setId(shopProduct.getId());
        shopProductVO.setProType(shopProduct.getProType());
        shopProductVO.setTitle(shopProduct.getProName());
        shopProductVO.setImgUrl(shopProduct.getProLogo());
        shopProductVO.setCurrent(MoneyUtils.feeBackHandleTOBigDecimal(shopProduct.getProPrice()));
        shopProductVO.setOriginal(MoneyUtils.feeBackHandleTOBigDecimal(shopProduct.getProPrice()*ProductConstant.priceMultiple));
        shopProductVO.setNum(ProductConstant.num);
        shopProductVO.setNums(ProductConstant.nums);
        shopProductVO.setCount(1);
        shopProductVO.setIsSelect(ProductConstant.isSelect);
        return shopProductVO;
    }

    /**
     * Example参数处理
     *
     * @param query
     * @return Example
     */
    private Example handleParam(ShopProductRequest query) {
        Example example = new Example(ShopProduct.class);
        example.setOrderByClause(" id desc ");
        Example.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(query.getProName())) {
            criteria.andLike("proName", ToolUtils.addPercentSign(query.getProName()));
        }
        if (null != query.getProType()) {
            criteria.andEqualTo("proType",query.getProType());
        }
        //默认查询已上架
        criteria.andEqualTo("proStatus",1);
        //默认查询未删除
        criteria.andEqualTo("proDelStatus",0);
        return example;
    }

}
