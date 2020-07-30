package com.shop.biz.product;

import com.shop.HttpResult;
import com.shop.dto.product.AddressRequest;
import com.shop.dto.product.ReceiveAddressRequest;
import com.shop.enums.ErrorCode;
import com.shop.enums.ExceptionCode;
import com.shop.exception.ServiceException;
import com.shop.order.service.ReceiveAddressService;
import com.shop.util.LoginUserUtils;
import com.shop.validtion.ValidationUtil;
import com.shop.vo.order.ReceiveAddressVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@ResponseBody
@RequestMapping("/address")
public class ReceiveAddressController {

    @Autowired
    private ReceiveAddressService addressService;

    @GetMapping("/list")
    public HttpResult<List<ReceiveAddressVO>> list() {
        long st = System.currentTimeMillis();
        HttpResult<List<ReceiveAddressVO>> result;
        try {
            log.info("address list request ");
            result = HttpResult.ok(addressService.list(LoginUserUtils.getUserId()));
        } catch (ServiceException e) {
            ExceptionCode errorCode = e.getErrorCode();
            String desc = e.getMessage();
            result = HttpResult.build(errorCode, desc);
            log.error("address list occurred ServiceException.errorCode:{},errorDesc:{}", e.getErrorCode(), desc);
        } catch (Exception e) {
            log.error("address list occurred Exception.", e);
            result = HttpResult.build(ErrorCode.SYSTEM_ERROR);
        }
        log.info("address list.resultCode:{} resultMessage:{} use time:{}", result.getCode(), result.getMessage(), (System.currentTimeMillis() - st) + " ms");
        return result;
    }

    /**
     * 默认收获地址设置
     *
     * @param request
     */
    @PostMapping("/defaultSet")
    public HttpResult defaultSet(@RequestBody AddressRequest request) {
        long st = System.currentTimeMillis();
        HttpResult result;
        try {
            log.info("defaultSet list request ,{}", request);
            ValidationUtil.validate(request);
            request.setUserId(LoginUserUtils.getUserId());
            addressService.defaultSet(request);
            result = HttpResult.ok();
        } catch (ServiceException e) {
            ExceptionCode errorCode = e.getErrorCode();
            String desc = e.getMessage();
            result = HttpResult.build(errorCode, desc);
            log.error("defaultSet list occurred ServiceException.errorCode:{},errorDesc:{}", e.getErrorCode(), desc);
        } catch (Exception e) {
            log.error("defaultSet list occurred Exception.", e);
            result = HttpResult.build(ErrorCode.SYSTEM_ERROR);
        }
        log.info("defaultSet list.resultCode:{} resultMessage:{} use time:{}", result.getCode(), result.getMessage(), (System.currentTimeMillis() - st) + " ms");
        return result;
    }

    /**
     * 新增收获地址
     *
     * @param request
     */
    @PostMapping("/add")
    public HttpResult add(@RequestBody ReceiveAddressRequest request) {
        long st = System.currentTimeMillis();
        HttpResult result;
        try {
            log.info("address add list request ,{}", request);
            ValidationUtil.validate(request);
            request.setUserId(LoginUserUtils.getUserId());
            addressService.add(request);
            result = HttpResult.ok();
        } catch (ServiceException e) {
            ExceptionCode errorCode = e.getErrorCode();
            String desc = e.getMessage();
            result = HttpResult.build(errorCode, desc);
            log.error("address add list occurred ServiceException.errorCode:{},errorDesc:{}", e.getErrorCode(), desc);
        } catch (Exception e) {
            log.error("defaultSet list occurred Exception.", e);
            result = HttpResult.build(ErrorCode.SYSTEM_ERROR);
        }
        log.info("defaultSet list.resultCode:{} resultMessage:{} use time:{}", result.getCode(), result.getMessage(), (System.currentTimeMillis() - st) + " ms");
        return result;
    }

    /**
     * 新增收获地址
     *
     * @param id
     */
    @PostMapping("/del/{id}")
    public HttpResult del(@PathVariable Integer id) {
        long st = System.currentTimeMillis();
        HttpResult result;
        try {
            log.info("address del request ,{}", id);
            addressService.del(id);
            result = HttpResult.ok();
        } catch (ServiceException e) {
            ExceptionCode errorCode = e.getErrorCode();
            String desc = e.getMessage();
            result = HttpResult.build(errorCode, desc);
            log.error("address del occurred ServiceException.errorCode:{},errorDesc:{}", e.getErrorCode(), desc);
        } catch (Exception e) {
            log.error("address del occurred Exception.", e);
            result = HttpResult.build(ErrorCode.SYSTEM_ERROR);
        }
        log.info("address del.resultCode:{} resultMessage:{} use time:{}", result.getCode(), result.getMessage(), (System.currentTimeMillis() - st) + " ms");
        return result;
    }
}
