package com.carl.breakfast.web.service;

import com.carl.breakfast.dao.admin.statistics.OrderStatistics;
import com.carl.breakfast.dao.admin.statistics.SalesStatistics;
import com.carl.framework.core.page.PageBean;
import com.carl.framework.core.page.PageParam;

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
     * 查询销售量
     *
     * @param paramMap
     * @return
     */
    List<SalesStatistics> querySales(Map<String, Object> paramMap);


    /**
     * 转换数据去map
     *
     * @param orderStatistics
     * @return
     */
    List<Map<String, Object>> convertOrder2Map(List<OrderStatistics> orderStatistics);


    /**
     *  分页查询订单
     * @param pageParam
     * @param param
     * @return
     */
    PageBean<OrderStatistics> queryOrder(PageParam pageParam, Map<String, Object> param);
}
