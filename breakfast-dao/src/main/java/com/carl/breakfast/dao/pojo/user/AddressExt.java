package com.carl.breakfast.dao.pojo.user;

import com.carl.framework.core.entity.BaseEntity;

/**
 * @author Carl
 * @date 2017/1/31
 * @since JDK1.7
 * <p>
 * 版权所有.(c)2008-2017.卡尔工作室
 */
public class AddressExt extends BaseEntity {
    private int id;
    //ADDRESS_ID
    private int addressId;
    //KEY_NAME
    private String  keyName;
    //KEY_AS
    private String keyAs;
    //VAL
    private String val;

    public int getId() {
        return id;
    }

    public AddressExt setId(int id) {
        this.id = id;
        return this;
    }

    public int getAddressId() {
        return addressId;
    }

    public AddressExt setAddressId(int addressId) {
        this.addressId = addressId;
        return this;
    }

    public String getKeyName() {
        return keyName;
    }

    public AddressExt setKeyName(String keyName) {
        this.keyName = keyName;
        return this;
    }

    public String getKeyAs() {
        return keyAs;
    }

    public AddressExt setKeyAs(String keyAs) {
        this.keyAs = keyAs;
        return this;
    }

    public String getVal() {
        return val;
    }

    public AddressExt setVal(String val) {
        this.val = val;
        return this;
    }
}
