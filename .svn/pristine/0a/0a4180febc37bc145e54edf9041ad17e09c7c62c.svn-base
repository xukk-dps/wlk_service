package com.shop.biz.car;

import com.shop.HttpResult;
import com.shop.biz.BaseController;
import com.shop.car.service.ShopCarService;
import com.shop.dto.car.DelCarRequest;
import com.shop.dto.car.ShopCarRequest;
import com.shop.enums.ErrorCode;
import com.shop.enums.ExceptionCode;
import com.shop.exception.ServiceException;
import com.shop.util.LoginUserUtils;
import com.shop.validtion.ValidationUtil;
import com.shop.vo.car.CarVO;
import com.shop.vo.car.ShopCarVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@ResponseBody
@RequestMapping("/car")
public class ShopCarController extends BaseController{

    @Autowired
    private ShopCarService shopCarService;

    /**
     * 购物车列表
     */
    @GetMapping("/list")
    public HttpResult<List<CarVO>> list() {
        long st = System.currentTimeMillis();
        HttpResult<List<CarVO>> result;
        try {
            log.info("car list request ,{}");
            result = HttpResult.ok(shopCarService.list(LoginUserUtils.getUserId()));
        } catch (ServiceException e) {
            ExceptionCode errorCode = e.getErrorCode();
            String desc = e.getMessage();
            result = HttpResult.build(errorCode, desc);
            log.error("car list list occurred ServiceException.errorCode:{},errorDesc:{}", e.getErrorCode(), desc);
        } catch (Exception e) {
            log.error("car list occurred Exception.", e);
            result = HttpResult.build(ErrorCode.SYSTEM_ERROR);
        }
        log.info("car list.resultCode:{} resultMessage:{} use time:{}", result.getCode(), result.getMessage(), (System.currentTimeMillis() - st) + " ms");
        return result;
    }

    /**
     * 加入购物车
     * @param request
     */
    @PostMapping("/add")
    public HttpResult add(@RequestBody ShopCarRequest request) {
        long st = System.currentTimeMillis();
        HttpResult result;
        try {
            log.info("car add request ,{}", request);
            ValidationUtil.validate(request);
            request.setSource(getResource());
            request.setUserId(LoginUserUtils.getUserId());
            shopCarService.add(request);
            result = HttpResult.ok();
        } catch (ServiceException e) {
            ExceptionCode errorCode = e.getErrorCode();
            String desc = e.getMessage();
            result = HttpResult.build(errorCode, desc);
            log.error("car add list occurred ServiceException.errorCode:{},errorDesc:{}", e.getErrorCode(), desc);
        } catch (Exception e) {
            log.error("car add occurred Exception.", e);
            result = HttpResult.build(ErrorCode.SYSTEM_ERROR);
        }
        log.info("car add.resultCode:{} resultMessage:{} use time:{}", result.getCode(), result.getMessage(), (System.currentTimeMillis() - st) + " ms");
        return result;
    }

    /**
     * 清空购物车/删除购物车数据
     * @param request
     */
    @PostMapping("/del")
    public HttpResult del(@RequestBody DelCarRequest request) {
        long st = System.currentTimeMillis();
        HttpResult result;
        try {
            log.info("car del request ,{}", request);
            ValidationUtil.validate(request);
            request.setUserId(LoginUserUtils.getUserId());
            shopCarService.del(request);
            result = HttpResult.ok();
        } catch (ServiceException e) {
            ExceptionCode errorCode = e.getErrorCode();
            String desc = e.getMessage();
            result = HttpResult.build(errorCode, desc);
            log.error("car del list occurred ServiceException.errorCode:{},errorDesc:{}", e.getErrorCode(), desc);
        } catch (Exception e) {
            log.error("car del occurred Exception.", e);
            result = HttpResult.build(ErrorCode.SYSTEM_ERROR);
        }
        log.info("car del.resultCode:{} resultMessage:{} use time:{}", result.getCode(), result.getMessage(), (System.currentTimeMillis() - st) + " ms");
        return result;
    }
}
