package com.arpit.spring_boot_yash_batch.components;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class ApiIntercepter implements HandlerInterceptor {

    @Value("${api.key}")    // to access application properties
    private String apiKey;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,  Object handler) throws Exception {

        String requestApiKey = request.getHeader("API-Key");

        if (apiKey.equals(requestApiKey)) {
            return true;
        } else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Unauthorized: Invalid API Key");
            return false;
        }
    }
}
