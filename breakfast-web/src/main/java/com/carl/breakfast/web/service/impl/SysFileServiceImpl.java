package com.carl.breakfast.web.service.impl;

import com.carl.breakfast.dao.DaoException;
import com.carl.breakfast.dao.sys.SysFileDao;
import com.carl.breakfast.dao.sys.pojo.SysFile;
import com.carl.breakfast.web.service.SysFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 系统文件服务
 * @author Carl
 * @date 2016/11/28
 * © 2016 - 2020 , all rights reserved .卡尔工作室
 */
@Service("sysFileService")
@Transactional
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
