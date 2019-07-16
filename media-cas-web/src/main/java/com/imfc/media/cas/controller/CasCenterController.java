package com.imfc.media.cas.controller;

import com.imfc.media.util.JwtUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class CasCenterController {

    @RequestMapping("/login")
    @ResponseBody
    public String login(HttpServletRequest request){
        String uid = request.getParameter("userid");
        String pwd = request.getParameter("password");
        if("admin".equals(uid) && "123456".equals(pwd)){
            Map<String,Object> map = new HashMap<>();
            String jwt = JwtUtil.createJWT(map, "123456");
            return jwt;
        }else{
            return "";
        }

    }
}
