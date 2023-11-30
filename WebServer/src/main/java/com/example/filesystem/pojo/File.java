package com.example.filesystem.pojo;

import java.io.Serializable;
import java.util.Date;

public class File implements Serializable {

    private Long id;
    private String serverFileName;//文件的绝对路径
    private String path;//路径（"/" + 文件名）
    private Long size;//文件大小 单位（B）
    private Integer fileStatus;//状态（0:私有，1:指定人员访问，2:公开）
    private Integer role;//权限（0：普通用户，1：老师，2：管理员）
    private String category;//文件类型
    private Long createBy;//创建人
    private Date createTime;//创建时间
    private Long updateBy;//修改人
    private Date updateTime;//修改时间
    private Integer status;//状态(0:正常，1：删除)
    private Integer delFlag;//逻辑删除(0:正常，1：删除)


    public File() {
    }

    public File(String serverFileName, String path, Long size, Integer fileStatus, Integer role, String category, Long createBy, Date createTime, Long updateBy, Date updateTime, Integer status, Integer delFlag) {
        this.serverFileName = serverFileName;
        this.path = path;
        this.size = size;
        this.fileStatus = fileStatus;
        this.role = role;
        this.category = category;
        this.createBy = createBy;
        this.createTime = createTime;
        this.updateBy = updateBy;
        this.updateTime = updateTime;
        this.status = status;
        this.delFlag = delFlag;
    }

    public File(Long id, String serverFileName, String path, Long size, Integer fileStatus, Integer role, String category, Long createBy, Date createTime, Long updateBy, Date updateTime, Integer status, Integer delFlag) {
        this.id = id;
        this.serverFileName = serverFileName;
        this.path = path;
        this.size = size;
        this.fileStatus = fileStatus;
        this.role = role;
        this.category = category;
        this.createBy = createBy;
        this.createTime = createTime;
        this.updateBy = updateBy;
        this.updateTime = updateTime;
        this.status = status;
        this.delFlag = delFlag;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getServerFileName() {
        return serverFileName;
    }

    public void setServerFileName(String serverFileName) {
        this.serverFileName = serverFileName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Integer getFileStatus() {
        return fileStatus;
    }

    public void setFileStatus(Integer fileStatus) {
        this.fileStatus = fileStatus;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    @Override
    public String toString() {
        return "File{" +
                "id=" + id +
                ", serverFileName='" + serverFileName + '\'' +
                ", path='" + path + '\'' +
                ", size=" + size +
                ", fileStatus=" + fileStatus +
                ", role=" + role +
                ", category='" + category + '\'' +
                ", createBy=" + createBy +
                ", createTime=" + createTime +
                ", updateBy=" + updateBy +
                ", updateTime=" + updateTime +
                ", status=" + status +
                ", delFlag=" + delFlag +
                '}';
    }
}
