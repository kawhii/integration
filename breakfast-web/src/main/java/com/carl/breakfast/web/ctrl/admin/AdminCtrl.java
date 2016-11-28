package com.carl.breakfast.web.ctrl.admin;

import com.carl.framework.ui.ctrl.BaseCtrl;
import com.carl.framework.util.StringUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * 管理端
 *
 * @author Carl
 * @date 2016/11/27
 * © 2016 - 2020 , all rights reserved .卡尔工作室
 */
@Controller
@RequestMapping("/admin")
public class AdminCtrl extends BaseCtrl {

    @Value("${url.admin.default.url}")
    private String defaultUrl;
    @Value("${url.admin.index}")
    private String indexUrl;

    protected String getModuleName() {
        return "admin";
    }

    //首页
    @RequestMapping("/index.html")
    public ModelAndView index(@RequestParam(value = "p", required = false) String url) {
        if (StringUtil.isNull(url)) {
            url = defaultUrl;
        }
        //给予默认路径进行跳转
        Map<String, String> params = new HashMap<String, String>(1);
        params.put("url", url);
        //根据这个url来定位跳转父链接
        params.put("parentUrl", indexUrl.substring(indexUrl.lastIndexOf("/") + 1));
        return new ModelAndView(freemarker("index"), params);
    }
}
