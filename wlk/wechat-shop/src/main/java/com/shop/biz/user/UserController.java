package com.shop.biz.user;

import com.shop.HttpResult;
import com.shop.dto.user.ShopUserRequest;
import com.shop.enums.ErrorCode;
import com.shop.enums.ExceptionCode;
import com.shop.exception.ServiceException;
import com.shop.user.service.UserService;
import com.shop.validtion.ValidationUtil;
import com.shop.vo.ShopUserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@ResponseBody
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/info")
    public HttpResult<ShopUserVO> info(@RequestBody ShopUserRequest shopUserRequest) {
        long st = System.currentTimeMillis();
        HttpResult<ShopUserVO> result;
        try {
            log.info("info request ,{}", shopUserRequest);
            ValidationUtil.validate(shopUserRequest);
            result = HttpResult.ok(userService.get(shopUserRequest));
        } catch (ServiceException e) {
            ExceptionCode errorCode = e.getErrorCode();
            String desc = e.getMessage();
            result = HttpResult.build(errorCode, desc);
            log.error("info occurred ServiceException.errorCode:{},errorDesc:{}", e.getErrorCode(), desc);
        } catch (Exception e) {
            log.error("info occurred Exception.", e);
            result = HttpResult.build(ErrorCode.SYSTEM_ERROR);
        }
        log.info("info.resultCode:{} resultMessage:{}", result.getCode(), result.getMessage());
        log.info("info.use time:{}", (System.currentTimeMillis() - st) + " ms");
        return result;
    }
}
