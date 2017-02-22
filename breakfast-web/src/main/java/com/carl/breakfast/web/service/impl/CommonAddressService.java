package com.carl.breakfast.web.service.impl;

import com.carl.breakfast.dao.pojo.user.CommonAddress;
import com.carl.breakfast.dao.user.ICommonAddressDao;
import com.carl.breakfast.web.service.ICommonAddressService;
import com.carl.framework.util.MapBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Carl
 * @date 2017/1/30
 * @since JDK1.7
 * <p>
 * 版权所有.(c)2008-2017.广州市森锐科技股份有限公司
 */
@Service
public class CommonAddressService implements ICommonAddressService {
    @Autowired
    private ICommonAddressDao commonAddressDao;

    @Override
    public List<CommonAddress> listByType(Type type) {
        return commonAddressDao.listBy(MapBuilder.<String, Object>build().p("typeId", type.getName()));
    }

    @Override
    public CommonAddress findById(String id) {
        return commonAddressDao.getById(id);
    }
}
