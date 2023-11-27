package com.example.filesystem.pojo.bo;

import com.example.filesystem.pojo.User;

import java.io.Serializable;

public class UserAddBo implements Serializable {
    private String token;
    private User user;
    private UserAddBo(){

    }

    public UserAddBo(String token, User user) {
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
        return "UserAddBo{" +
                "token='" + token + '\'' +
                ", user=" + user +
                '}';
    }
}
