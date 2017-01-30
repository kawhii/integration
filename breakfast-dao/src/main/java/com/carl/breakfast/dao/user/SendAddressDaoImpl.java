package com.carl.breakfast.dao.user;

import com.carl.breakfast.dao.pojo.user.SendAddress;
import com.carl.framework.core.dao.BaseDaoImpl;
import com.carl.framework.util.MapBuilder;
import org.springframework.stereotype.Repository;

/**
 * 收集信息默认dao
 *
 * @author Carl
 * @date 2017/1/1
 * 版权所有.(c)2017 - 2020. 卡尔工作室
 */
@Repository("addressDao")
public class SendAddressDaoImpl extends BaseDaoImpl<SendAddress> implements ISendAddressDao {
    @Override
    public void setDefault(String username, int id) {
        getSessionTemplate().update("setDefault", MapBuilder.build().p("username", username).p("id", id));
    }
}
