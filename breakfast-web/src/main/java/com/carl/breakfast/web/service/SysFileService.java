package com.carl.breakfast.web.service;

import com.carl.breakfast.dao.DaoException;
import com.carl.breakfast.dao.sys.SysFileDao;
import com.carl.breakfast.dao.sys.pojo.SysFile;

/**
 * @author Carl
 * @date 2016/11/28
 * © 2016 - 2020 , all rights reserved .卡尔工作室
 */
public interface SysFileService extends IService<SysFileDao> {
    /**
     * 保存文件
     * @param file
     * @return
     * @throws DaoException
     */
    int save(SysFile file) throws DaoException;


    /**
     * 根据id来查询
     * @param id
     * @return
     * @throws DaoException
     */
    SysFile findById(int id) throws DaoException;
}
