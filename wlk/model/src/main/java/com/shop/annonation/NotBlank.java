package com.shop.annonation;

import java.lang.annotation.*;

/**
 * @author gary
 * @date 2018/11/8 9:32 AM
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NotBlank {

    String message() default "Not NULL";

    /** 最小长度 */
    int minLen() default 0;

    int maxLen() default 0;
}
