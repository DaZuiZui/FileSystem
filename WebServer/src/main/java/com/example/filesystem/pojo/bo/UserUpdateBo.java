package com.example.filesystem.pojo.bo;

import com.example.filesystem.pojo.User;

import java.io.Serializable;

/**
 * 2023-11-28 zhuxinyu
 * 用户修改实体类
 */
public class UserUpdateBo implements Serializable {
    private String token;
    private User user;//用户User
    public UserUpdateBo(){

    }

    public UserUpdateBo(String token, User user) {
        this.token = token;
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserUpdateBo{" +
                "token='" + token + '\'' +
                ", user=" + user +
                '}';
    }
}
