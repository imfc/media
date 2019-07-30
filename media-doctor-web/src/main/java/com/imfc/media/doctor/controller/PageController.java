package com.imfc.media.doctor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("page/")
public class PageController {

    @RequestMapping("index")
    public String toIndexHtml(){

        return "index";
    }

    @RequestMapping("login")
    public String toIndexHtml(ModelMap model){

        model.addAttribute("name","zhangsan" );
        return "pages/examples/login";
    }
}
