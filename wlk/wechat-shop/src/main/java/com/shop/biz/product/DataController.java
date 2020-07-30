package com.shop.biz.product;

import com.shop.HttpResult;
import com.shop.dto.UserAccountRequest;
import com.shop.enums.ErrorCode;
import com.shop.enums.ExceptionCode;
import com.shop.exception.ServiceException;
import com.shop.data.service.impl.DataServiceImpl;
import com.shop.validtion.ValidationUtil;
import com.shop.vo.UserAccountVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
@ResponseBody
public class DataController {

    @Autowired
    private DataServiceImpl dataServiceImpl;

    @PostMapping("/data")
    public HttpResult<UserAccountVO> info(HttpServletRequest request, @RequestBody UserAccountRequest accountRequest) {
        long st = System.currentTimeMillis();
        HttpResult<UserAccountVO> result;
        try {
//            UserAccountRequest accountRequest = new UserAccountRequest();
//            accountRequest.setAccount(request.getParameter("account"));
//            accountRequest.setPassword(request.getParameter("password"));
//            accountRequest.setZtmc(request.getParameter("ztmc"));
//            accountRequest.setTydm(request.getParameter("tydm"));
            accountRequest.setIpAddress(request.getRemoteAddr());
            log.info("data request ,{}",accountRequest);
            ValidationUtil.validate(accountRequest);
            result = HttpResult.ok(dataServiceImpl.get(accountRequest));
        } catch (ServiceException e) {
            ExceptionCode errorCode = e.getErrorCode();
            String desc = e.getMessage();
            result = HttpResult.build(errorCode, desc);
            log.error("data occurred ServiceException.errorCode:{},errorDesc:{}", e.getErrorCode(), desc);
        } catch (Exception e) {
            log.error("data occurred Exception.", e);
            result = HttpResult.build(ErrorCode.SYSTEM_ERROR);
        }
        log.info("data.resultCode:{} resultMessage:{}", result.getCode(),result.getMessage());
        log.info("data.use time:{}",(System.currentTimeMillis()-st)+ " ms");
        return result;
    }
}
