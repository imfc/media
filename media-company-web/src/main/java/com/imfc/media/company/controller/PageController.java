package com.imfc.media.company.controller;

import com.imfc.media.company.annoation.AnyAccess;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("page/")
public class PageController {
    Logger logger = LoggerFactory.getLogger(PageController.class);

    @RequestMapping("index")
    public String toIndexHtml(ModelMap model){

        model.addAttribute("name","zhangsan" );
        return "index";
    }

}
