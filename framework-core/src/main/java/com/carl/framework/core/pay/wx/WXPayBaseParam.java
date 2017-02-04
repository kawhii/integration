package com.carl.framework.core.pay.wx;

import com.carl.framework.core.pay.PayParam;

/**
 * 微信支撑基础参数
 *
 * @author Carl
 * @date 2017/2/4
 * 版权所有.(c)2017 - 2020. 卡尔工作室
 */
public abstract class WXPayBaseParam implements PayParam {
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
    //商品详情	detail
    /**
     * 商品详细列表，使用Json格式，传输签名前请务必使用CDATA标签将JSON文本串保护起来。
     * cost_price Int 可选 32 订单原价，商户侧一张小票订单可能被分多次支付，订单原价用于记录整张小票的支付金额。当订单原价与支付金额不相等则被判定为拆单，无法享受优惠。
     * receipt_id String 可选 32 商家小票ID
     * goods_detail 服务商必填 []：
     * └ goods_id String 必填 32 商品的编号
     * └ wxpay_goods_id String 可选 32 微信支付定义的统一商品编号
     * └ goods_name String 可选 256 商品名称
     * └ quantity Int 必填  32 商品数量
     * └ price Int 必填 32 商品单价，如果商户有优惠，需传输商户优惠后的单价
     * 注意：单品总金额应<=订单总金额total_fee，否则会无法享受优惠。
     */
    private String detail;

    //附加数据	attach 深圳分店	附加数据，在查询API和支付通知中原样返回，可作为自定义参数使用。
    private String attach;
    //商户订单号	out_trade_no 20150806125346	商户系统内部订单号，要求32个字符内、且在同一个商户号下唯一。 详见商户订单号
    private String outTradeNo;
    //标价币种	fee_type CNY	符合ISO 4217标准的三位字母代码，默认人民币：CNY，详细列表请参见货币类型
    private String fee_type = "CNY";

    //标价金额	total_fee 订单总金额，单位为分，详见支付金额
    private int totalFee;
    //终端IP	spbill_create_ip 123.12.12.123	APP和网页支付提交用户端ip，Native支付填调用微信支付API的机器IP。
    private String spbillCreateIp;

    //交易起始时间	time_start 20091225091010	订单生成时间，格式为yyyyMMddHHmmss，如2009年12月25日9点10分10秒表示为20091225091010。其他详见时间规则

    private String timeStart;

    //交易结束时间 time_expire 20091227091010 订单失效时间，格式为yyyyMMddHHmmss，如2009年12月27日9点10分10秒表示为20091227091010。其他详见时间规则注意：最短失效时间间隔必须大于5分钟
    private String timeExpire;

    //商品标记	goods_tag WXG	商品标记，使用代金券或立减优惠功能时需要的参数，说明详见代金券或立减优惠
    private String goodsTag;

    //通知地址	notify_url http://www.weixin.qq.com/wxpay/pay.php	异步接收微信支付结果通知的回调地址，通知url必须为外网可访问的url，不能携带参数。
    private String notifyUrl;

    //交易类型	trade_type 取值如下：JSAPI，NATIVE，APP等，说明详见参数规定
    private String tradeType;
    //商品ID	product_id 12235413214070356458058	trade_type=NATIVE时（即扫码支付），此参数必传。此参数为二维码中包含的商品ID，商户自行定义。
    private String productId;
    //指定支付方式	limit_pay no_credit	上传此参数no_credit--可限制用户不能使用信用卡支付
    private String limitPay;
    //用户标识	openid oUpF8uMuAJO_M2pxb1Q9zNjWeS6o	trade_type=JSAPI时（即公众号支付），此参数必传，此参数为微信用户在商户对应appid下的唯一标识。openid如何获取，可参考【获取openid】。企业号请使用【企业号OAuth2.0接口】获取企业号内成员userid，再调用【企业号userid转openid接口】进行转换
    private String openid;

    public String getAppid() {
        return appid;
    }

    public WXPayBaseParam setAppid(String appid) {
        this.appid = appid;
        return this;
    }

    public String getMchId() {
        return mchId;
    }

    public WXPayBaseParam setMchId(String mchId) {
        this.mchId = mchId;
        return this;
    }

    public String getDeviceInfo() {
        return deviceInfo;
    }

    public WXPayBaseParam setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo;
        return this;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public WXPayBaseParam setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
        return this;
    }

    public String getSign() {
        return sign;
    }

    public WXPayBaseParam setSign(String sign) {
        this.sign = sign;
        return this;
    }

    public String getSignType() {
        return signType;
    }

    public WXPayBaseParam setSignType(String signType) {
        this.signType = signType;
        return this;
    }

    public String getBody() {
        return body;
    }

    public WXPayBaseParam setBody(String body) {
        this.body = body;
        return this;
    }

    public String getDetail() {
        return detail;
    }

    public WXPayBaseParam setDetail(String detail) {
        this.detail = detail;
        return this;
    }

    public String getAttach() {
        return attach;
    }

    public WXPayBaseParam setAttach(String attach) {
        this.attach = attach;
        return this;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public WXPayBaseParam setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
        return this;
    }

    public String getFee_type() {
        return fee_type;
    }

    public WXPayBaseParam setFee_type(String fee_type) {
        this.fee_type = fee_type;
        return this;
    }

    public int getTotalFee() {
        return totalFee;
    }

    public WXPayBaseParam setTotalFee(int totalFee) {
        this.totalFee = totalFee;
        return this;
    }

    public String getSpbillCreateIp() {
        return spbillCreateIp;
    }

    public WXPayBaseParam setSpbillCreateIp(String spbillCreateIp) {
        this.spbillCreateIp = spbillCreateIp;
        return this;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public WXPayBaseParam setTimeStart(String timeStart) {
        this.timeStart = timeStart;
        return this;
    }

    public String getTimeExpire() {
        return timeExpire;
    }

    public WXPayBaseParam setTimeExpire(String timeExpire) {
        this.timeExpire = timeExpire;
        return this;
    }

    public String getGoodsTag() {
        return goodsTag;
    }

    public WXPayBaseParam setGoodsTag(String goodsTag) {
        this.goodsTag = goodsTag;
        return this;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public WXPayBaseParam setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
        return this;
    }

    public String getTradeType() {
        return tradeType;
    }

    public WXPayBaseParam setTradeType(String tradeType) {
        this.tradeType = tradeType;
        return this;
    }

    public String getProductId() {
        return productId;
    }

    public WXPayBaseParam setProductId(String productId) {
        this.productId = productId;
        return this;
    }

    public String getLimitPay() {
        return limitPay;
    }

    public WXPayBaseParam setLimitPay(String limitPay) {
        this.limitPay = limitPay;
        return this;
    }

    public String getOpenid() {
        return openid;
    }

    public WXPayBaseParam setOpenid(String openid) {
        this.openid = openid;
        return this;
    }
}
