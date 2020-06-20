package com.soft1851.devoted.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 12559
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    /**
     * 添加拦截器配置
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
    }
}
