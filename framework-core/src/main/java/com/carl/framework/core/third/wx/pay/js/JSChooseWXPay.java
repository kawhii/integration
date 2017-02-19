package com.carl.framework.core.third.wx.pay.js;

import com.carl.framework.core.pay.crypto.CryptoException;
import com.carl.framework.core.pay.wx.MD5Crypto;
import com.carl.framework.util.MapBuilder;
import com.carl.framework.util.UUID;

import java.util.Date;

/**
 * js权限校验
 *
 * @author Carl
 * @date 2017/2/19
 * 版权所有.(c)2017 - 2020. 卡尔工作室
 */
public class JSChooseWXPay {
    private String appid;
    private int timestamp;
    private String nonceStr;
    private String packageStr;
    private String signType = "MD5";
    private String paySign;

    public String getAppid() {
        return appid;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public String getPackageStr() {
        return packageStr;
    }

    public String getSignType() {
        return signType;
    }

    public String getPaySign() {
        return paySign;
    }

    public JSChooseWXPay(String appid, int timestamp, String nonceStr, String packageStr, String signType, String paySign) {
        this.appid = appid;
        this.timestamp = timestamp;
        this.nonceStr = nonceStr;
        this.packageStr = packageStr;
        this.signType = signType;
        this.paySign = paySign;
    }

    public static class Builder {
        private String nonceStr = UUID.get();
        private int timestamp = Math.toIntExact(new Date().getTime() / 1000);
        private String packageSrt;
        private MD5Crypto signType = new MD5Crypto();
        //支付秘钥
        private String key;
        private String appId;

        public Builder setNonceStr(String nonceStr) {
            this.nonceStr = nonceStr;
            return this;
        }

        public Builder setTimestamp(int timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder setPackageSrt(String packageSrt) {
            this.packageSrt = packageSrt;
            return this;
        }

        public Builder setSignType(MD5Crypto signType) {
            this.signType = signType;
            return this;
        }

        public Builder setKey(String key) {
            this.key = key;
            return this;
        }

        public Builder setAppId(String appId) {
            this.appId = appId;
            return this;
        }

        /**
         * 构建支付参数
         * @return
         * @throws CryptoException
         */
        public JSChooseWXPay build() throws CryptoException {
            String sign = signType.sign(
                    MapBuilder.<String, String>build()
                            .p("appId", appId)
                            .p("timeStamp", String.valueOf(timestamp))
                            .p("nonceStr", nonceStr)
                            .p("package", packageSrt)
                            .p("signType", signType.name()),
                    key);
            return new JSChooseWXPay(appId, timestamp, nonceStr, packageSrt, signType.name(), sign);
        }
    }
}
