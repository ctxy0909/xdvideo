package com.xdclass.xdvideo.controller;

import com.xdclass.xdvideo.config.WeChatConfig;
import com.xdclass.xdvideo.domain.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Controller
@RequestMapping("/api/v1/wechat")
public class WeChatController {
    @Autowired
    private WeChatConfig weChatConfig;
    /**
     * 拼装扫一扫登陆url
     * @return
     */
    @RequestMapping("login_url")
    @ResponseBody
    public JsonData loginUrl(@RequestParam(value = "access_page",required = true)String accessPage) throws UnsupportedEncodingException {
        //获取开放平台重定向地址
        String redirectUrl=weChatConfig.getOpenRedirectUrl();
        //进行编码
        String callbackUrl=URLEncoder.encode(redirectUrl,"GBK");
        String qrcodeUrl=String.format(weChatConfig.getOpenQrcodeUrl(),weChatConfig.getOpenAppid(),callbackUrl,accessPage);

        return  JsonData.buildSuccess(qrcodeUrl);


    }
}
