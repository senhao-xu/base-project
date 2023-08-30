package com.tomato.server.common.limit.aop;

import com.tomato.server.common.limit.annotation.AccessLimiter;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;


/**
 * @author 飞哥
 * @Title: 学相伴出品
 * @Description: 我们有一个学习网站：https://www.kuangstudy.com
 * @date 2021/7/7 11:42
 */
@Aspect
@Component
public class AccessLimiterAspect {

    private static final Logger log = LoggerFactory.getLogger(AccessLimiterAspect.class);

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private DefaultRedisScript<Boolean> ipLimitLua;

    // 定义aop的切入点
    @Pointcut("@annotation(com.tomato.server.common.limit.annotation.AccessLimiter)")
    public void cut() {
        log.info("cut");
    }

    // 拦截属于放入执行之前的行为，所以定义@Before通知
    @Before("cut()")
    public void before(JoinPoint joinPoint) {

        // 获取方法的签名作为key
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        AccessLimiter annotation = method.getAnnotation(AccessLimiter.class);

        //如果没有增加accessLimiter注解说明不需要限流，直接返回
        if (annotation == null) {
            return;
        }

        // 获取限流缓存的key
        String key = annotation.key();
        // 获取限流缓存的限制次数
        Integer limit = annotation.limit();
        // 获取限流缓存的时间
        Integer timeout = annotation.timeout();

        // 如果没有设置key，从调用方法的签名自动生成一个key
        if (StringUtils.isEmpty(key)) {
            // 获取方法所有的参数
            Class<?>[] types = method.getParameterTypes();
            // 获取方法的签名
            key = method.getName();
            // 如果又参数的话，用参数和key来确定唯一
            if (types != null) {
                String paramTypes = Arrays.stream(types).map(Class::getName)
                        .collect(Collectors.joining(","));
                log.info("param types : {}", paramTypes);
                key = key + "#" + paramTypes;
            }
        }

        // 请求lua脚本
        Boolean acquired = stringRedisTemplate.execute(ipLimitLua,
                Arrays.asList(key), limit.toString(), timeout.toString());
        if (!acquired) {
            log.error("you access is blocked ,key:{}", key);
            throw new RuntimeException("you acess is blocked");
        }
    }
}
