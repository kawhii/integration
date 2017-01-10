package com.carl.breakfast.web.service;

import com.carl.breakfast.dao.admin.statistics.OrderStatistics;

import java.util.List;
import java.util.Map;

/**
 * 分析服务
 *
 * @author Carl
 * @date 2017/1/10
 * 版权所有.(c)2017 - 2020. 卡尔工作室
 */
public interface IStatisticsService {
    /**
     * 查询订单统计
     *
     * @param paramMap
     * @return
     */
    List<OrderStatistics> queryOrder(Map<String, Object> paramMap);

    /**
     * 转换数据去map
     * @param orderStatistics
     * @return
     */
    List<Map<String, Object>> convertOrder2Map(List<OrderStatistics> orderStatistics);

}
