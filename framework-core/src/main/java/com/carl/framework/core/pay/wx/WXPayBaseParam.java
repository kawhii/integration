package com.carl.framework.core.pay.wx;

/**
 * 微信支撑基础参数
 *
 * @author Carl
 * @date 2017/2/4
 * 版权所有.(c)2017 - 2020. 卡尔工作室
 */
public abstract class WXPayBaseParam {
    //公众账号ID appid 微信支付分配的公众账号ID（企业号corpid即为此appId）
    private String appid;
    //商户号 mch_id 微信支付分配的商户号
    private String mchId;
    //device_info 自定义参数，可以为终端设备号(门店号或收银设备ID)，PC网页或公众号内支付可以传"WEB"
    private String deviceInfo;
    //随机字符串	nonce_str 随机字符串，长度要求在32位以内。推荐随机数生成算法
    private String nonceStr;
    //签名 sign 通过签名算法计算得出的签名值，详见签名生成算法
    private String sign;
    //签名类型	sign_type HMAC-SHA256	签名类型，默认为MD5，支持HMAC-SHA256和MD5。
    private String signType;
    //商品描述	body 腾讯充值中心-QQ会员充值 商品简单描述，该字段请按照规范传递，具体请见参数规定
    private String body;
}
