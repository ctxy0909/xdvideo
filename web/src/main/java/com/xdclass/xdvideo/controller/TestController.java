package com.xdclass.xdvideo.controller;

import com.xdclass.xdvideo.config.WeChatConfig;
import com.xdclass.xdvideo.domain.JsonData;
import com.xdclass.xdvideo.mapper.VideoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {

	@RequestMapping("test")
	public String test(){
		System.out.println("xdclass.net");

		return "hello xdclass.net777";
	}



	@Autowired
	private WeChatConfig weChatConfig;

	@RequestMapping("test_config")
	public JsonData testConfig(){

		System.out.println(weChatConfig.getOpenAppid());
		return JsonData.buildSuccess(weChatConfig.getOpenAppid());
	}
	/*public String testConfig(){

		System.out.println(weChatConfig.getAppid());
		return "hello xdclass.net";
	}*/



	@Autowired
	private VideoMapper videoMapper;

	@RequestMapping("test_db")
	public Object testDB(){


		return videoMapper.findAll();
	}





}
