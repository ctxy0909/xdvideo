package com.xdclass.xdvideo.service;


import com.xdclass.xdvideo.domain.User;

/**
 * @author ct
 * @Title: UserService
 * @ProjectName demo2
 * @Description: TODO
 * @date 2018/11/18 18:43
 */
public interface UserService {
    User findByUsername(String username);
}
