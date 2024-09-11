package com.arpit.spring_boot_yash_batch.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.arpit.spring_boot_yash_batch.components.ApiIntercepter;

@Configuration
public class WebConfig implements WebMvcConfigurer{

    @Autowired
    ApiIntercepter intercepter;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(intercepter).addPathPatterns("/food/**");
    }
}
