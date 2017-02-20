package com.carl.framework.core.third.wx.user;

import com.alibaba.fastjson.annotation.JSONField;
import com.carl.framework.core.third.wx.token.BaseResult;

/**
 * @author Carl
 * @date 2017/2/20
 * 版权所有.(c)2017 - 2020. 卡尔工作室
 */
public class UserInfoResult extends BaseResult {
    //用户是否订阅该公众号标识，值为0时，代表此用户没有关注该公众号，拉取不到其余信息。
    private int subscribe;
    private String openid;
    //用户的昵称
    private String nickname;
    //用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
    private int sex;
    private String city;
    //用户所在国家
    private String country;
    //用户所在省份
    private String province;
    //用户的语言，简体中文为zh_CN
    private String language;
    //用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空。若用户更换头像，原有头像URL将失效
    private String headimgurl;

    //用户关注时间，为时间戳。如果用户曾多次关注，则取最后关注时间
    @JSONField(name = "subscribe_time")
    private int subscribeTime;
    //只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。
    private String unionid;
    //公众号运营者对粉丝的备注，公众号运营者可在微信公众平台用户管理界面对粉丝添加备注
    private String remark;
    //用户所在的分组ID（兼容旧的用户分组接口）
    private int groupid;
    //用户所在的分组ID（兼容旧的用户分组接口）
    @JSONField(name = "tagid_list")
    private int [] tagidList;

    public int getSubscribe() {
        return subscribe;
    }

    public UserInfoResult setSubscribe(int subscribe) {
        this.subscribe = subscribe;
        return this;
    }

    public String getOpenid() {
        return openid;
    }

    public UserInfoResult setOpenid(String openid) {
        this.openid = openid;
        return this;
    }

    public String getNickname() {
        return nickname;
    }

    public UserInfoResult setNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public int getSex() {
        return sex;
    }

    public UserInfoResult setSex(int sex) {
        this.sex = sex;
        return this;
    }

    public String getCity() {
        return city;
    }

    public UserInfoResult setCity(String city) {
        this.city = city;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public UserInfoResult setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getProvince() {
        return province;
    }

    public UserInfoResult setProvince(String province) {
        this.province = province;
        return this;
    }

    public String getLanguage() {
        return language;
    }

    public UserInfoResult setLanguage(String language) {
        this.language = language;
        return this;
    }

    public String getHeadimgurl() {
        return headimgurl;
    }

    public UserInfoResult setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
        return this;
    }

    public int getSubscribeTime() {
        return subscribeTime;
    }

    public UserInfoResult setSubscribeTime(int subscribeTime) {
        this.subscribeTime = subscribeTime;
        return this;
    }

    public String getUnionid() {
        return unionid;
    }

    public UserInfoResult setUnionid(String unionid) {
        this.unionid = unionid;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public UserInfoResult setRemark(String remark) {
        this.remark = remark;
        return this;
    }

    public int getGroupid() {
        return groupid;
    }

    public UserInfoResult setGroupid(int groupid) {
        this.groupid = groupid;
        return this;
    }

    public int[] getTagidList() {
        return tagidList;
    }

    public UserInfoResult setTagidList(int[] tagidList) {
        this.tagidList = tagidList;
        return this;
    }
}
