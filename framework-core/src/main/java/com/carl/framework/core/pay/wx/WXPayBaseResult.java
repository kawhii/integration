package com.carl.framework.core.pay.wx;

import com.carl.framework.core.modules.xml.CDATAAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * 微信支付结果基础类
 *
 * @author Carl
 * @date 2017/2/5
 * 版权所有.(c)2017 - 2020. 卡尔工作室
 */
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class WXPayBaseResult {
    //返回状态码	return_code SUCCESS SUCCESS/FAIL 此字段是通信标识，非交易标识，交易是否成功需要查看result_code来判断
    @XmlJavaTypeAdapter(value = CDATAAdapter.class)
    @XmlElement(name = "return_code")
    private String returnCode;
    //返回信息	return_msg 返回信息，如非空，为错误原因签名失败 参数格式校验错误
    @XmlJavaTypeAdapter(value = CDATAAdapter.class)
    @XmlElement(name = "return_msg")
    private String returnMsg;

    //以下字段在return_code为SUCCESS的时候有返回 开始

    //公众账号ID	appid 调用接口提交的公众账号ID
    @XmlJavaTypeAdapter(value = CDATAAdapter.class)
    private String appid;
    //商户号	mch_id 调用接口提交的商户号
    @XmlElement(name = "mch_id")
    @XmlJavaTypeAdapter(value = CDATAAdapter.class)
    private String mchId;

    //设备号	device_info 自定义参数，可以为请求支付的终端设备号等
    @XmlElement(name = "device_info")
    @XmlJavaTypeAdapter(value = CDATAAdapter.class)
    private String deviceInfo;
    //随机字符串	nonce_str 微信返回的随机字符串
    @XmlElement(name = "nonce_str")
    @XmlJavaTypeAdapter(value = CDATAAdapter.class)
    private String nonceStr;
    //签名	sign	是	微信返回的签名值，详见签名算法
    @XmlJavaTypeAdapter(value = CDATAAdapter.class)
    @XmlElement(name = "sign")
    private String sign;
    //业务结果	result_code SUCCESS/FAIL
    @XmlElement(name = "result_code")
    @XmlJavaTypeAdapter(value = CDATAAdapter.class)
    private String resultCode;
    //错误代码	err_code SYSTEMERROR	详细参见下文错误列表
    @XmlJavaTypeAdapter(value = CDATAAdapter.class)
    @XmlElement(name = "err_code")
    private String errCode;
    //错误代码描述	err_code_des 系统错误	错误信息描述
    @XmlJavaTypeAdapter(value = CDATAAdapter.class)
    @XmlElement(name = "err_code_des")
    private String errCodeDes;

    //以下字段在return_code为SUCCESS的时候有返回 结束


    //以下字段在return_code 和result_code都为SUCCESS的时候有返回 开始


    //交易类型	trade_type JSAPI	交易类型，取值为：JSAPI，NATIVE，APP等，说明详见参数规定
    @XmlJavaTypeAdapter(value = CDATAAdapter.class)
    @XmlElement(name = "trade_type")
    private String tradeType;
    //预支付交易会话标识	prepay_id 微信生成的预支付回话标识，用于后续接口调用中使用，该值有效期为2小时
    @XmlJavaTypeAdapter(value = CDATAAdapter.class)
    @XmlElement(name = "prepay_id")
    private String prepayId;
    //二维码链接	code_url trade_type为NATIVE时有返回，用于生成二维码，展示给用户进行扫码支付
    @XmlJavaTypeAdapter(value = CDATAAdapter.class)
    @XmlElement(name = "code_url")
    private String codeUrl;

    //以下字段在return_code 和result_code都为SUCCESS的时候有返回 结束


    public String getReturnCode() {
        return returnCode;
    }

    public WXPayBaseResult setReturnCode(String returnCode) {
        this.returnCode = returnCode;
        return this;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public WXPayBaseResult setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
        return this;
    }

    public String getAppid() {
        return appid;
    }

    public WXPayBaseResult setAppid(String appid) {
        this.appid = appid;
        return this;
    }

    public String getMchId() {
        return mchId;
    }

    public WXPayBaseResult setMchId(String mchId) {
        this.mchId = mchId;
        return this;
    }

    public String getDeviceInfo() {
        return deviceInfo;
    }

    public WXPayBaseResult setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo;
        return this;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public WXPayBaseResult setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
        return this;
    }

    public String getSign() {
        return sign;
    }

    public WXPayBaseResult setSign(String sign) {
        this.sign = sign;
        return this;
    }

    public String getResultCode() {
        return resultCode;
    }

    public WXPayBaseResult setResultCode(String resultCode) {
        this.resultCode = resultCode;
        return this;
    }

    public String getErrCode() {
        return errCode;
    }

    public WXPayBaseResult setErrCode(String errCode) {
        this.errCode = errCode;
        return this;
    }

    public String getErrCodeDes() {
        return errCodeDes;
    }

    public WXPayBaseResult setErrCodeDes(String errCodeDes) {
        this.errCodeDes = errCodeDes;
        return this;
    }

    public String getTradeType() {
        return tradeType;
    }

    public WXPayBaseResult setTradeType(String tradeType) {
        this.tradeType = tradeType;
        return this;
    }

    public String getPrepayId() {
        return prepayId;
    }

    public WXPayBaseResult setPrepayId(String prepayId) {
        this.prepayId = prepayId;
        return this;
    }

    public String getCodeUrl() {
        return codeUrl;
    }

    public WXPayBaseResult setCodeUrl(String codeUrl) {
        this.codeUrl = codeUrl;
        return this;
    }

    @Override
    public String toString() {
        return "WXPayBaseResult{" +
                "returnCode='" + returnCode + '\'' +
                ", returnMsg='" + returnMsg + '\'' +
                ", appid='" + appid + '\'' +
                ", mchId='" + mchId + '\'' +
                ", deviceInfo='" + deviceInfo + '\'' +
                ", nonceStr='" + nonceStr + '\'' +
                ", sign='" + sign + '\'' +
                ", resultCode='" + resultCode + '\'' +
                ", errCode='" + errCode + '\'' +
                ", errCodeDes='" + errCodeDes + '\'' +
                ", tradeType='" + tradeType + '\'' +
                ", prepayId='" + prepayId + '\'' +
                ", codeUrl='" + codeUrl + '\'' +
                '}';
    }
}
