package com.xdclass.xdvideo.service;

import com.xdclass.xdvideo.domain.Video;
import com.xdclass.xdvideo.domain.VideoOrder;


import java.util.List;

/**
 * 视频业务类接口
 */
public interface VideoService {

    List<Video> findAll();

    Video findById(int id);

    int update(Video Video);

    int delete(int id);

    int save(Video video);

}
