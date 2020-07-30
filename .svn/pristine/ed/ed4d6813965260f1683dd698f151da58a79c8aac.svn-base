package com.shop.annonation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RedisAnno {

    /**
     * 缓存ID
     */
     String key() default "";
    /**
     * 缓存标识前缀
     */
    String prefix() default "";
    /**
     * 缓存有效期 0 永久有效
     */
    String expireTime() default "0";

}
