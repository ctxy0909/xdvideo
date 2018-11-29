package com.xdclass.xdvideo.domain;

import java.io.Serializable;

/**
 * @author ct
 * @Title: Premission
 * @ProjectName demo2
 * @Description: TODO
 * @date 2018/11/18 18:25
 */
public class Permission implements Serializable {
    private Integer pid;
    private String name;
    private String url;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
