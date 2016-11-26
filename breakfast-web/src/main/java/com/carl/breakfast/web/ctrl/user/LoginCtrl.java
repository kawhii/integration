package com.carl.breakfast.web.ctrl.user;

import com.carl.framework.ui.ctrl.BaseCtrl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.SubjectContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

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
    public Object login(@Value("${url.index}") String indexUrl) {
        if(SecurityUtils.getSubject().isAuthenticated()) {
            return new ModelAndView(new RedirectView(indexUrl));
        }
        return freemarker("login");
    }

    @RequestMapping(value = "/test")
    public String mainContent() {
        return freemarker("test");
    }
}
