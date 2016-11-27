package com.carl.breakfast.dao.sys;

import com.carl.breakfast.dao.DaoException;
import com.carl.breakfast.dao.sys.pojo.SysFile;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 文件操作类
 *
 * @author Carl
 * @date 2016/11/27
 * © 2016 - 2020 , all rights reserved .卡尔工作室
 */
@Repository("sysFileDao")
public class SysFileDaoImpl implements SysFileDao {

    @Autowired
    private SqlSession sqlSession;

    public SysFile save(SysFile file) throws DaoException {
        //// TODO: 2016/11/27  
        return null;
    }

    public SysFile findById(int id) throws DaoException {
        return null;
    }
}
