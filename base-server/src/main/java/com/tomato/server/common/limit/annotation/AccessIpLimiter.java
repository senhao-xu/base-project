package com.tomato.server.common.limit.annotation;

import java.lang.annotation.*;


/**
 * @author senhao-xu
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AccessIpLimiter {
    // 每timeout限制请求的个数
    int limit() default 1;

    // 时间，单位默认是秒
    int timeout() default 1;

    // 缓存的key
    String key() default "";
}
