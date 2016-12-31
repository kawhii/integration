package com.carl.breakfast.web.ctrl.user;

import com.carl.framework.ui.ctrl.BaseCtrl;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

/**
 * 注册页面
 * @author Carl
 * @date 2016/12/31
 * 版权所有.(c)2016 - 2020. 卡尔工作室
 */
@Controller
@RequestMapping("/u")
public class RegCtrl extends BaseCtrl {

    @Override
    protected String getModuleName() {
        return "user";
    }

    /**
     * 主要转发freemarker
     * @return
     */
    @RequestMapping(value = "/reg.html", method = RequestMethod.GET)
    public Object regPage() {
        return freemarker("reg");
    }
}
