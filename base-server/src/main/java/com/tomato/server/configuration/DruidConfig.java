package com.tomato.server.configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Dark
 * @date 2020/10/19 9:31
 */
@Configuration
public class DruidConfig {

    private final String ADMIN = "xusenhao";

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDataSource(){
        return new DruidDataSource();
    }

    /**
     * 后台监控  相当于配置web.xml
     * @return
     */
    @Bean
    public ServletRegistrationBean registrationBean(){
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(),"/druid/*");
        //添加用户名密码
        Map<String, String> map = new HashMap<>(16);
        map.put("loginUsername",ADMIN);
        map.put("loginPassword",ADMIN);
        bean.setInitParameters(map);
        return bean;
    }
}
