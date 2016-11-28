package com.carl.breakfast.web.ctrl.sys;

import com.carl.breakfast.dao.DaoException;
import com.carl.breakfast.dao.sys.pojo.SysFile;
import com.carl.breakfast.web.ctrl.sys.service.SysFileService;
import com.carl.framework.core.file.DefaultFileSaveStrategy;
import com.carl.framework.core.file.FileSaveException;
import com.carl.framework.core.file.FileSaveStrategy;
import com.carl.framework.ui.ctrl.BaseCtrl;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

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
    @Qualifier("sysFileService") //注释指定注入 Bean
    private SysFileService sysFileService;

    private DefaultFileSaveStrategy defaultFileSaveStrategy = new DefaultFileSaveStrategy();

    protected String getModuleName() {
        return "sys/file";
    }

    @RequestMapping("/upload")
    @ResponseBody
    public Object upload(@RequestParam("file") MultipartFile file,
                         @RequestParam(value = "remark", required = false, defaultValue = "") String remark,
                         HttpServletRequest request
    ) {
        SysFile sysFile = new SysFile();
        sysFile.setFileSize(file.getSize());
        sysFile.setUploadName(file.getOriginalFilename());
        sysFile.setUploadIp(request.getRemoteAddr());
        sysFile.setRemark(remark);
        Object obj = SecurityUtils.getSubject().getPrincipal();
        sysFile.setUploadUser((String) obj);
        try {
            FileSaveStrategy.FileInfo info = defaultFileSaveStrategy.save(request.getRealPath("/"), file);
            sysFile.setVisitPath(info.getFilePath());
        } catch (FileSaveException e) {
            //TODO 异常捕捉
            e.printStackTrace();
        }
        try {
            sysFileService.save(sysFile);
        } catch (DaoException e) {
            //TODO 异常处理
            e.printStackTrace();
        }
        return new HashMap<String, String>();
    }
}
