package com.carl.breakfast.web.service.impl;

import com.carl.breakfast.dao.pojo.user.AddressExt;
import com.carl.breakfast.dao.pojo.user.SendAddress;
import com.carl.breakfast.dao.user.IAddressExtDao;
import com.carl.breakfast.dao.user.ICommonAddressDao;
import com.carl.breakfast.dao.user.ISendAddressDao;
import com.carl.breakfast.web.bean.AddressDetailBean;
import com.carl.breakfast.web.service.IAddressService;
import com.carl.framework.util.MapBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 地址服务类
 *
 * @author Carl
 * @date 2017/1/30
 * @since JDK1.7
 * <p>
 * 版权所有.(c)2008-2017.卡尔工作室
 */
@Service
public class AddressServiceImpl implements IAddressService {
    @Autowired
    private ISendAddressDao addressDao;
    @Autowired
    private IAddressExtDao addressExtDao;
    @Autowired
    private ICommonAddressDao commonAddressDao;

    @Override
    @Transactional
    public SendAddress addAddress(AddressDetailBean address) {
        AddressExt school = address.getSchool();
        AddressExt flow = address.getFlow();
        AddressExt build = address.getBuild();
        AddressExt houseNum = address.getHouseNumber();
        AddressExt detail = address.getDetailAddress();
        String schoolName = school.getVal();
        //楼层名字
        String flowName = commonAddressDao.getById(flow.getVal()).getInfo();
        //楼栋名字
        String buildName = commonAddressDao.getById(build.getVal()).getInfo();
        //门牌号
        String houseNumber = houseNum.getVal();
        StringBuilder sb = new StringBuilder();
        sb.append(schoolName).append(buildName).append(flowName).append(houseNumber).append(detail.getVal());
        SendAddress sendAddress = new SendAddress();
        copyToAddress(address, sendAddress);
        sendAddress.setDetail(sb.toString());

        //插入详细表
        addressDao.insert(sendAddress);
        int addressId = sendAddress.getId();
        school.setAddressId(addressId);
        flow.setAddressId(addressId);
        build.setAddressId(addressId);
        houseNum.setAddressId(addressId);
        detail.setAddressId(addressId);

        addressExtDao.insert(school);
        addressExtDao.insert(flow);
        addressExtDao.insert(build);
        addressExtDao.insert(houseNum);
        addressExtDao.insert(detail);

        if (address.isDefault()) {
            setDefaultAddress(address.getUsername(), addressId);
        }
        return sendAddress;
    }

    @Override
    public void setDefaultAddress(String username, int id) {
        addressDao.setDefault(username, id);
    }

    @Override
    public List<SendAddress> queryAddressByUsername(String username) {
        return addressDao.listBy(MapBuilder.<String, Object>build().p("username", username));
    }

    @Override
    @Transactional
    public boolean removeAddressById(int id) {
        addressExtDao.delete(MapBuilder.<String, Object>build().p("addressId", id));
        return 1 == addressDao.delete(id + "");
    }

    @Override
    public AddressDetailBean queryAddressById(int id) {
        SendAddress sendAddress = addressDao.getById(String.valueOf(id));
        List<AddressExt> addressExts = addressExtDao.listBy(MapBuilder.<String, Object>build().p("addressId", id));
        AddressDetailBean bean = new AddressDetailBean();
        copyToBean(bean, sendAddress);
        for (AddressExt addressExt : addressExts) {
            switch (addressExt.getKeyAs()) {
                case FLOW:
                    bean.setFlow(addressExt);
                    break;
                case SCHOOL:
                    bean.setSchool(addressExt);
                    break;
                case BUILD:
                    bean.setBuild(addressExt);
                    break;
                case HOUSE_NUM:
                    bean.setHouseNumber(addressExt);
                    break;
                case DETAIL:
                    bean.setDetailAddress(addressExt);
                    break;
            }
        }
        return bean;
    }

    private void copyToBean(AddressDetailBean bean, SendAddress sendAddress) {
        bean.setId(sendAddress.getId())
                .setDefault(sendAddress.isDefault())
                .setContactsName(sendAddress.getContactsName())
                .setContactsPhone(sendAddress.getContactsPhone())
                .setUsername(sendAddress.getUsername())
        ;
    }

    private void copyToAddress(AddressDetailBean bean, SendAddress sendAddress) {

        sendAddress.setContactsPhone(bean.getContactsPhone())
                .setDefault(bean.isDefault())
                .setUsername(bean.getUsername())
                .setContactsName(bean.getContactsName());
    }
}
