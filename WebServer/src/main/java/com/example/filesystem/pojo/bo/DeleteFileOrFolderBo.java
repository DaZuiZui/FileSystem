package com.example.filesystem.pojo.bo;

import java.io.Serializable;

/**
 * @author hln 2023-11-28
 *      删除文件或文件夹
 */
public class DeleteFileOrFolderBo implements Serializable {

    private String token;
    private String serverFilename;

    public DeleteFileOrFolderBo(String token, String serverFilename) {
        this.token = token;
        this.serverFilename = serverFilename;
    }

    public DeleteFileOrFolderBo() {
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
        return "DeleteFileOrFolderBo{" +
                "token='" + token + '\'' +
                ", serverFilename='" + serverFilename + '\'' +
                '}';
    }
}
