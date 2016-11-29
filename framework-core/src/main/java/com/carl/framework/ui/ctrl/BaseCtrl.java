package com.carl.framework.ui.ctrl;


import com.carl.framework.util.MapBuilder;

/**
 * 基础控制器
 *
 * @author Carl
 * @date 2016/3/27
 * @modify 版权所有.(c)2008-2016.广州市森锐电子科技有限公司
 */
public abstract class BaseCtrl {
    /**
     * jsp 文件
     */
    protected final String JSP = "jsp";
    /**
     * 静态模板
     */
    protected final String THYMELEAFE = "thymeleafe";

    /**
     * freemarker 静态模板
     */
    protected final String FREEMARKER = "freemarker";

    /**
     * 文件
     */
    protected final String SEPARATOR = "/";

    /**
     * 获取模块名字
     *
     * @return
     */
    protected abstract String getModuleName();


    /**
     * 获取包装好的模块名
     *
     * @return
     */
    protected String getWarpModuleName() {
        return SEPARATOR + getModuleName() + SEPARATOR;
    }

    protected String freemarker(String templateUrl) {
        return FREEMARKER + getWarpModuleName() + templateUrl;
    }

    /**
     * 成功时返回
     *
     * @param body
     * @return
     */
    protected MapBuilder<String, Object> success(Object... body) {
        MapBuilder<String, Object> data = MapBuilder.build();
        data.put("header", MapBuilder.build().p("code", 0));
        data.put("body", body != null && body.length == 1 ? body[0] : body);
        return data;
    }

    /**
     * 失败时返回
     *
     * @param message
     * @return
     */
    protected MapBuilder<String, Object> fail(String message) {
        MapBuilder<String, Object> data = MapBuilder.build();
        data.put("header", MapBuilder.build().p("code", -1).p("message", message));
        return data;
    }
}
