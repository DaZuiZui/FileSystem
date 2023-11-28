package com.example.filesystem.pojo.bo;

import java.io.Serializable;

public class SelectUpdateByToFileBo implements Serializable {

    private String token;
    private String path;//路径

    public SelectUpdateByToFileBo(String token, String path) {
        this.token = token;
        this.path = path;
    }

    public SelectUpdateByToFileBo() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "SelectUpdateByToFileBo{" +
                "token='" + token + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}
