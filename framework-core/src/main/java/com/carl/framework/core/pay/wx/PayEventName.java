package com.carl.framework.core.pay.wx;

/**
 * 微信回调路径的参数
 *
 * @author Carl
 * @date 2017/2/19
 * 版权所有.(c)2017 - 2020. 卡尔工作室
 */
public abstract class PayEventName {
    /**
     * 回调成功
     */
    public static final String ON_PAY_SUCCESS = "onWxPaySuccess";

    /**
     * 回调失败
     */
    public static final String ON_PAY_FAIL = "onWxPayFail";

    /**
     * 回调非法
     */
    public static final String ON_PAY_ILLEGAL = "onWxPayIllegal";
}
