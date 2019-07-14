package com.imfc.media.company.controller;

import com.imfc.media.company.interceptor.LoginInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class IndexController {
    Logger logger = LoggerFactory.getLogger(IndexController.class);

    @RequestMapping("/index")
    public String toIndexHtml(ModelMap model){

        model.addAttribute("name","zhangsan" );
        return "index";
    }

}
