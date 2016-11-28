package com.carl.breakfast.web.ctrl.sys.service.impl;

import com.carl.breakfast.dao.DaoException;
import com.carl.breakfast.dao.sys.SysFileDao;
import com.carl.breakfast.dao.sys.pojo.SysFile;
import com.carl.breakfast.web.ctrl.sys.service.SysFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 系统文件服务
 * @author Carl
 * @date 2016/11/28
 * © 2016 - 2020 , all rights reserved .卡尔工作室
 */
@Service("sysFileService")
public class SysFileServiceImpl implements SysFileService {
    @Autowired
    private SysFileDao sysFileDao;

    public SysFileDao getDao() {
        return sysFileDao;
    }

    public int save(SysFile file) throws DaoException {
        return sysFileDao.save(file);
    }

    public SysFile findById(int id) throws DaoException {
        return sysFileDao.findById(id);
    }
}
