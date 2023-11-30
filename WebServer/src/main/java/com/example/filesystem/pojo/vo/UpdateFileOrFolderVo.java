package com.example.filesystem.pojo.vo;

public class UpdateFileOrFolderVo {

    private String serverFilename;//文件的绝对路径
    private String lastName;//修改后的名

    public UpdateFileOrFolderVo(String serverFilename, String lastName) {
        this.serverFilename = serverFilename;
        this.lastName = lastName;
    }

    public UpdateFileOrFolderVo() {
    }

    public String getServerFilename() {
        return serverFilename;
    }

    public void setServerFilename(String serverFilename) {
        this.serverFilename = serverFilename;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "UpdateFileOrFolderVo{" +
                "serverFilename='" + serverFilename + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
