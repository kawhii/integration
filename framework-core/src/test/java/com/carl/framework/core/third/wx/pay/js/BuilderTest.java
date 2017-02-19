package com.carl.framework.core.third.wx.pay.js;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/2/19.
 */
public class BuilderTest {
    @Test
    public void build() throws Exception {
        JSChooseWXPay.Builder builder = new JSChooseWXPay.Builder()
                .setJsapiTicket("sM4AOVdWfPE4DxkXGEs8VMCPGGVi4C3VM0P37wVUCFvkVAy_90u5h9nbSlYy3-Sl-HhTdfl2fzFy1AOcHKP7qg")
                .setNoncestr("Wm3WZYTPz0wzccnW")
                .setTimestamp(1414587457)
                .setUrl("http://mp.weixin.qq.com?params=value");

        JSChooseWXPay pay = builder.build();
        Assert.assertEquals("0f9de62fce790f9a083d5c99e95740ceb90c27ed", pay.getPaySign());
    }
}