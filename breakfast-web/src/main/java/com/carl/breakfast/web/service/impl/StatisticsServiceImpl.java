package com.carl.breakfast.web.service.impl;

import com.carl.breakfast.dao.admin.statistics.OrderStatistics;
import com.carl.breakfast.dao.admin.statistics.StatisticsOrderDao;
import com.carl.breakfast.web.service.IStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author Carl
 * @date 2017/1/10
 * 版权所有.(c)2017 - 2020. 卡尔工作室
 */
@Service
public class StatisticsServiceImpl implements IStatisticsService {
    @Autowired
    private StatisticsOrderDao statisticsOrderDao;

    @Override
    public List<OrderStatistics> queryOrder(Map<String, Object> paramMap) {
        return statisticsOrderDao.listBy(paramMap);
    }

    @Override
    public List<Map<String, Object>> convertOrder2Map(List<OrderStatistics> orderStatistics) {
        return null;
    }
}
