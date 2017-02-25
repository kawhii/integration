package com.carl.breakfast.web.service.impl;

import com.carl.breakfast.dao.DaoException;
import com.carl.breakfast.dao.sys.SysFileDao;
import com.carl.breakfast.dao.sys.SysFileSearchDao;
import com.carl.breakfast.dao.sys.pojo.SysFile;
import com.carl.breakfast.web.service.SysFileService;
import com.carl.framework.core.page.PageBean;
import com.carl.framework.core.page.PageParam;
import com.carl.framework.util.MapBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
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
    protected static final Log logger = LogFactory.getLog(WechatOrderServiceImpl.class);

    @Autowired
    private SysFileDao sysFileDao;
    @Autowired
    private SysFileSearchDao sysFileSearchDao;

    public SysFileDao getDao() {
        return sysFileDao;
    }

    public int save(SysFile file) throws DaoException {
        return sysFileDao.save(file);
    }

    public SysFile findById(int id) throws DaoException {
        return sysFileDao.findById(id);
    }

    @Override
    public int deleteById(int id) throws DaoException {
        logger.info(String.format("用户【%s】申请删除图片【%s】", SecurityUtils.getSubject().getPrincipal().toString(), String.valueOf(id)));
        return sysFileDao.deleteById(id);
    }

    /**
     * 列表查询
     * @param pageSize
     * @param page
     * @param fileName
     * @param effective
     * @return
     */
    public PageBean<SysFile> list(int pageSize, int page, String fileName, int effective) {
        return sysFileSearchDao.listPage(new PageParam(page, pageSize),
                MapBuilder.<String, Object>build().p("effective", effective).p("uploadName", fileName));
    }
}
