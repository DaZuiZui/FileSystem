package com.example.filesystem.pojo.bo;

import java.io.Serializable;

/**
 * 2023-12-01 zhuxinyu
 * 用户注册
 */
public class UserRegBo implements Serializable {
    private String username;//用户账号
    private String password;//用户密码
    private String name;//用户名
    private Long grade;//年级
    private String org;//班级/部门
    public UserRegBo(){

    }

    public UserRegBo(String username, String password, String name, Long grade, String org) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.grade = grade;
        this.org = org;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getGrade() {
        return grade;
    }

    public void setGrade(Long grade) {
        this.grade = grade;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    @Override
    public String toString() {
        return "UserRegBo{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", org='" + org + '\'' +
                '}';
    }
}
