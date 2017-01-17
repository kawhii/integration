package com.carl.breakfast.web.service.impl;

import com.carl.breakfast.dao.admin.statistics.OrderStatistics;
import com.carl.breakfast.dao.admin.statistics.SalesStatistics;
import com.carl.breakfast.dao.admin.statistics.StatisticsOrderDao;
import com.carl.breakfast.dao.admin.statistics.StatisticsSalesDao;
import com.carl.breakfast.web.service.IStatisticsService;
import com.carl.framework.util.MapBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

    @Autowired
    private StatisticsSalesDao statisticsSalesDao;

    private static SimpleDateFormat dateFm = new SimpleDateFormat("yyyy-MM-dd hh23:mm:ss");

    @Override
    public List<OrderStatistics> queryOrder(Map<String, Object> paramMap) {
        return statisticsOrderDao.listBy(paramMap);
    }

    @Override
    public List<SalesStatistics> querySales(Map<String, Object> paramMap) {
        return statisticsSalesDao.listBy(paramMap);
    }

    @Override
    public List<Map<String, Object>> convertOrder2Map(List<OrderStatistics> orderStatistics) {
        List<Map<String, Object>> data = new ArrayList<>();
        if(orderStatistics != null && orderStatistics.size() > 0) {
            for(OrderStatistics order : orderStatistics) {
                data.add(MapBuilder.<String, Object>build()
                        .p("orderId", order.getOrderId())
                        .p("floorCode", order.getFloorCode())
                        .p("unitCode", order.getUnitCode())
                        .p("floorName", order.getFloorName())
                        .p("unitName", order.getUnitName())
                        .p("address", order.getAddress())
                        .p("goodsInfo", order.getGoodsInfo())
                        .p("isImpatient", order.isImpatient() ? "是" : "否")
                        .p("totalPrice", order.getTotalPrice())
                        .p("createTime", dateFm.format(order.getCreateTime()))
                );
            }
        }
        return data;
    }
}
