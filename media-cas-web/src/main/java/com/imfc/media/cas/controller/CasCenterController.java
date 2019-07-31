package com.imfc.media.cas.controller;

import com.imfc.media.common.constant.SystemEnum;
import com.imfc.media.common.result.MediaResult;
import com.imfc.media.common.result.MediaResultService;
import com.imfc.media.util.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class CasCenterController {
    Logger logger = LoggerFactory.getLogger(CasCenterController.class);
//    @Reference
//    IUserService userService;
    @RequestMapping(value = "/*",method = RequestMethod.OPTIONS)
    public ResponseEntity handleOptions(){
        return (ResponseEntity) ResponseEntity.noContent();
    }

    @RequestMapping("/login")
    @ResponseBody
    @CrossOrigin(allowedHeaders = "*",allowCredentials = "true",maxAge = 3600)
    public MediaResult login(HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin","*");

        String uid = request.getParameter("userId");
        String pwd = request.getParameter("password");
        if("admin".equals(uid) && "123456".equals(pwd)){
            Map<String,Object> map = new HashMap<>();
            map.put("userId","001");
            map.put("userName","zhangsan");
            map.put("expireTime",new Date().getTime()+1000*1800); //设置过期时间
            //获取秘钥
//            String ip = request.getRemoteAddr(); //如果使用了nginx反向代理  String ip = request.getHeader("x-forwarded-for");
//            String sys = SystemEnum.getName(SystemEnum.SYS.getIndex());
//            String key = JwtUtil.getKey(ip,sys);
            //创建
            String jwt = JwtUtil.createJWT(map, "123456");
            logger.info("登录成功！");
            return MediaResultService.getInst().getOkResult(jwt);
        }else{
            logger.info("登录失败！");
            return MediaResultService.getInst().getErrorResult("faile");
        }

    }
}
