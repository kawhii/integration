package com.carl.breakfast.web.ctrl.admin;

import com.carl.breakfast.dao.admin.statistics.OrderStatistics;
import com.carl.breakfast.web.service.IStatisticsService;
import com.carl.framework.core.functional.WriterException;
import com.carl.framework.core.pio.ExportRealInfo;
import com.carl.framework.core.pio.IniExportInfoExtractor;
import com.carl.framework.ui.ctrl.BaseCtrl;
import com.carl.framework.util.Excel;
import com.carl.framework.util.MapBuilder;
import com.carl.framework.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 统计控制器
 *
 * @author Carl
 * @date 2017/1/11
 * 版权所有.(c)2017 - 2020. 卡尔工作室
 */
@Controller
@RequestMapping("/admin/statistics")
public class StatisticsCtrl extends BaseCtrl {
    @Autowired
    private IStatisticsService statisticsService;

    @RequestMapping("/exportOrder")
    public void exportOrder(
            @RequestParam(required = false, value = "unitCode") String unitCode,
            @RequestParam(required = false, value = "createTime") String createTime,
            @RequestParam(required = false, value = "unitName") String unitName,
            HttpServletResponse response
    ) {
        //为空默认当天
        if (StringUtil.isNull(createTime)) {
            SimpleDateFormat dateFm = new SimpleDateFormat("yyyy-MM-dd");
            createTime = dateFm.format(new Date());
        }

        List<OrderStatistics> data = statisticsService.queryOrder(
                MapBuilder.<String, Object>build()
                        .p("unitCode", unitCode)
                        .p("createTime", createTime)
        );

        //问号名字
        String fileName;

        //空导出名字格式
        if (StringUtil.isNull(unitCode)) {
            fileName = "订单统计-" + createTime;
        } else {
            //栋名订单统计-时间
            fileName = unitName + "-订单统计-" + createTime;
        }

        try {
            String finalFileName = fileName;
            Excel.export2Response(statisticsService.convertOrder2Map(data),  () ->  {
                IniExportInfoExtractor infoExtractor = new IniExportInfoExtractor("classpath:export/orders.ini");
                ExportRealInfo realInfo = infoExtractor.extract("order");
                realInfo.setFileName(finalFileName);
                return realInfo;
            }, response);
            //TODO 异常处理
        } catch (WriterException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @Override
    protected String getModuleName() {
        return "admin/statistics";
    }
}
