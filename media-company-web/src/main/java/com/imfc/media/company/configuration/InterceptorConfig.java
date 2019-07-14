package com.imfc.media.company.configuration;

import com.imfc.media.company.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Autowired
    LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //设置拦截资源路径和白名单路径
        //以json结尾的请求均拦击
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**.json").excludePathPatterns("/**.ws");

    }
}
