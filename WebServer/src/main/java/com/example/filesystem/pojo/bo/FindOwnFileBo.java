package com.example.filesystem.pojo.bo;

import java.io.Serializable;

/**
 * @author hln 2023-11-28
 *      显示自己的文件
 */
public class FindOwnFileBo implements Serializable {

    private String token;
    private Long createBy;//创建人（文件上传者）

    public FindOwnFileBo(String token, Long createBy) {
        this.token = token;
        this.createBy = createBy;
    }

    public FindOwnFileBo() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    @Override
    public String toString() {
        return "FindOwnFileBo{" +
                "token='" + token + '\'' +
                ", createBy=" + createBy +
                '}';
    }
}
