package com.carl.breakfast.web.bean;

import com.carl.framework.util.StringUtil;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Carl
 * @date 2017/1/31
 * @since JDK1.7
 * <p>
 * 版权所有.(c)2008-2017.卡尔工作室
 */
public class AddressParamBean {
    private int id;
    //联系人名
    @NotNull
    @Size(min=2,max = 20)
    private String cName;
    //联系电话
    @NotNull
    @Size(min=6,max = 16)
    private String cPhone;
    @NotNull
    private String school;
    @NotNull
    private String build;
    @NotNull
    private String flow;
    @NotNull
    private String houseNum;
    private String detail;

    private String isDefault;

    public int getId() {
        return id;
    }

    public AddressParamBean setId(int id) {
        this.id = id;
        return this;
    }

    public String getcName() {
        return cName;
    }

    public AddressParamBean setcName(String cName) {
        this.cName = cName;
        return this;
    }

    public String getcPhone() {
        return cPhone;
    }

    public AddressParamBean setcPhone(String cPhone) {
        this.cPhone = cPhone;
        return this;
    }

    public String getSchool() {
        return school;
    }

    public AddressParamBean setSchool(String school) {
        this.school = school;
        return this;
    }

    public String getBuild() {
        return build;
    }

    public AddressParamBean setBuild(String build) {
        this.build = build;
        return this;
    }

    public String getFlow() {
        return flow;
    }

    public AddressParamBean setFlow(String flow) {
        this.flow = flow;
        return this;
    }

    public String getHouseNum() {
        return houseNum;
    }

    public AddressParamBean setHouseNum(String houseNum) {
        this.houseNum = houseNum;
        return this;
    }

    public String getDetail() {
        return detail;
    }

    public AddressParamBean setDetail(String detail) {
        this.detail = detail;
        return this;
    }

    public boolean isDefault() {
        return !StringUtil.isNull(isDefault);
    }

    public AddressParamBean setIsDefault(String isDefault) {
        this.isDefault = isDefault;
        return this;
    }
}
