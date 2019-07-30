package com.imfc.media.company.interceptor;

import com.imfc.media.common.constant.SystemEnum;
import com.imfc.media.common.util.CookieUtil;
import com.imfc.media.company.annoation.AnyAccess;
import com.imfc.media.util.JwtUtil;
import io.jsonwebtoken.Claims;
import org.jboss.logging.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.Date;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("进入登录拦截器了...");
         /*
          * 获取方法注解
          * 如果添加了@AnyAccess，则不用登录即可访问
          */
//        HandlerMethod handlerMethod = (HandlerMethod)handler;
//        AnyAccess anyAccess = handlerMethod.getMethodAnnotation(AnyAccess.class);
//        if(null!=anyAccess){
//            return true;
//        }

        //拦截，检查用户是否携带登录令牌
        String newJwt = request.getParameter("jwt");    //刚登录成功
        String oldJwt = CookieUtil.getCookieValue(request, "jwt");   //已登录过
        String jwt = StringUtils.isEmpty(newJwt)?oldJwt:newJwt;
        if(!StringUtils.isEmpty(jwt)){
            //解析jwt
            String ip = request.getRemoteAddr();
            //如果使用了nginx反向代理
            //String ip = request.getHeader("x-forwarded-for");
            String sys = SystemEnum.getName(SystemEnum.COMPANY_SYS.getIndex());
            String key = JwtUtil.getKey(ip,sys);
            Claims claims = JwtUtil.parseJWT(jwt, key);
            //查看是否过期
            Long expireTime = (Long)claims.get("expireTime");
            Long now = new Date().getTime();

            if(now<expireTime){
                return true;
            }
            logger.info("用户登录已过期！");
        }else{
            logger.info("用户还未登录！");
        }

        //用户还未登录
        String requestURL = request.getRequestURL().toString();
        String url = URLEncoder.encode(requestURL,"utf-8");
        //重定向到登录页面
        response.sendRedirect("/admin/login.html?returnUrl="+url);

        return false;
    }
}
