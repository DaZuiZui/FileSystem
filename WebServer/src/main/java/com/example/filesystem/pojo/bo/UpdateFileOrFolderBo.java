package com.example.filesystem.pojo.bo;

import java.io.Serializable;

public class UpdateFileOrFolderBo implements Serializable {

    private String token;
    private String serverFilename;//文件的绝对路径
    private String updateName;//修改名

    public UpdateFileOrFolderBo(String token, String serverFilename, String updateName) {
        this.token = token;
        this.serverFilename = serverFilename;
        this.updateName = updateName;
    }

    public UpdateFileOrFolderBo() {
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

    public String getUpdateName() {
        return updateName;
    }

    public void setUpdateName(String updateName) {
        this.updateName = updateName;
    }

    @Override
    public String toString() {
        return "UpdateFileOrFolderBo{" +
                "token='" + token + '\'' +
                ", serverFilename='" + serverFilename + '\'' +
                ", updateName='" + updateName + '\'' +
                '}';
    }
}
