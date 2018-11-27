package com.xdclass.xdvideo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * thymeleaf模板框架测试
 */
@Controller
public class ThymeleafController {

    @RequestMapping("/index")
    public String hello(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
        model.addAttribute("name", name);
        return "login";
    }


}
