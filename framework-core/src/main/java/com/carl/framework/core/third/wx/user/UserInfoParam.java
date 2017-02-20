package com.carl.framework.core.third.wx.user;

import com.carl.framework.core.pay.AbsRequestParam;

/**
 *
 * https://mp.weixin.qq.com/wiki
 *
 *
 * 获取用户基本信息（包括UnionID机制）
 开发者可通过OpenID来获取用户基本信息。请使用https协议。
 接口调用请求说明
 http请求方式: GET https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN
 参数说明
 参数	是否必须	说明
 access_token	是	调用接口凭证
 openid	是	普通用户的标识，对当前公众号唯一
 lang	否	返回国家地区语言版本，zh_CN 简体，zh_TW 繁体，en 英语
 返回说明
 正常情况下，微信会返回下述JSON数据包给公众号：
 {
 "subscribe": 1,
 "openid": "o6_bmjrPTlm6_2sgVt7hMZOPfL2M",
 "nickname": "Band",
 "sex": 1,
 "language": "zh_CN",
 "city": "广州",
 "province": "广东",
 "country": "中国",
 "headimgurl":  "http://wx.qlogo.cn/mmopen/g3MonUZtNHkdmzicIlibx6iaFqAc56vxLSUfpb6n5WKSYVY0ChQKkiaJSgQ1dZuTOgvLLrhJbERQQ4
 eMsv84eavHiaiceqxibJxCfHe/0",
 "subscribe_time": 1382694957,
 "unionid": " o6_bmasdasdsad6_2sgVt7hMZOPfL"
 "remark": "",
 "groupid": 0,
 "tagid_list":[128,2]
 }
 参数说明
 参数	说明
 subscribe	用户是否订阅该公众号标识，值为0时，代表此用户没有关注该公众号，拉取不到其余信息。
 openid	用户的标识，对当前公众号唯一
 nickname	用户的昵称
 sex	用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
 city	用户所在城市
 country	用户所在国家
 province	用户所在省份
 language	用户的语言，简体中文为zh_CN
 headimgurl	用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空。若用户更换头像，原有头像URL将失效。
 subscribe_time	用户关注时间，为时间戳。如果用户曾多次关注，则取最后关注时间
 unionid	只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。
 remark	公众号运营者对粉丝的备注，公众号运营者可在微信公众平台用户管理界面对粉丝添加备注
 groupid	用户所在的分组ID（兼容旧的用户分组接口）
 tagid_list	用户被打上的标签ID列表
 错误时微信会返回错误码等信息，JSON数据包示例如下（该示例为AppID无效错误）:
 {"errcode":40013,"errmsg":"invalid appid"}
 *
 * @author Carl
 * @date 2017/2/20
 * 版权所有.(c)2017 - 2020. 卡尔工作室
 */
public class UserInfoParam extends AbsRequestParam {
    public static final String URL = "https://api.weixin.qq.com/cgi-bin/user/info";
    private String accessToken;
    private String openid;
    private Lang lang = Lang.zh_CN;

    public UserInfoParam(String accessToken, String openid) {
        this.accessToken = accessToken;
        this.openid = openid;
    }

    public static String getURL() {
        return URL;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public UserInfoParam setAccessToken(String accessToken) {
        this.accessToken = accessToken;
        return this;
    }

    public String getOpenid() {
        return openid;
    }

    public UserInfoParam setOpenid(String openid) {
        this.openid = openid;
        return this;
    }

    public Lang getLang() {
        return lang;
    }

    public UserInfoParam setLang(Lang lang) {
        this.lang = lang;
        return this;
    }

    @Override
    public String getUrl() {
        return new StringBuilder(super.getUrl())
                .append("?access_token=")
                .append(getAccessToken())
                .append("&openid=").append(getOpenid())
                .append("&lang=").append(getLang().name())
                .toString();
    }

    public enum Lang {
        zh_CN,
        zh_TW,
        en
    }
}
