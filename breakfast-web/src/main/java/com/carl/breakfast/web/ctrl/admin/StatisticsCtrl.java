package com.carl.breakfast.web.ctrl.admin;

import com.carl.breakfast.dao.admin.statistics.OrderStatistics;
import com.carl.breakfast.dao.admin.statistics.SalesStatistics;
import com.carl.breakfast.web.service.IStatisticsService;
import com.carl.framework.core.functional.WriterException;
import com.carl.framework.core.pio.ExportRealInfo;
import com.carl.framework.core.pio.IniExportInfoExtractor;
import com.carl.framework.ui.ctrl.BaseCtrl;
import com.carl.framework.util.BeanUtil;
import com.carl.framework.util.Excel;
import com.carl.framework.util.MapBuilder;
import com.carl.framework.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
            Excel.export2Response(statisticsService.convertOrder2Map(data), () -> {
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

    @RequestMapping("/order.json")
    @ResponseBody
    /**
     * unitCode 楼层编码
     * createTime 楼层编码
     */
    public Object order(@RequestParam(required = false, name = "unitCode") String unitCode,
                        @RequestParam(required = false, name = "createTime") String createTime) {
        //为空默认当天
        if (StringUtil.isNull(createTime)) {
            SimpleDateFormat dateFm = new SimpleDateFormat("yyyy-MM-dd");
            createTime = dateFm.format(new Date());
        }
        Object res = statisticsService.queryOrder(
                MapBuilder.<String, Object>build().p("unitCode", unitCode).p("createTime", createTime)
        );
        return success(res);
    }

    @RequestMapping("/sales.json")
    @ResponseBody
    /**
     * unitCode 楼层编码
     * createTime 楼层编码
     */
    public Object sales(@RequestParam(required = false, name = "unitCode") String unitCode,
                        @RequestParam(required = false, name = "startTime") String startTime,
                        @RequestParam(required = false, name = "endTime") String endTime,
                        @RequestParam(required = false, name = "codes", defaultValue = "") String codes
    ) {
        //为空默认当天
        if (StringUtil.isNull(endTime)) {
            SimpleDateFormat dateFm = new SimpleDateFormat("yyyy-MM-dd");
            endTime = dateFm.format(new Date());
        }
        String[] cs = codes.length() <= 0 ? new String[]{} : codes.split(",");
        Object res = statisticsService.querySales(
                MapBuilder.<String, Object>build().p("unitCode", unitCode).p("endTime", endTime).p("startTime", startTime).p("codes", cs.length > 0 ? cs : null)
        );
        return success(res);
    }

    @RequestMapping("/exportSales")
    public void exportSales(
            @RequestParam(required = false, name = "unitCode") String unitCode,
            @RequestParam(required = false, name = "unitName") String unitName,
            @RequestParam(required = false, name = "startTime") String startTime,
            @RequestParam(required = false, name = "endTime") String endTime,
            @RequestParam(required = false, name = "codes", defaultValue = "") String codes,
            HttpServletResponse response
    ) {
        //为空默认当天
        if (StringUtil.isNull(endTime)) {
            SimpleDateFormat dateFm = new SimpleDateFormat("yyyy-MM-dd");
            endTime = dateFm.format(new Date());
        }
        String[] cs = codes.length() <= 0 ? new String[]{} : codes.split(",");

        List<SalesStatistics> data = statisticsService.querySales(
                MapBuilder.<String, Object>build().p("unitCode", unitCode).p("endTime", endTime).p("startTime", startTime).p("codes", cs.length > 0 ? cs : null)
        );

        //问号名字
        String fileName;

        //空导出名字格式
        fileName = "销售统计-" + (StringUtil.isNull(unitName) ? "全部" : unitName) + "（" + startTime + "~" + endTime + "）";

        try {
            String finalFileName = fileName;
            List<Map<String, Object>> eData = new ArrayList<>();

            //转换

            for (SalesStatistics ss : data) {
                eData.add(BeanUtil.transBean2Map(ss));
            }

            Excel.export2Response(eData, () -> {
                IniExportInfoExtractor infoExtractor = new IniExportInfoExtractor("classpath:export/orders.ini");
                ExportRealInfo realInfo = infoExtractor.extract("sales");
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

    @Override
    protected String getModuleName() {
        return "admin/statistics";
    }
}
