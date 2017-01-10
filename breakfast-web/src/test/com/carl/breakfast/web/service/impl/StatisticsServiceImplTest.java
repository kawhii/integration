package com.carl.breakfast.web.service.impl;

import com.carl.breakfast.dao.admin.statistics.OrderStatistics;
import com.carl.breakfast.dao.sys.BaseTest;
import com.carl.breakfast.web.service.IStatisticsService;
import com.carl.framework.util.MapBuilder;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/1/10.
 */
public class StatisticsServiceImplTest extends BaseTest {
    @Autowired
    private IStatisticsService statisticsService;
    @Test
    public void queryOrder() throws Exception {
        List<OrderStatistics> list = statisticsService.queryOrder(MapBuilder.<String, Object>build());
        assertNull(list);
    }

}