package com.tomato.server.common.limit.annotation;

import java.lang.annotation.*;


/**
 * @author senhao-xu
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AccessLimiter {
    // 目标： @AccessLimiter(limit="1",timeout="1",key="user:ip:limit")
    // 解读：一个用户key在timeout时间内，最多访问limit次
    // 缓存的key
    String key() default "";
    // 限制的次数
    int limit() default  1;
    // 过期时间
    int timeout() default  1;
}
