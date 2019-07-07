package com.imfc.media.user.controller;

import com.imfc.meida.user.userService.IUserService;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
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
