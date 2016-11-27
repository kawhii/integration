package com.carl.breakfast.dao.sys;


import com.carl.breakfast.dao.sys.pojo.SysFile;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2016/11/27.
 */
public class SysFileDaoTest extends BaseTest {
    @Autowired()
    private SysFileDao sysFileDao;

    @Test
    public void save() throws Exception {
        SysFile file = new SysFile();
        file.setBizCode("4G");
        file.setRemark("test");
        sysFileDao.save(file);

        Assert.assertNotNull(file);
        Assert.assertNotNull(file.getId());
    }

    @Test
    public void findById() throws Exception {

    }

}