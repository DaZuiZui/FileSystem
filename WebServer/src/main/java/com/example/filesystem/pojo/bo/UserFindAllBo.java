package com.example.filesystem.pojo.bo;


import java.io.Serializable;

public class UserFindAllBo implements Serializable {
    private String token;
    private String username;//用户账号
    private String name;//用户名
    private Long grade;//年级
    private String org;//班级/部门
    private Integer start;//开始长度
    private Integer size;//截止长度

    public UserFindAllBo(){

    }

    public UserFindAllBo(String token, String username, String name, Long grade, String org, Integer start, Integer size) {
        this.token = token;
        this.username = username;
        this.name = name;
        this.grade = grade;
        this.org = org;
        this.start = start;
        this.size = size;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "UserFindAllBo{" +
                "token='" + token + '\'' +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", org='" + org + '\'' +
                ", start=" + start +
                ", size=" + size +
                '}';
    }
}
