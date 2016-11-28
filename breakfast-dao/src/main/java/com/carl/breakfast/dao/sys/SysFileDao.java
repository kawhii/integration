package com.carl.breakfast.dao.sys;

import com.carl.breakfast.dao.DaoException;
import com.carl.breakfast.dao.sys.pojo.SysFile;
import org.springframework.stereotype.Repository;

/**
 * 文件操作类
 *
 * @author Carl
 * @date 2016/11/27
 * © 2016 - 2020 , all rights reserved .卡尔工作室
 */
@Repository
public interface SysFileDao {
    /**
     * 保存文件
     *
     * @param file
     * @return
     * @throws DaoException
     */
    int save(SysFile file) throws DaoException;


    /**
     * 根据id来查询
     *
     * @param id
     * @return
     * @throws DaoException
     */
    SysFile findById(int id) throws DaoException;
}
