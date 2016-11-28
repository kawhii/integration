package com.carl.breakfast.web.ctrl.sys;

import com.carl.breakfast.web.ctrl.sys.service.SysFileService;
import com.carl.framework.ui.ctrl.BaseCtrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * 系统文件
 *
 * @author Carl
 * @date 2016/11/28
 * © 2016 - 2020 , all rights reserved .卡尔工作室
 */
@Controller
@RequestMapping("/sys/file")
public class FileCtrl extends BaseCtrl {
    @Autowired
    private SysFileService sysFileService;

    protected String getModuleName() {
        return "sys/file";
    }

    @RequestMapping("/upload")
    public void upload(@RequestParam("file") MultipartFile file) {
        System.out.println(file);
    }
}
