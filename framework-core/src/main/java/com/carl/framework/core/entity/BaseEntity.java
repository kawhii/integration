package com.carl.framework.core.entity;

import java.util.Date;

/**
 * 基类.
 * @author Carl
 * @date 2016/12/1
 * @since JDK1.7
 * <p>
 * 版权所有.(c)2008-2016.广州市森锐科技股份有限公司
 */
public class BaseEntity {

    private Integer version = 0;// 版本号默认为0
    private String creater;// 创建人.
    private Date createTime = new Date();// 创建时间.
    private String editor;// 修改人.
    private Date editTime;// 修改时间.



    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }


    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public Date getEditTime() {
        return editTime;
    }

    public void setEditTime(Date editTime) {
        this.editTime = editTime;
    }

}
