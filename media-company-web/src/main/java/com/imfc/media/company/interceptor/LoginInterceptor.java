package com.imfc.media.company.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("进入登录拦截器了...");
        //获取请求路径，判断是否需要拦截【以‘.json’结尾的请求要拦截，判断是否登录】
        String requestURI = request.getRequestURI();
        if(requestURI.endsWith(".json")){
            String token = "";
            Cookie[] cookies = request.getCookies();
            if(!StringUtils.isEmpty(cookies)){
                for (int i=0;i<cookies.length;i++){
                    if("token".equals(cookies[i].getName())){
                        token = cookies[i].getValue();
                        break;
                    }
                }
            };

            if(StringUtils.isEmpty(token)){
                logger.info("用户未登录，去登陆吧...");
                String url = request.getRequestURL().toString();
                response.sendRedirect("/admin/login.html?returnUrl="+url);
                return false;
            }else{



            }
        }
        logger.info("用户已经登录过了...进入请求方法...");
        return true;
    }
}
