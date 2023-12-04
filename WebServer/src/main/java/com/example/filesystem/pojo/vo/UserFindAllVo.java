package com.example.filesystem.pojo.vo;

import java.io.Serializable;

public class UserFindAllVo implements Serializable {
    private String username;//用户账号
    private String name;//用户名
    private Long grade;//年级
    private String org;//班级/部门

    public UserFindAllVo(){

    }

    public UserFindAllVo(String username, String name, Long grade, String org) {
        this.username = username;
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
        return "UserFindAllVo{" +
                "username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", org='" + org + '\'' +
                '}';
    }
}
