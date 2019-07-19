package com.imfc.media.doctor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

import static org.bouncycastle.asn1.x500.style.RFC4519Style.o;

@Controller
public class IndexController {

    @RequestMapping("/index")
    public String toIndexHtml(){

        return "index";
    }

    @RequestMapping("/login")
    public String toIndexHtml(ModelMap model){

        model.addAttribute("name","zhangsan" );
        return "pages/examples/login";
    }
}
