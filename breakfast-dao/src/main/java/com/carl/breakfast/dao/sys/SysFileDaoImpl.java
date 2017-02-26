package com.carl.breakfast.dao.sys;

import com.carl.breakfast.dao.DaoException;
import com.carl.breakfast.dao.sys.pojo.SysFile;
import com.carl.framework.core.dao.BaseDaoImpl;
import org.springframework.stereotype.Repository;

/**
 * @author Carl
 * @date 2017/2/26
 * 版权所有.(c)2017 - 2020. 卡尔工作室
 */
@Repository
public class SysFileDaoImpl extends BaseDaoImpl<SysFile> implements SysFileDao {
    @Override
    public int save(SysFile file) throws DaoException {
        return insert(file);
    }

    @Override
    public SysFile findById(int id) throws DaoException {
        return super.getById(id + "");
    }

    @Override
    public int deleteById(int id) throws DaoException {
        return delete(id + "");
    }
}
