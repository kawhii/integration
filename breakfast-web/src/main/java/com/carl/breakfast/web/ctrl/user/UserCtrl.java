package com.carl.breakfast.web.ctrl.user;

import com.carl.framework.ui.ctrl.BaseCtrl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 用户控制器
 * @author Carl
 * @date 2017/1/30
 * @since JDK1.7
 * <p>
 * 版权所有.(c)2008-2017.卡尔工作室
 */
@Controller("/user")
public class UserCtrl extends BaseCtrl {
    @Override
    protected String getModuleName() {
        return "user";
    }

    @RequestMapping("/address")
    public ModelAndView address() {
        ModelAndView view = new ModelAndView("address");

        return null;
    }
}
