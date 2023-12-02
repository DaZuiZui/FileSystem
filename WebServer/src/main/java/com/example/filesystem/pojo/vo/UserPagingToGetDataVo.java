package com.example.filesystem.pojo.vo;

import com.example.filesystem.pojo.User;
import io.swagger.models.auth.In;

import java.io.Serializable;
import java.util.List;

/**
 * @author zhuxinyu 2023-12-2
 * 用户分页查询返回数据实体类
 */
public class UserPagingToGetDataVo implements Serializable {
    private List<User> list;
    private Integer count;
    public UserPagingToGetDataVo (){

    }

    public UserPagingToGetDataVo(List<User> list, Integer count) {
        this.list = list;
        this.count = count;
    }

    public List<User> getList() {
        return list;
    }

    public void setList(List<User> list) {
        this.list = list;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "UserPagingToGetDataVo{" +
                "list=" + list +
                ", count=" + count +
                '}';
    }
}
