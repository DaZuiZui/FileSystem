package com.example.filesystem.pojo;

import javax.xml.crypto.Data;
import java.io.Serializable;

public class User implements Serializable {
    private Long id;
    private String username;
    private String password;
    private Long role;
    private Long createBy;
    private Data createTime;
    private Long updateBy;
    private Data updateTime;
    private Long status;
    private Long del_flag;

    public User(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getRole() {
        return role;
    }

    public void setRole(Long role) {
        this.role = role;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Data getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Data createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    public Data getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Data updateTime) {
        this.updateTime = updateTime;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Long getDel_flag() {
        return del_flag;
    }

    public void setDel_flag(Long del_flag) {
        this.del_flag = del_flag;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", createBy=" + createBy +
                ", createTime=" + createTime +
                ", updateBy=" + updateBy +
                ", updateTime=" + updateTime +
                ", status=" + status +
                ", del_flag=" + del_flag +
                '}';
    }

    public User(Long id, String username, String password, Long role, Long createBy, Data createTime, Long updateBy, Data updateTime, Long status, Long del_flag) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.createBy = createBy;
        this.createTime = createTime;
        this.updateBy = updateBy;
        this.updateTime = updateTime;
        this.status = status;
        this.del_flag = del_flag;
    }
}
