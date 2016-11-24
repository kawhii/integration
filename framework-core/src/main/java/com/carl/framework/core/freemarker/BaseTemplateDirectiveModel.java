package com.carl.framework.core.freemarker;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

/**
 * 返回base路径
 *
 * @author Carl
 * @date 2016/11/24
 */
@Component("baseTemplateDirectiveModel")
public class BaseTemplateDirectiveModel implements TemplateDirectiveModel {
    private static String path = null;

    public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body)
            throws TemplateException, IOException {
        if (path == null) {

            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            String path = request.getContextPath();
            // 获得本项目的地址(例如: http://localhost:8080/MyApp/)赋值给basePath
            String basePath = request.getScheme() + "://" + request.getServerName()
                    + ":" + request.getServerPort() + path + "/";
            this.path = basePath;
        }

        env.getOut().write("<base href='" + path + "'/>");
    }
}
