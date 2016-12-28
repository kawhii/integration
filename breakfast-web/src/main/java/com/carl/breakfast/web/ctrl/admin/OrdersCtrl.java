package com.carl.breakfast.web.ctrl.admin;

import com.carl.framework.core.functional.IWriter;
import com.carl.framework.core.functional.WriterException;
import com.carl.framework.core.pio.IniExportInfoExtractor;
import com.carl.framework.core.pio.RequestExcelWriter;
import com.carl.framework.ui.ctrl.BaseCtrl;
import com.carl.framework.util.Excel;
import com.carl.framework.util.MapBuilder;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 订单服务
 *
 * @author Carl
 * @date 2016/12/28
 * 版权所有.(c)2016 - 2020. 卡尔工作室
 */
@Controller
@RequestMapping("/admin/orders")
public class OrdersCtrl extends BaseCtrl {
    @Override
    protected String getModuleName() {
        return "admin/orders";
    }

    //成交量导出
    @RequestMapping("/exportVolume.xls")
    public void exportVolume(HttpServletResponse response) {
        List<Map<String, Object>> data = Arrays.asList(
                MapBuilder.<String, Object>build().p("name", "wangwu").p("age", 1),
                MapBuilder.<String, Object>build().p("name", "zhaol").p("age", 2),
                MapBuilder.<String, Object>build().p("name", "zhouqi").p("age", 3)
        );
        try {
            Excel.export2Response4Ini(data, "classpath:export/orders.ini", "exportVolume", response);
        } catch (WriterException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
