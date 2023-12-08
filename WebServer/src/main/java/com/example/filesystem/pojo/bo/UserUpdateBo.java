package com.example.filesystem.pojo.bo;

import java.io.Serializable;

/**
 * 2023-11-28 zhuxinyu
 * 用户修改实体类
 */
public class UserUpdateBo implements Serializable {
    private Long id;
    private Long grade;
    private String org;
    public UserUpdateBo(){

    }

    public UserUpdateBo(Long id, Long grade, String org) {
        this.id = id;
        this.grade = grade;
        this.org = org;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        return "UserUpdateBo{" +
                "id=" + id +
                ", grade=" + grade +
                ", org='" + org + '\'' +
                '}';
    }
}
