package com.carl.breakfast.web.bean;

import com.carl.breakfast.dao.pojo.user.AddressExt;

/**
 * @author Carl
 * @date 2017/1/31
 * @since JDK1.7
 * <p>
 * 版权所有.(c)2008-2017.卡尔工作室
 */
public class AddressDetailBean {
    private int id;
    //CONTACTS_NAME 联系人名
    private String contactsName;
    //CONTACTS_PHONE 联系电话
    private String contactsPhone;
    //IS_DEFAULT 是否默认地址
    private boolean isDefault;
    //USERNAME 归属用户
    private String username;
    private AddressExt detailAddress;
    //学校
    private AddressExt school;
    //楼栋
    private AddressExt build;
    //楼层
    private AddressExt flow;
    //门牌号
    private AddressExt houseNumber;

    public String getContactsName() {
        return contactsName;
    }

    public AddressDetailBean setContactsName(String contactsName) {
        this.contactsName = contactsName;
        return this;
    }

    public String getContactsPhone() {
        return contactsPhone;
    }

    public AddressDetailBean setContactsPhone(String contactsPhone) {
        this.contactsPhone = contactsPhone;
        return this;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public AddressDetailBean setDefault(boolean aDefault) {
        isDefault = aDefault;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public AddressDetailBean setUsername(String username) {
        this.username = username;
        return this;
    }

    public AddressExt getDetailAddress() {
        return detailAddress;
    }

    public AddressDetailBean setDetailAddress(AddressExt detailAddress) {
        this.detailAddress = detailAddress;
        return this;
    }

    public AddressExt getSchool() {
        return school;
    }

    public AddressDetailBean setSchool(AddressExt school) {
        this.school = school;
        return this;
    }

    public AddressExt getBuild() {
        return build;
    }

    public AddressDetailBean setBuild(AddressExt build) {
        this.build = build;
        return this;
    }

    public AddressExt getFlow() {
        return flow;
    }

    public AddressDetailBean setFlow(AddressExt flow) {
        this.flow = flow;
        return this;
    }

    public AddressExt getHouseNumber() {
        return houseNumber;
    }

    public AddressDetailBean setHouseNumber(AddressExt houseNumber) {
        this.houseNumber = houseNumber;
        return this;
    }

    public int getId() {
        return id;
    }

    public AddressDetailBean setId(int id) {
        this.id = id;
        return this;
    }
}
