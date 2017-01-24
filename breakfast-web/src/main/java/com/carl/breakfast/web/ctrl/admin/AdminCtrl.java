package com.carl.breakfast.web.ctrl.admin;

import com.carl.breakfast.web.service.IUserService;
import com.carl.breakfast.web.service.UsesModifyFlag;
import com.carl.framework.ui.ctrl.BaseCtrl;
import com.carl.framework.util.StringUtil;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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

    @Autowired
    private IUserService userService;

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

    @RequestMapping(value = "/modifyPwd.do", method = RequestMethod.POST)
    @ResponseBody
    public Object modifyPwd(@RequestBody ModifyPwdBean modifyPwdBean) {
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        UsesModifyFlag flag = userService.modifyPassword(username, modifyPwdBean.oldPwd, modifyPwdBean.newPwd);
        switch (flag) {
            case SUCCESS:
                return success();
            default:
                return fail("修改失败");
        }
    }

    public static class ModifyPwdBean {
        private String oldPwd;
        private String newPwd;

        public String getOldPwd() {
            return oldPwd;
        }

        public ModifyPwdBean setOldPwd(String oldPwd) {
            this.oldPwd = oldPwd;
            return this;
        }

        public String getNewPwd() {
            return newPwd;
        }

        public ModifyPwdBean setNewPwd(String newPwd) {
            this.newPwd = newPwd;
            return this;
        }
    }
}
