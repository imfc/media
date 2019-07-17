package com.imfc.media.doctor.interceptor;

import com.imfc.media.common.util.CookieUtil;
import com.imfc.media.util.JwtUtil;
import io.jsonwebtoken.Claims;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取请求中的参数jwt
        String newJwt = request.getParameter("jwt");
        if(StringUtils.isNoneEmpty(newJwt)){
            CookieUtil.setCookie(request,response,"jwt",newJwt);
        }
        //获取cookie中的jwt
        String jwt = CookieUtil.getCookieValue(request, "jwt");
        //判断是否有jwt
        if(StringUtils.isBlank(jwt)){
            System.out.println("cookie中没有jwt，用户未登录，重定向到login.html");
            String returnUrl = request.getRequestURL().toString();
            response.sendRedirect("/pages/examples/login.html?returnUrl="+returnUrl);
            return false;
        }else{
            //不去cas验证，本地直接校验
            Claims claims = JwtUtil.parseJWT(jwt, "123456");
            System.out.println("JWT解密的结果："+ claims);
            //判断是否过期
            claims.get("expireTime");
            //判断是否能访问本项目


        }


        return true;
    }
}
