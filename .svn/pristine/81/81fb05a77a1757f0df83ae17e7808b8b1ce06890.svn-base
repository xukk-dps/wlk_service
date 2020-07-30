package com.shop.aspect;


import com.shop.annonation.RedisAnno;
import com.shop.redis.RedisUtils;
import com.shop.util.AnnoParse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * redis切面
 * @author xkk
 * @date 2020/04/06
 */

@Slf4j
@Aspect
@Component
public class RedisAnnoAspect extends RedisUtils {

    @Around("@annotation(ca)")
    public Object cache(ProceedingJoinPoint pjp, RedisAnno ca) throws Throwable {
        Map<String, String> param = getAnnonationParams(pjp);
        String keyValue = param.get("key");
        String prefix = param.get("prefix");
        String expireTime = param.get("expireTime");;
        long et = 0;
        if(StringUtils.isNotBlank(expireTime)){
            et = Long.parseLong(expireTime);
        }
        Object obj = getT(prefix+keyValue);
        if (obj != null) {
            log.info("=======从缓存中获取数据=======");
            setT(prefix+keyValue, obj,et);
            return obj;
        }
        obj = pjp.proceed();
        if (obj != null) {
            setT(prefix+keyValue, obj,et);
        }
        log.info("=======从数据库中获取数据=======");
        return obj;
    }

    /**
     * 获取注解参数
     *
     * @param joinPoint
     * @return map
     */
    private Map<String, String> getAnnonationParams(JoinPoint joinPoint) {
        Map<String, String> param = new HashMap<>();
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = null;
        try {
            targetClass = Class.forName(targetName);
            Method[] methods = targetClass.getMethods();
            String key = "";
            String prefix = "";
            String expireTime = "";
            for (Method method : methods) {
                if (method.getName().equals(methodName)) {
                    Class[] clazzs = method.getParameterTypes();
                    if (clazzs.length == arguments.length) {
                        key = method.getAnnotation(RedisAnno.class).key();
                        prefix = method.getAnnotation(RedisAnno.class).prefix();
                        expireTime = method.getAnnotation(RedisAnno.class).expireTime();

                        break;
                    }
                }
            }
            param.put("key", key);
            param.put("prefix", prefix);
            param.put("expireTime", expireTime);
            return param;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return new HashMap<>();
        }
    }

}
