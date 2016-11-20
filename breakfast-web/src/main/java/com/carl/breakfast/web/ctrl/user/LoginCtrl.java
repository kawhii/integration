package com.carl.breakfast.web.ctrl.user;

import com.carl.framework.ui.ctrl.BaseCtrl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Carl
 * @date 2016/11/20
 */
@Controller
@RequestMapping("/u")
public class LoginCtrl extends BaseCtrl {
    @Override
    protected String getModuleName() {
        return "user";
    }

    /**
     * 主要转发freemarker
     * @return
     */
    @RequestMapping(value = "/login")
    public String login() {
        return freemarker("login");
    }

    @RequestMapping(value = "/test")
    public String mainContent() {
        return freemarker("test");
    }
}
