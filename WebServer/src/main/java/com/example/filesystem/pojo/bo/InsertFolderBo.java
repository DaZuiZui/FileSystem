package com.example.filesystem.pojo.bo;

import java.io.Serializable;

/**
 * @author zzy 2023-11-28
 *      新建文件夹
 */
public class InsertFolderBo implements Serializable {

    private String token;
    private String serverFilename;//文件的绝对路径
    private String path;//

    public InsertFolderBo(){

    }

    public InsertFolderBo(String token, String serverFilename, String path) {
        this.token = token;
        this.serverFilename = serverFilename;
        this.path = path;
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "InsertFileOrFolderBo{" +
                "token='" + token + '\'' +
                ", serverFilename='" + serverFilename + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}
