package com.carl.breakfast.web.ctrl.admin;

import com.carl.framework.ui.ctrl.BaseCtrl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

    protected String getModuleName() {
        return "admin";
    }

    //首页
    @RequestMapping("/index.html")
    public String index() {
        return freemarker("index");
    }
}
