package com.carl.breakfast.dao.pojo.user;

import com.carl.framework.core.entity.BaseEntity;

/**
 * 公共地址
 * @author Carl
 * @date 2017/1/30
 * @since JDK1.7
 * <p>
 * 版权所有.(c)2008-2017.卡尔工作室
 */
public class CommonAddress extends BaseEntity {
    private String id;
    private String info;
    private String typeId;
    private int seq;
    private String pId;
    private String note;

    public String getId() {
        return id;
    }

    public CommonAddress setId(String id) {
        this.id = id;
        return this;
    }

    public String getInfo() {
        return info;
    }

    public CommonAddress setInfo(String info) {
        this.info = info;
        return this;
    }

    public String getTypeId() {
        return typeId;
    }

    public CommonAddress setTypeId(String typeId) {
        this.typeId = typeId;
        return this;
    }

    public int getSeq() {
        return seq;
    }

    public CommonAddress setSeq(int seq) {
        this.seq = seq;
        return this;
    }

    public String getpId() {
        return pId;
    }

    public CommonAddress setpId(String pId) {
        this.pId = pId;
        return this;
    }

    public String getNote() {
        return note;
    }

    public CommonAddress setNote(String note) {
        this.note = note;
        return this;
    }
}
