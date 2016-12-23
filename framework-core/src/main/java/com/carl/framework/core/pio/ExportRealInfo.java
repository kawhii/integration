package com.carl.framework.core.pio;


/**
 * 数据导出关系类，用于导出数据的时候，根据数据的key获取对应的列明，进行展示在xls上的头
 *
 * @author Carl
 * @date 2016/12/24
 * 版权所有.(c)2016 - 2020. 卡尔工作室
 */
public class ExportRealInfo {
    //导出文件名
    private String fileName;
    //列名
    private String[] columnName;
    //xls头部名
    private String[] headerName;

    public String getFileName() {
        return fileName;
    }

    public ExportRealInfo setFileName(String fileName) {
        this.fileName = fileName;
        return this;
    }

    public String[] getColumnName() {
        return columnName;
    }

    public ExportRealInfo setColumnName(String[] columnName) {
        this.columnName = columnName;
        return this;
    }

    public String[] getHeaderName() {
        return headerName;
    }

    public ExportRealInfo setHeaderName(String[] headerName) {
        this.headerName = headerName;
        return this;
    }
}
