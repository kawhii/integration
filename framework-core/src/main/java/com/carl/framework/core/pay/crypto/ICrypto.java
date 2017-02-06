package com.carl.framework.core.pay.crypto;

import java.util.Map;

/**
 * 加密算法，计算sign
 *
 * @author Carl
 * @date 2017/2/6
 * @since JDK1.7
 * <p>
 * 版权所有.(c)2008-2017.卡尔工作室
 */
public interface ICrypto {
    /**
     * 加密名称
     *
     * @return
     */
    String name();

    /**
     * 计算sign
     *
     * @param params
     * @return
     * @throws CryptoException
     */
    String sign(Map<String, String> params) throws CryptoException;
}
