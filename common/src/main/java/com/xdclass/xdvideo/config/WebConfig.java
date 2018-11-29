package com.xdclass.xdvideo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public abstract class WebConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry viewControllerRegistry) {
      /*  viewControllerRegistry.addViewController("/").setViewName("login");*/
    }
}
