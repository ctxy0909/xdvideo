package com.xdclass.xdvideo.controller.system;


import com.xdclass.xdvideo.domain.User;
import com.xdclass.xdvideo.domain.WxUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * 执行登录
 */
@Controller
public class SysLoginController {


   @RequestMapping("/login")
    public String login() {
        return "login";
   }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        if (subject != null) {
            subject.logout();
        }
        return "login";
    }

    @RequestMapping(value = "/loginUser", method = RequestMethod.POST)
    public String loginUser(@RequestParam("username")String username,
                            @RequestParam("password") String password,
                            HttpSession session
    ){

        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject subject= SecurityUtils.getSubject();
        try {
            subject.login(token);
            User user=(User) subject.getPrincipal();
            session.setAttribute("user", user);
            return "index";
        }catch (Exception e){
            return "login";
        }


    }
}