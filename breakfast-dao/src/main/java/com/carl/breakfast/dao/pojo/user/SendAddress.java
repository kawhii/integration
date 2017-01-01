package com.carl.breakfast.dao.pojo.user;

import com.carl.framework.core.entity.BaseEntity;

/**
 * 寄送地址
 *
 * @author Carl
 * @date 2017/1/1
 * 版权所有.(c)2017 - 2020. 卡尔工作室
 */
public class SendAddress extends BaseEntity {
    //ID
    private int id;
    //CONTACTS_NAME 联系人名
    private String contactsName;
    //CONTACTS_PHONE 联系电话
    private String contactsPhone;
    //IS_DEFAULT 是否默认地址
    private boolean isDefault;
    //USERNAME 归属用户
    private String username;
    //DETAIL 详细地址
    private String detail;

    //外围地址
    private PeripheralAddress base;

    public int getId() {
        return id;
    }

    public SendAddress setId(int id) {
        this.id = id;
        return this;
    }

    public String getContactsName() {
        return contactsName;
    }

    public SendAddress setContactsName(String contactsName) {
        this.contactsName = contactsName;
        return this;
    }

    public String getContactsPhone() {
        return contactsPhone;
    }

    public SendAddress setContactsPhone(String contactsPhone) {
        this.contactsPhone = contactsPhone;
        return this;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public SendAddress setDefault(boolean aDefault) {
        isDefault = aDefault;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public SendAddress setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getDetail() {
        return detail;
    }

    public SendAddress setDetail(String detail) {
        this.detail = detail;
        return this;
    }

    public PeripheralAddress getBase() {
        return base;
    }

    public SendAddress setBase(PeripheralAddress base) {
        this.base = base;
        return this;
    }
}
