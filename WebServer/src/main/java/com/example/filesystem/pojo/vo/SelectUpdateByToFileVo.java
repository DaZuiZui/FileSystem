package com.example.filesystem.pojo.vo;

import java.util.Date;

/**
 * @author hln 2023-11-28
 *      查看修改文件的人
 */
public class SelectUpdateByToFileVo {

    private String name;//修改人
    private Date updateTime;//修改时间

    public SelectUpdateByToFileVo(String name, Date updateTime) {
        this.name = name;
        this.updateTime = updateTime;
    }

    public SelectUpdateByToFileVo() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "SelectUpdateByToFileVo{" +
                "name='" + name + '\'' +
                ", updateTime=" + updateTime +
                '}';
    }
}
