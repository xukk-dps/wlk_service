package com.shop.order.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.shop.CheckResult;
import com.shop.car.dao.ShopCarDao;
import com.shop.constant.ProductConstant;
import com.shop.dto.PageResult;
import com.shop.dto.order.DelOrderRequest;
import com.shop.dto.order.OrderItemRequest;
import com.shop.dto.order.OrderRequest;
import com.shop.dto.order.QueryOrderRequest;
import com.shop.entity.ShopCar;
import com.shop.entity.ShopOrder;
import com.shop.entity.ShopOrderItem;
import com.shop.entity.ShopTransaction;
import com.shop.enums.ErrorCode;
import com.shop.enums.OrderStatus;
import com.shop.order.dao.OrderDao;
import com.shop.redis.RedisUtils;
import com.shop.util.*;
import com.shop.util.pay.Configure;
import com.shop.util.rest.RestTemplateUtils;
import com.shop.validtion.ValidationUtil;
import com.shop.vo.order.OrderShowVO;
import com.shop.vo.order.ShopOrderVO;
import com.shop.vo.product.ProductVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderService extends RedisUtils {

    @Autowired
    private OrderDao orderDao;
    @Autowired
    private ShopCarDao shopCarDao;

    /**
     * 列表
     *
     * @param query
     * @return list
     */
    public PageResult<OrderShowVO> list(QueryOrderRequest query) {
        Example example = new Example(ShopOrder.class);
        example.setOrderByClause(" id desc ");
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("orderStatus", query.getStatus());
        PageHelper.startPage(query.getPageNo(), query.getPageSize());
        Page<ShopOrder> page = (Page<ShopOrder>) orderDao.pages(example);
        PageResult<OrderShowVO> pageResult = new PageResult<>();
        pageResult.setPageNum(page.getPageNum());
        pageResult.setPageSize(page.getPageSize());
        pageResult.setTotal(page.getTotal());
        pageResult.setList(convertVOList(page.getResult()));
        return pageResult;
    }

    /**
     * 订单详情
     *
     * @param id
     * @return OrderShowVO
     */
    public OrderShowVO info(Long id) {
        CheckResult.illegalParameter(id, "订单id不能为空");
        ShopOrder order = orderDao.getShopOrder(new ShopOrder().setId(id));
        List<ShopOrderItem> orderItems = orderDao.getShopOrderItem(order.getOrderNo());
        return toOrderShowVO(order, orderItems);
    }
    /**
     * 订单详情
     *
     * @param id
     * @return OrderShowVO
     */
    public void success(Long id) {
        CheckResult.illegalParameter(id, "订单id不能为空");
        ShopOrder order = orderDao.getShopOrder(new ShopOrder().setId(id));
        if(OrderStatus.SUCCESS.getCode().equals(order.getOrderStatus())){
            CheckResult.throwException(ErrorCode.ORDER_END, "订单已完成");
        }
        order.setOrderStatus(OrderStatus.SUCCESS.getCode());
        order.setUpdateTime(new Date());
        order.setPayMethod(1);
        order.setTimeExpire(new Date());
        orderDao.updateShopOrder(order);
    }
    /**
     * to vo list
     *
     * @param orders
     * @return list
     */
    private List<OrderShowVO> convertVOList(List<ShopOrder> orders) {
        List<OrderShowVO> vos = new ArrayList<>();
        if (CollectionUtils.isEmpty(orders)) {
            return vos;
        }
        for (ShopOrder shopCar : orders) {
            vos.add(info(shopCar.getId()));
        }
        return vos;
    }

    /**
     * to vo
     *
     * @param shopCar
     * @return vo
     */
    private ShopOrderVO convertVO(ShopOrder shopCar) {
        ShopOrderVO vo = new ShopOrderVO();
        BeanUtils.copyProperties(shopCar, vo);
        return vo;
    }

    /**
     * 下单
     *
     * @param request
     */
    @Transactional(rollbackFor = Exception.class)
    public OrderShowVO add(OrderRequest request) {
        //处理订单
        ShopOrder shopOrder = convertDO(request);
        //处理订单子项
        List<ShopOrderItem> orderItems = toShopOrderItemList(shopOrder, request.getItemRequestList());
        //订单子项入库
        orderDao.batchInsertShopOrderItem(orderItems);
        //订单入库
        orderDao.add(shopOrder);
        //添加交易记录
        orderDao.addTransaction(buildShopTransaction(shopOrder));
        //下单成功后把订单中的商品在购物车中删除
        clearShopCarProduct(shopOrder.getUserId(), orderItems);
        return toOrderShowVO(shopOrder, orderItems);
    }

    /**
     * 订单预览
     *
     * @return OrderShowVO
     */
    private OrderShowVO toOrderShowVO(ShopOrder shopOrder, List<ShopOrderItem> orderItems) {
        OrderShowVO showVO = new OrderShowVO();
        BeanUtils.copyProperties(shopOrder, showVO);
        //应付金额
        showVO.setPayable(MoneyUtils.feeBackHandleTOBigDecimal(shopOrder.getOrderTotal()));
        //订单总价
        showVO.setProSalePrice(MoneyUtils.feeBackHandleTOBigDecimal(shopOrder.getOrderTotal()));
        //订单门市价
        showVO.setProPrice(MoneyUtils.feeBackHandleTOBigDecimal(shopOrder.getOrderTotal() * ProductConstant.priceMultiple));
        showVO.setProductVOS(toProductVOList(orderItems));
        showVO.setTimeStart(HandleDateUtil.dataToStr(shopOrder.getTimeStart()));
        if (null != shopOrder.getTimeExpire()) {
            showVO.setTimeExpire(HandleDateUtil.dataToStr(shopOrder.getTimeExpire()));
        } else {
            showVO.setTimeExpire("");
        }
        //待付款订单实付金额为0
        if(OrderStatus.WAIT_PAY.getCode().equals(shopOrder.getOrderStatus())){
            showVO.setProSalePrice(BigDecimal.ZERO);
        }
        showVO.setStatus(OrderStatus.getMessage(shopOrder.getOrderStatus()));
        return showVO;
    }

    private List<ProductVO> toProductVOList(List<ShopOrderItem> orderItems) {
        List<ProductVO> voList = new ArrayList<>();
        if (CollectionUtils.isEmpty(orderItems)) {
            return voList;
        }
        for (ShopOrderItem item : orderItems) {
            voList.add(toProductVO(item));
        }
        return voList;
    }

    private ProductVO toProductVO(ShopOrderItem item) {
        ProductVO vo = new ProductVO();
        vo.setId(item.getProId());
        vo.setCount(item.getProNum());
        vo.setImgUrl(item.getProLogo());
        //实际成交总价
        vo.setCurrent(MoneyUtils.feeBackHandleTOBigDecimal(item.getProSalePrice()));
        vo.setTitle(item.getProName());
        return vo;
    }

    @Transactional(rollbackFor = Exception.class)
    public void clearShopCarProduct(long userId, List<ShopOrderItem> orderItems) {
        ShopCar delShopCar = new ShopCar().setUserId(userId);
        for (ShopOrderItem item : orderItems) {
            delShopCar.setProId(item.getProId());
            shopCarDao.del(delShopCar);
        }
    }

    /**
     * 构建交易记录
     *
     * @param shopOrder
     * @return
     */
    private ShopTransaction buildShopTransaction(ShopOrder shopOrder) {
        ShopTransaction transaction = new ShopTransaction();
        //用户信息
        transaction.setUser(shopOrder.getUserId());
        //默认类型，微信小程序支付
        transaction.setTradeType("JSAPI");
        //商户信息
        transaction.setAppid(Configure.getAppID());
        transaction.setMchId(Configure.getMch_id());
        transaction.setOutTradeNo(shopOrder.getOrderNo());
        //商品信息
        transaction.setProductId(shopOrder.getId());
        transaction.setTotalFee(shopOrder.getOrderTotal());
        transaction.setBody("小店商品信息");
        //系统信息
        transaction.setTransactionNo(shopOrder.getTransactionNo());
        transaction.setNonceStr(OrderNoUtils.nonceStr());
        transaction.setSignType("MD5");
        transaction.setSign("");
        transaction.setSerialNo("");
        transaction.setSpbillCreateIp("localhost");
        transaction.setPayMethod(shopOrder.getPayMethod());
        transaction.setNotifyUrl(Configure.notify_url);
        return transaction;
    }

    /**
     * to do
     *
     * @param request
     * @return do
     */
    private ShopOrder convertDO(OrderRequest request) {
        ShopOrder order = new ShopOrder();
        BeanUtils.copyProperties(request, order);
        order.setOrderNo(OrderNoUtils.orderNo());
        order.setTransactionNo(OrderNoUtils.transactionNo());
        order.setTimeStart(new Date());
        order.setCouponId(0L);
        //流水号默认空，支付回调后更新
        order.setSerialNo("");
        //默认待付款
        order.setOrderStatus(OrderStatus.WAIT_PAY.getCode());
        //默认微信支付
        order.setPayMethod(1);
        return order;
    }

    private List<ShopOrderItem> toShopOrderItemList(ShopOrder shopOrder, List<OrderItemRequest> itemRequests) {
        List<ShopOrderItem> items = new ArrayList<>();
        if (CollectionUtils.isEmpty(itemRequests)) {
            return items;
        }
        long total = 0;
        ShopOrderItem item;
        for (OrderItemRequest itemRequest : itemRequests) {
            ValidationUtil.validate(itemRequest);
            item = toShopOrderItem(itemRequest);
            total += item.getProSalePrice();
            item.setOrderNo(shopOrder.getOrderNo());
            items.add(item);
        }
        //设置订单总金额
        shopOrder.setOrderTotal(total);
        return items;
    }

    /**
     * 组装订单内容
     *
     * @param request
     * @return ShopOrderItem
     */
    private ShopOrderItem toShopOrderItem(OrderItemRequest request) {
        ShopOrderItem shopOrderItem = new ShopOrderItem();
        shopOrderItem.setCouponId(0L);
        shopOrderItem.setProNum(request.getCount());
        shopOrderItem.setProId(request.getId());
        shopOrderItem.setProAttribute("");
        shopOrderItem.setProLogo(request.getImgUrl());
        shopOrderItem.setProName(request.getTitle());
        long price = MoneyUtils.feeHandleTOLong(request.getCurrent());
        shopOrderItem.setProPrice(price);
        shopOrderItem.setProSalePrice(price * ToolUtils.getInt(request.getCount()));
        shopOrderItem.setRemark(request.getRemark());
        return shopOrderItem;
    }

    /**
     * 删除订单
     *
     * @param request
     */
    public void del(DelOrderRequest request) {
        ShopOrder shopOrder = new ShopOrder().setUserId(request.getUserId());
        //删除
        if (!CollectionUtils.isEmpty(request.getId())) {
            for (Long id : request.getId()) {
                shopOrder.setId(id);
                orderDao.del(shopOrder);
            }
        }
        //删除所有
        orderDao.del(shopOrder);
    }
}
