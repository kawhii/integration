package com.carl.breakfast.dao.user;

import com.carl.breakfast.dao.pojo.user.CommonAddress;
import com.carl.framework.core.dao.BaseDaoImpl;
import org.springframework.stereotype.Repository;

/**
 * 公共地址操作类
 * @author Carl
 * @date 2017/1/30
 * @since JDK1.7
 * <p>
 * 版权所有.(c)2008-2017.卡尔工作室
 */
@Repository("commonAddressDao")
public class CommonAddressDaoImpl extends BaseDaoImpl<CommonAddress> implements ICommonAddressDao {
}
