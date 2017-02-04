package com.carl.framework.core.pay;

/**
 * 支付接口
 *
 * @param <T> 支付返回结果
 * @author Carl
 * @date 2017/2/4
 * 版权所有.(c)2017 - 2020. 卡尔工作室
 */
public interface IPay<T extends PayResult> {
    /**
     * 是否支持该支付参数
     *
     * @param paramClz
     * @return
     */
    boolean support(Class<? extends PayParam> paramClz);

    /**
     * 支付编码
     *
     * @return
     */
    String code();

    /**
     * 支付名称
     *
     * @return
     */
    String name();


    /**
     * 支付执行逻辑
     *
     * @param param 支付参数
     * @return
     * @throws PayException
     */
    T pay(PayParam param) throws PayException;
}
