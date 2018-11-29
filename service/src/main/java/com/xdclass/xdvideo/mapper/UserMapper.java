package com.xdclass.xdvideo.mapper;


import com.xdclass.xdvideo.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author ct
 * @Title: UserMapper
 * @ProjectName demo2
 * @Description: TODO
 * @date 2018/11/18 18:36
 */
@Mapper
public interface UserMapper {
    User findByUsername(@Param("username") String username);
}
