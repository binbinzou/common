package com.wifishared.common.framework.jwt;

import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class FeignConfig implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {
    	RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
    	HttpServletRequest request = ((ServletRequestAttributes)requestAttributes).getRequest();
    	String token = request.getHeader("Authorization");
    	log.info("Authorization:{}",token);
        requestTemplate.header("Authorization", token);
    }

}