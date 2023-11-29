package com.example.filesystem.pojo.bo;

import java.io.Serializable;

/**
 * @author hln 2023-11-29
 *      下载文件
 */
public class DownloadFileBo implements Serializable {

    private String token;
    private String serverFilename;//文件的绝对路径

    public DownloadFileBo(String token, String serverFilename) {
        this.token = token;
        this.serverFilename = serverFilename;
    }

    public DownloadFileBo() {
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
        return "DownloadFileBo{" +
                "token='" + token + '\'' +
                ", serverFilename='" + serverFilename + '\'' +
                '}';
    }
}
