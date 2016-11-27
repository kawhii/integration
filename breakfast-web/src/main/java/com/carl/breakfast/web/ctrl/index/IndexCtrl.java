package com.carl.breakfast.web.ctrl.index;

import com.carl.framework.ui.ctrl.BaseCtrl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

/**
 * @author Carl
 * @date 2016/11/19
 */
@Controller
@RequestMapping("/")
public class IndexCtrl extends BaseCtrl {
    @Override
    protected String getModuleName() {
        return "index";
    }

    /**
     * 主要转发freemarker
     *
     * @return
     */
    @RequestMapping(value = "/index.html", method = {RequestMethod.GET})
    public ModelAndView mainContent(@Value("${url.admin.index}") String adminIndexUrl)

    {
        //// TODO: 2016/11/27 区分是管理员还是游客
        return new ModelAndView(new RedirectView(adminIndexUrl));
//        return freemarker("index");
    }
}
