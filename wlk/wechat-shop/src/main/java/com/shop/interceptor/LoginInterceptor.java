package com.shop.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.shop.auth.service.LoginSessionService;
import com.shop.enums.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;

@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {


    @Autowired
    private LoginSessionService loginSessionService;
    /**
     * 预处理回调方法，实现处理器的预处理
     * 返回值：true表示继续流程；false表示流程中断，不会继续调用其他的拦截器或处理器
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println(request.getMethod());
        log.info("=============开始校验token============");
        //业务代码
        String token = request.getHeader("token");
        boolean flag = loginSessionService.checkToken(token);
        //如果失败，则返回错误提示
        if(!flag){
            Map<String,Object> map = new LinkedHashMap<>();
            map.put("code", ErrorCode.AUTH_FAILURE.getCode());
            map.put("message",ErrorCode.AUTH_FAILURE.getDesc());
            outPrintMsg(response,map);
            log.info("=============校验结果：token失效，需重新认证============");
            return false;
        }
        //更新最后一次登录时间
        loginSessionService.updateLoginSession(token);
        log.info("=============校验结果：token校验通过============");
        return true;
    }
    /**
     * 输出提示
     * @param response
     * @param map
     */
    private void outPrintMsg(HttpServletResponse response,Map<String,Object> map){
        response.setContentType("text/json");
        response.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()){
            out.print(JSONObject.toJSON(map));
            out.flush();
            out.close();
        } catch (IOException e) {
            log.error("outPrintMsg error :{}",e);
        }
    }
    /**
     * 后处理回调方法，实现处理器（controller）的后处理，但在渲染视图之前
     * 此时我们可以通过modelAndView对模型数据进行处理或对视图进行处理
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {

    }

    /**
     * 整个请求处理完毕回调方法，即在视图渲染完毕时回调，
     * 如性能监控中我们可以在此记录结束时间并输出消耗时间，
     * 还可以进行一些资源清理，类似于try-catch-finally中的finally，
     * 但仅调用处理器执行链中
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {

    }

}