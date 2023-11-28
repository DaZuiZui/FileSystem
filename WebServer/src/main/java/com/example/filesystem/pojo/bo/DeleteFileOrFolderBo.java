package com.example.filesystem.pojo.bo;

import java.io.Serializable;

/**
 * @author hln 2023-11-28
 *      删除文件或文件夹
 */
public class DeleteFileOrFolderBo implements Serializable {

    private String token;
    private String path;

    public DeleteFileOrFolderBo(String token, String path) {
        this.token = token;
        this.path = path;
    }

    public DeleteFileOrFolderBo() {
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
        return "DeleteFileOrFolderBo{" +
                "token='" + token + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}
