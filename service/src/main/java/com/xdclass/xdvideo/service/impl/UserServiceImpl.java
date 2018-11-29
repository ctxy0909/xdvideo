package com.xdclass.xdvideo.service.impl;


import com.xdclass.xdvideo.domain.User;
import com.xdclass.xdvideo.mapper.UserMapper;
import com.xdclass.xdvideo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ct
 * @Title: UserServiceImpl
 * @ProjectName demo2
 * @Description: TODO
 * @date 2018/11/18 18:45
 */
@Service
public class UserServiceImpl implements UserService {
@Resource
private UserMapper userMapper;
    @Override
    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }
}
