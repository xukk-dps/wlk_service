package com.shop.biz;

import com.shop.CheckResult;
import com.shop.dto.HeaderEntity;
import com.shop.enums.ErrorCode;
import com.shop.enums.Source;
import com.shop.util.HttpServletUtils;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;

public class BaseController {


    /**
     * 头部信息
     */
    public HeaderEntity header() {
        return new HeaderEntity()
                .setSource(HttpServletUtils.getRequestHeader("source"))
                .setToken(HttpServletUtils.getRequestHeader("token"));
    }
    public String getIp(){
        return HttpServletUtils.getRequestIp();
    }

    /**
     * 获取来源
     * @return int
     */
    public int getResource(){
        String sourceStr = HttpServletUtils.getRequestHeader("source");
        CheckResult.illegalParameter(sourceStr, "来源为空");
        int source = StringUtils.isBlank(sourceStr)?0:Integer.parseInt(sourceStr);
        if(!Source.isContains(source)){
            CheckResult.throwException(ErrorCode.DATA_NOT_EXIST, "未知来源");
        }
        return source;
    }
    public String getHeader(String name){
        return HttpServletUtils.getRequestHeader(name);
    }
    public String getParam(String name){
        return HttpServletUtils.getRequestParam(name);
    }
}
