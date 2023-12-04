package com.example.filesystem.pojo.vo;

import java.util.List;

public class FindAllNewVo {
    private List<UserFindAllVo> list;
    private Integer count;

    public FindAllNewVo() {
    }

    public FindAllNewVo(List<UserFindAllVo> list, Integer count) {
        this.list = list;
        this.count = count;
    }

    public List<UserFindAllVo> getList() {
        return list;
    }

    public void setList(List<UserFindAllVo> list) {
        this.list = list;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "FindAllNewVo{" +
                "list=" + list +
                ", count=" + count +
                '}';
    }
}
