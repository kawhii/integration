package com.carl.breakfast.web.ctrl.admin;

import com.carl.framework.ui.ctrl.BaseCtrl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 商品管理
 *
 * @author Carl
 * @date 2016/11/28
 * © 2016 - 2020 , all rights reserved .卡尔工作室
 */
@Controller
@RequestMapping("/admin/goods")
public class GoodsManagerCtrl extends BaseCtrl {

    protected String getModuleName() {
        return "admin/goods";
    }

    //首页
    @RequestMapping("/index.html")
    public String index() {
        return freemarker("index");
    }
}