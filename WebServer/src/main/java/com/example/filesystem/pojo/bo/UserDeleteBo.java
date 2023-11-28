package com.example.filesystem.pojo.bo;

import java.io.Serializable;

public class UserDeleteBo implements Serializable {
    private String token;
    private Long id;
    public UserDeleteBo(){

    }

    public UserDeleteBo(String token, Long id) {
        this.token = token;
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "UserDeleteBo{" +
                "token='" + token + '\'' +
                ", id=" + id +
                '}';
    }
}
