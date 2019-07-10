package com.imfc.media.user.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.imfc.media.user.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class UserController {

    @Reference
    IUserService userService;

    @RequestMapping("login")
    @ResponseBody
    public Map<String,Object> login(HttpServletRequest request){

        return userService.getUser("zhangsan","123456");
    }
}
