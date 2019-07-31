package com.imfc.media.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {
    Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.error("进入公共拦截器了....");
        //对于OPEIONS请求进行拦截，并直接返回成功；
//        if(request.getMethod().equals(RequestMethod.OPTIONS.name())){
//            response.setStatus(HttpStatus.OK.value());
//            return false;
//        }
        return true;
    }
}
