package com.example.filesystem.pojo.bo;

import com.example.filesystem.pojo.vo.UserFindAllVo;
import com.example.filesystem.service.UserService;

import java.io.Serializable;

public class UserFindAllBo implements Serializable {
    private String token;
    private Long id;//用户id
    private String username;//用户账号
    private String name;//用户名
    private Long grade;//年级
    private String org;//班级/部门
    private Integer start;//开始长度
    private Integer size;//截止长度

    public UserFindAllBo(){

    }

    public UserFindAllBo(String token, Long id, String username, String name, Long grade, String org, Integer start, Integer size) {
        this.token = token;
        this.id = id;
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
                ", id=" + id +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", org='" + org + '\'' +
                ", start=" + start +
                ", size=" + size +
                '}';
    }
//    public void checkParam() {
//        if (this.pageIndex == null || this.pageIndex < 0) {
//            setPageIndex(1L);
//        }
//        if (this.pageSize == null || this.pageSize < 0 || this.pageSize > 100) {
//            setPageSize(10L);
//        }
//    }
//
//    public Long getPageStart() {
//        return (this.pageIndex - 1) * this.pageSize;
//    }
}
