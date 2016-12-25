package com.carl.framework.core.pio;

import com.carl.framework.util.MapBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/25.
 */
public class DefaultExcelExportorTest {

    @Test
    public void test() throws Exception {
        DefaultExcelExportor exportor = new DefaultExcelExportor();
        List<Map<String, Object>> data = new ArrayList<>();
        data.add(MapBuilder.<String, Object>build().p("name", "carl").p("age", 22));
        data.add(MapBuilder.<String, Object>build().p("name", "sunrise").p("age", 5));


        ExportRealInfo mapper = new ExportRealInfo();
        mapper.setFileName("text.xls");
        mapper.setColumnName(new String[]{"name", "age"});
        mapper.setHeaderName(new String[]{"名字", "年龄"});

        File file = new File("D://test.xls");
        FileOutputStream outputStream = new FileOutputStream(file);

        exportor.export(data, mapper, outputStream);
        Assert.assertTrue(file.exists());
    }

}