package com.carl.breakfast.dao.sys.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统文件
 * @author Carl
 * @date 2016/11/27
 * © 2016 - 2020 , all rights reserved .卡尔工作室
 */
public class SysFile implements Serializable {
    private int id;
    //业务编码
    private String bizCode;
    //访问路径
    private String visitPath;
    //文件大小
    private long fileSize;
    //上传时间
    private Date uploadTime;
    //上传用户
    private String uploadUser;
    //上传ip
    private String uploadIp;
    //是否有效
    private boolean effective;
    //下载次数
    private int downloadTimes;
    //文件类型
    private int type;
    //备注
    private String remark;

    public SysFile() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBizCode() {
        return bizCode;
    }

    public void setBizCode(String bizCode) {
        this.bizCode = bizCode;
    }

    public String getVisitPath() {
        return visitPath;
    }

    public void setVisitPath(String visitPath) {
        this.visitPath = visitPath;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getUploadUser() {
        return uploadUser;
    }

    public void setUploadUser(String uploadUser) {
        this.uploadUser = uploadUser;
    }

    public String getUploadIp() {
        return uploadIp;
    }

    public void setUploadIp(String uploadIp) {
        this.uploadIp = uploadIp;
    }

    public boolean isEffective() {
        return effective;
    }

    public void setEffective(boolean effective) {
        this.effective = effective;
    }

    public int getDownloadTimes() {
        return downloadTimes;
    }

    public void setDownloadTimes(int downloadTimes) {
        this.downloadTimes = downloadTimes;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
