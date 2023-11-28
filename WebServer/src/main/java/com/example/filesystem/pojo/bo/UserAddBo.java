package com.example.filesystem.pojo.bo;



import java.io.Serializable;

/**
 * 2023-11-28 zhuxinyu
 * 用户登入实体类
 */
public class UserAddBo implements Serializable {
    private String username;//用户账号
    private String password;//用户密码
    private UserAddBo(){

    }

    public UserAddBo(String username, String password) {
        this.username = username;
        this.password = password;
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

    @Override
    public String toString() {
        return "UserAddBo{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
