package com.carl.framework.core.pay;

/**
 * 支付请求
 *
 * @author Carl
 * @date 2017/2/5
 * 版权所有.(c)2017 - 2020. 卡尔工作室
 */
public interface IPayRequester<P extends AbsRequestParam, R> {
    /**
     * 请求
     *
     * @param resultType 结果返回类型
     * @return
     */
    R request(P p, Class<R> resultType) throws RequestException ;
}
