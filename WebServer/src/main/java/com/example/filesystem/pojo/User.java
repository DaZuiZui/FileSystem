package com.example.filesystem.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 2023-11-28 zhuxinyu
 * 用户实体类
 */
public class User implements Serializable {
    private Long id;
    private String username;//用户账号
    private String password;//用户密码
    private String name;//用户名
    private Long grade;//年级
    private String org;//班级/部门
    private Integer role;//权限（ 0是公开，1是私有，2是管理人员）
    private Long createBy;//创建人
    private Date createTime;//创建时间
    private Long updateBy;//更新人
    private Date updateTime;//更新时间
    private Integer status;//状态
    private Integer delFlag;//逻辑删除（0：没有删除，1：已删除）

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

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public User(Long id, String username, String password, String name, Long grade, String org, Integer role, Long createBy, Date createTime, Long updateBy, Date updateTime, Integer status, Integer delFlag) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.grade = grade;
        this.org = org;
        this.role = role;
        this.createBy = createBy;
        this.createTime = createTime;
        this.updateBy = updateBy;
        this.updateTime = updateTime;
        this.status = status;
        this.delFlag = delFlag;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", org='" + org + '\'' +
                ", role=" + role +
                ", createBy=" + createBy +
                ", createTime=" + createTime +
                ", updateBy=" + updateBy +
                ", updateTime=" + updateTime +
                ", status=" + status +
                ", delFlag=" + delFlag +
                '}';
    }
}
