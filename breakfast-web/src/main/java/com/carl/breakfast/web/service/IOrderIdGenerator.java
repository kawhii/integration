package com.carl.breakfast.web.service;

/**
 * 订单号生成器
 *
 * @author Carl
 * @date 2017/2/9
 * 版权所有.(c)2017 - 2020. 卡尔工作室
 */
public interface IOrderIdGenerator {
    /**
     * 生成id
     * @return
     */
    String create();
}
