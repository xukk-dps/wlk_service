package com.shop.biz.order;

import com.shop.HttpResult;
import com.shop.biz.BaseController;
import com.shop.dto.PageResult;
import com.shop.dto.order.DelOrderRequest;
import com.shop.dto.order.OrderRequest;
import com.shop.dto.order.QueryOrderRequest;
import com.shop.enums.ErrorCode;
import com.shop.enums.ExceptionCode;
import com.shop.exception.ServiceException;
import com.shop.order.service.OrderService;
import com.shop.util.LoginUserUtils;
import com.shop.validtion.ValidationUtil;
import com.shop.vo.order.OrderShowVO;
import com.shop.vo.order.ShopOrderVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@ResponseBody
@RequestMapping("/order")
public class OrderController extends BaseController {

    @Autowired
    private OrderService orderService;

    /**
     * 订单列表
     *
     * @param request
     */
    @PostMapping("/list")
    public HttpResult<PageResult<OrderShowVO>> list(@RequestBody QueryOrderRequest request) {
        long st = System.currentTimeMillis();
        HttpResult<PageResult<OrderShowVO>> result;
        try {
            log.info("order list request ,{}", request);
            result = HttpResult.ok(orderService.list(request));
        } catch (ServiceException e) {
            ExceptionCode errorCode = e.getErrorCode();
            String desc = e.getMessage();
            result = HttpResult.build(errorCode, desc);
            log.error("order list list occurred ServiceException.errorCode:{},errorDesc:{}", e.getErrorCode(), desc);
        } catch (Exception e) {
            log.error("order list occurred Exception.", e);
            result = HttpResult.build(ErrorCode.SYSTEM_ERROR);
        }
        log.info("order list.resultCode:{} resultMessage:{} use time:{}", result.getCode(), result.getMessage(), (System.currentTimeMillis() - st) + " ms");
        return result;
    }

    /**
     * 订单信息
     *
     * @param id
     */
    @GetMapping("/info/{id}")
    public HttpResult<OrderShowVO> info(@PathVariable("id") Long id) {
        long st = System.currentTimeMillis();
        HttpResult<OrderShowVO> result;
        try {
            log.info("order info request ,{}", id);
            result = HttpResult.ok(orderService.info(id));
        } catch (ServiceException e) {
            ExceptionCode errorCode = e.getErrorCode();
            String desc = e.getMessage();
            result = HttpResult.build(errorCode, desc);
            log.error("order info list occurred ServiceException.errorCode:{},errorDesc:{}", e.getErrorCode(), desc);
        } catch (Exception e) {
            log.error("order info occurred Exception.", e);
            result = HttpResult.build(ErrorCode.SYSTEM_ERROR);
        }
        log.info("order info.resultCode:{} resultMessage:{} use time:{}", result.getCode(), result.getMessage(), (System.currentTimeMillis() - st) + " ms");
        return result;
    }
    /**
     * 完成订单
     *
     * @param id
     */
    @PostMapping("/success/{id}")
    public HttpResult success(@PathVariable("id") Long id) {
        long st = System.currentTimeMillis();
        HttpResult result;
        try {
            log.info("order success request ,{}", id);
            orderService.success(id);
            result = HttpResult.ok();
        } catch (ServiceException e) {
            ExceptionCode errorCode = e.getErrorCode();
            String desc = e.getMessage();
            result = HttpResult.build(errorCode, desc);
            log.error("order success list occurred ServiceException.errorCode:{},errorDesc:{}", e.getErrorCode(), desc);
        } catch (Exception e) {
            log.error("success info occurred Exception.", e);
            result = HttpResult.build(ErrorCode.SYSTEM_ERROR);
        }
        log.info("order success.resultCode:{} resultMessage:{} use time:{}", result.getCode(), result.getMessage(), (System.currentTimeMillis() - st) + " ms");
        return result;
    }
    /**
     * 下单
     *
     * @param request
     */
    @PostMapping("/add")
    public HttpResult<OrderShowVO> add(@RequestBody OrderRequest request) {
        long st = System.currentTimeMillis();
        HttpResult<OrderShowVO> result;
        try {
            log.info("order add request ,{}", request);
            request.setSource(getResource());
            ValidationUtil.validate(request);
            request.setUserId(LoginUserUtils.getUserId());
            request.setUserName(LoginUserUtils.getUserName());
            result = HttpResult.ok(orderService.add(request));
        } catch (ServiceException e) {
            ExceptionCode errorCode = e.getErrorCode();
            String desc = e.getMessage();
            result = HttpResult.build(errorCode, desc);
            log.error("order add list occurred ServiceException.errorCode:{},errorDesc:{}", e.getErrorCode(), desc);
        } catch (Exception e) {
            log.error("order add occurred Exception.", e);
            result = HttpResult.build(ErrorCode.SYSTEM_ERROR);
        }
        log.info("order add.resultCode:{} resultMessage:{} use time:{}", result.getCode(), result.getMessage(), (System.currentTimeMillis() - st) + " ms");
        return result;
    }

    /**
     * 清空/删除数据
     *
     * @param request
     */
    @PostMapping("/del")
    public HttpResult del(@RequestBody DelOrderRequest request) {
        long st = System.currentTimeMillis();
        HttpResult result;
        try {
            log.info("order del request ,{}", request);
            ValidationUtil.validate(request);
            orderService.del(request);
            result = HttpResult.ok();
        } catch (ServiceException e) {
            ExceptionCode errorCode = e.getErrorCode();
            String desc = e.getMessage();
            result = HttpResult.build(errorCode, desc);
            log.error("order del list occurred ServiceException.errorCode:{},errorDesc:{}", e.getErrorCode(), desc);
        } catch (Exception e) {
            log.error("order del occurred Exception.", e);
            result = HttpResult.build(ErrorCode.SYSTEM_ERROR);
        }
        log.info("order del.resultCode:{} resultMessage:{} use time:{}", result.getCode(), result.getMessage(), (System.currentTimeMillis() - st) + " ms");
        return result;
    }
}
