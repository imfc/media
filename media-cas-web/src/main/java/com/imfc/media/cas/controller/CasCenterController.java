package com.imfc.media.cas.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.imfc.media.userSys.service.user.IUserService;
import com.imfc.media.util.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class CasCenterController {
    Logger logger = LoggerFactory.getLogger(CasCenterController.class);
//    @Reference
//    IUserService userService;

    @RequestMapping("/login")
    @ResponseBody
//    @CrossOrigin(origins = "*")
    public String login(HttpServletRequest request){
        String uid = request.getParameter("userId");
        String pwd = request.getParameter("password");
        if("admin".equals(uid) && "123456".equals(pwd)){
            Map<String,Object> map = new HashMap<>();
            map.put("userId","001");
            map.put("userName","zhangsan");
            map.put("expireTime",new Date().getTime()+1000*1800);
            String jwt = JwtUtil.createJWT(map, "123456");
            logger.info("登录成功！");
            return jwt;
        }else{
            logger.info("登录失败！");
            return "fail";
        }

    }
}
