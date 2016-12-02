package com.carl.breakfast.web.service;

import com.carl.breakfast.dao.DaoException;
import com.carl.breakfast.dao.sys.SysFileDao;
import com.carl.breakfast.dao.sys.pojo.SysFile;
import com.carl.framework.core.page.PageBean;

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

    /**
     * 根据文件id删除
     * @param id
     * @return
     * @throws DaoException
     */
    int deleteById(int id) throws DaoException;

    /**
     * 分页查询文件
     * @param pageSize 页数大小
     * @param page 当前页
     * @param fileName 文件名字
     * @param effective 是否有效 1- 有效， 0- 无效
     * @return
     */
    PageBean<SysFile> list(int pageSize, int page, String fileName, int effective);
}
