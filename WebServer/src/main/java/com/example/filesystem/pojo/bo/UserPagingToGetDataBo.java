package com.example.filesystem.pojo.bo;

import java.io.Serializable;

public class UserPagingToGetDataBo implements Serializable {
    private String token;
    private Long start;//开始坐标
    private Integer size;//每页显示长度
    private String name;//id
    private Integer status;//0为私有活动 1多个社团活动 2 所有社团活动
    private Integer delFlag;//逻辑删除
    public UserPagingToGetDataBo(){

    }

    public UserPagingToGetDataBo(String token, Long start, Integer size, String name, Integer status, Integer delFlag) {
        this.token = token;
        this.start = start;
        this.size = size;
        this.name = name;
        this.status = status;
        this.delFlag = delFlag;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getStart() {
        return start;
    }

    public void setStart(Long start) {
        this.start = start;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    public String toString() {
        return "UserPagingToGetDataBo{" +
                "token='" + token + '\'' +
                ", start=" + start +
                ", size=" + size +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", delFlag=" + delFlag +
                '}';
    }
}
