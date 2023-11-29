package com.example.filesystem.pojo;

import java.io.Serializable;
import java.util.Date;

public class FileS implements Serializable {

    private Long id;
    private String serverFilename;//文件的绝对路径
    private String path;//路径（"/" + 文件名）
    private Long size;//文件大小 单位（B）
    private String fileStatus;//状态（0:私有，1:指定人员访问，2:公开）
    private Integer role;//权限（0：普通用户，1：老师，2：管理员）
    private String category;//文件类型
    private String downloadRecord;//下载记录
    private Long shareUserId;//共享成员ID
    private String operationRecord;// 操作记录
    private Long createBy;//创建人
    private Date createTime;//创建时间
    private Long updateBy;//修改人
    private Date updateTime;//修改时间
    private Integer status;//状态(0:正常，1：删除)
    private Integer delFlag;//逻辑删除(0:正常，1：删除)

    public FileS(String serverFilename) {
        this.id = id;
        this.serverFilename = serverFilename;
        this.path = path;
        this.size = size;
        this.fileStatus = fileStatus;
        this.role = role;
        this.category = category;
        this.downloadRecord = downloadRecord;
        this.shareUserId = shareUserId;
        this.operationRecord = operationRecord;
        this.createBy = createBy;
        this.createTime = createTime;
        this.updateBy = updateBy;
        this.updateTime = updateTime;
        this.status = status;
        this.delFlag = delFlag;
    }

    public FileS() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getServerFilename() {
        return serverFilename;
    }

    public void setServerFilename(String serverFilename) {
        this.serverFilename = serverFilename;
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

    public String getFileStatus() {
        return fileStatus;
    }

    public void setFileStatus(String fileStatus) {
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

    public String getDownloadRecord() {
        return downloadRecord;
    }

    public void setDownloadRecord(String downloadRecord) {
        this.downloadRecord = downloadRecord;
    }

    public Long getShareUserId() {
        return shareUserId;
    }

    public void setShareUserId(Long shareUserId) {
        this.shareUserId = shareUserId;
    }

    public String getOperationRecord() {
        return operationRecord;
    }

    public void setOperationRecord(String operationRecord) {
        this.operationRecord = operationRecord;
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
                ", serverFilename='" + serverFilename + '\'' +
                ", path='" + path + '\'' +
                ", size=" + size +
                ", fileStatus='" + fileStatus + '\'' +
                ", role=" + role +
                ", category='" + category + '\'' +
                ", downloadRecord='" + downloadRecord + '\'' +
                ", shareUserId=" + shareUserId +
                ", operationRecord='" + operationRecord + '\'' +
                ", createBy=" + createBy +
                ", createTime=" + createTime +
                ", updateBy=" + updateBy +
                ", updateTime=" + updateTime +
                ", status=" + status +
                ", delFlag=" + delFlag +
                '}';
    }
}
