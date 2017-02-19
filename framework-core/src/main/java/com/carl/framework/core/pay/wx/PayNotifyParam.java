package com.carl.framework.core.pay.wx;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Carl
 * @date 2017/2/19
 * 版权所有.(c)2017 - 2020. 卡尔工作室
 */
@XmlRootElement(name = "xml")
public class PayNotifyParam extends WXPayBaseResult {
    //签名类型	sign_type HMAC-SHA256	签名类型，默认为MD5，支持HMAC-SHA256和MD5。
    @XmlElement(name = "sign_type")
    // = "MD5"
    private String signType;

    @XmlElement(name = "openid")
    // = "openid" 用户在商户appid下的唯一标识
    private String openid;

    @XmlElement(name = "is_subscribe")
    //用户是否关注公众账号，Y-关注，N-未关注，仅在公众账号类型支付有效
    private String isSubscribe;

    @XmlElement(name = "bank_type")
    //银行类型，采用字符串类型的银行标识，银行类型见银行列表
    private String bankType;

    @XmlElement(name = "total_fee")
    //订单总金额，单位为分
    private int total_fee;

    @XmlElement(name = "settlement_total_fee")
    //应结订单金额=订单金额-非充值代金券金额，应结订单金额<=订单金额。
    private int settlementTotalFee;

    @XmlElement(name = "fee_type")
    //货币类型，符合ISO4217标准的三位字母代码，默认人民币：CNY，其他值列表详见货币类型
    private String feeType;

    @XmlElement(name = "cash_fee")
    //现金支付金额订单现金支付金额，详见支付金额
    private int cashFee;

    @XmlElement(name = "cash_fee_type")
    //货币类型，符合ISO4217标准的三位字母代码，默认人民币：CNY，其他值列表详见货币类型
    private String cashFeeType;

    @XmlElement(name = "coupon_fee")
    //代金券金额<=订单金额，订单金额-代金券金额=现金支付金额，详见支付金额
    private int couponFee;

    @XmlElement(name = "coupon_count")
    //代金券使用数量
    private int couponCount;

    @XmlElement(name = "coupon_type_$n")
    //CASH--充值代金券
//    NO_CASH---非充值代金券
//    订单使用代金券时有返回（取值：CASH、NO_CASH）。$n为下标,从0开始编号，举例：coupon_type_0
    private int couponType$n;

    @XmlElement(name = "coupon_id_$n")
    //代金券ID,$n为下标，从0开始编号
    private String couponId$n;


    @XmlElement(name = "transaction_id")
    //微信支付订单号
    private String transactionId;

    @XmlElement(name = "out_trade_no")
    //商户系统的订单号，与请求一致。
    private String outTradeNo;

    @XmlElement(name = "attach")
    //商家数据包，原样返回
    private String attach;

    @XmlElement(name = "time_end")
    //支付完成时间，格式为yyyyMMddHHmmss，如2009年12月25日9点10分10秒表示为20091225091010。其他详见时间规则
    private String timeEnd;

    public String getSignType() {
        return signType;
    }

    public PayNotifyParam setSignType(String signType) {
        this.signType = signType;
        return this;
    }

    public String getOpenid() {
        return openid;
    }

    public PayNotifyParam setOpenid(String openid) {
        this.openid = openid;
        return this;
    }

    public String getIsSubscribe() {
        return isSubscribe;
    }

    public PayNotifyParam setIsSubscribe(String isSubscribe) {
        this.isSubscribe = isSubscribe;
        return this;
    }

    public String getBankType() {
        return bankType;
    }

    public PayNotifyParam setBankType(String bankType) {
        this.bankType = bankType;
        return this;
    }

    public int getTotal_fee() {
        return total_fee;
    }

    public PayNotifyParam setTotal_fee(int total_fee) {
        this.total_fee = total_fee;
        return this;
    }

    public int getSettlementTotalFee() {
        return settlementTotalFee;
    }

    public PayNotifyParam setSettlementTotalFee(int settlementTotalFee) {
        this.settlementTotalFee = settlementTotalFee;
        return this;
    }

    public String getFeeType() {
        return feeType;
    }

    public PayNotifyParam setFeeType(String feeType) {
        this.feeType = feeType;
        return this;
    }

    public int getCashFee() {
        return cashFee;
    }

    public PayNotifyParam setCashFee(int cashFee) {
        this.cashFee = cashFee;
        return this;
    }

    public String getCashFeeType() {
        return cashFeeType;
    }

    public PayNotifyParam setCashFeeType(String cashFeeType) {
        this.cashFeeType = cashFeeType;
        return this;
    }

    public int getCouponFee() {
        return couponFee;
    }

    public PayNotifyParam setCouponFee(int couponFee) {
        this.couponFee = couponFee;
        return this;
    }

    public int getCouponCount() {
        return couponCount;
    }

    public PayNotifyParam setCouponCount(int couponCount) {
        this.couponCount = couponCount;
        return this;
    }

    public int getCouponType$n() {
        return couponType$n;
    }

    public PayNotifyParam setCouponType$n(int couponType$n) {
        this.couponType$n = couponType$n;
        return this;
    }

    public String getCouponId$n() {
        return couponId$n;
    }

    public PayNotifyParam setCouponId$n(String couponId$n) {
        this.couponId$n = couponId$n;
        return this;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public PayNotifyParam setTransactionId(String transactionId) {
        this.transactionId = transactionId;
        return this;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public PayNotifyParam setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
        return this;
    }

    public String getAttach() {
        return attach;
    }

    public PayNotifyParam setAttach(String attach) {
        this.attach = attach;
        return this;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public PayNotifyParam setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
        return this;
    }
}
