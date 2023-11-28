package com.example.filesystem.pojo.bo;

import com.example.filesystem.pojo.User;

import java.io.Serializable;

public class UserAddBo implements Serializable {
    private String username;

    private String password;
    private UserAddBo(){

    }

    public UserAddBo(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserAddBo{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
