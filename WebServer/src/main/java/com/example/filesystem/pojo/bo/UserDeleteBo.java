package com.example.filesystem.pojo.bo;

import java.io.Serializable;

public class UserDeleteBo implements Serializable {
    private String token;
    private String id;
    public UserDeleteBo(){

    }

    public UserDeleteBo(String token, String id) {
        this.token = token;
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "UserDeleteBo{" +
                "token='" + token + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
