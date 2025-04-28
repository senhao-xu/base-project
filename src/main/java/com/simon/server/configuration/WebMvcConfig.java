package com.simon.server.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author senhao-xu
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                // 允许跨域访问的源
                .allowedOrigins("*")
                // 允许头部设置
                .allowedHeaders("*")
                // 预检间隔时间
                .maxAge(168000)
                // 允许请求方法
                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE");
    }

}