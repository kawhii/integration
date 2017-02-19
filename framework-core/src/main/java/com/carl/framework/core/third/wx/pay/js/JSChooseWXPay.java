package com.carl.framework.core.third.wx.pay.js;

import com.carl.framework.core.pay.crypto.CryptoException;
import com.carl.framework.util.MapBuilder;

/**
 * @author Carl
 * @date 2017/2/19
 * 版权所有.(c)2017 - 2020. 卡尔工作室
 */
public class JSChooseWXPay {
    private int timestamp;
    private String noncestr;
    private String packageStr;
    private String signType = "SHA1";
    private String paySign;

    private JSChooseWXPay(int timestamp, String noncestr, String packageStr, String signType, String paySign) {
        this.timestamp = timestamp;
        this.noncestr = noncestr;
        this.packageStr = packageStr;
        this.signType = signType;
        this.paySign = paySign;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public String getNoncestr() {
        return noncestr;
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

    public static class Builder {
        private String noncestr;
        private String jsapiTicket;
        private int timestamp;
        private String url;
        private String packageSrt;
        private JSTicketCrypto signType = new JSSha1TicketCrypto();

        public Builder setNoncestr(String noncestr) {
            this.noncestr = noncestr;
            return this;
        }

        public Builder setJsapiTicket(String jsapiTicket) {
            this.jsapiTicket = jsapiTicket;
            return this;
        }

        public Builder setTimestamp(int timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder setUrl(String url) {
            this.url = url;
            return this;
        }

        public Builder setPackageSrt(String packageSrt) {
            this.packageSrt = packageSrt;
            return this;
        }

        public Builder setSignType(JSTicketCrypto signType) {
            this.signType = signType;
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
                            .p("timestamp", String.valueOf(timestamp))
                            .p("noncestr", noncestr)
                            .p("jsapi_ticket", jsapiTicket)
                            .p("url", url),
                    null);
            return new JSChooseWXPay(timestamp, noncestr, packageSrt, signType.signType().name(), sign);
        }
    }
}
