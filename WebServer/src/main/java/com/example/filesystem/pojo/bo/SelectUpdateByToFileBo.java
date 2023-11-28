package com.example.filesystem.pojo.bo;

import java.io.Serializable;

public class SelectUpdateByToFileBo implements Serializable {

    private String token;
    private String serverFilename;//路径

    public SelectUpdateByToFileBo(String token, String serverFilename) {
        this.token = token;
        this.serverFilename = serverFilename;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getServerFilename() {
        return serverFilename;
    }

    public void setServerFilename(String serverFilename) {
        this.serverFilename = serverFilename;
    }

    @Override
    public String toString() {
        return "SelectUpdateByToFileBo{" +
                "token='" + token + '\'' +
                ", serverFilename='" + serverFilename + '\'' +
                '}';
    }
}
