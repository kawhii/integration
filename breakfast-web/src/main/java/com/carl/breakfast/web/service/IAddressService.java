package com.carl.breakfast.web.service;

import com.carl.breakfast.dao.pojo.user.SendAddress;
import com.carl.breakfast.web.bean.AddressDetailBean;

import java.util.List;

/**
 * 地址
 *
 * @author Carl
 * @date 2017/1/30
 * @since JDK1.7
 * <p>
 * 版权所有.(c)2008-2017.卡尔工作室
 */
public interface IAddressService {
    String FLOW = "flow";
    String BUILD = "build";
    String SCHOOL = "school";
    String HOUSE_NUM = "houseNum";
    String DETAIL = "detail";


    /**
     * 添加地址
     *
     * @param address
     * @return
     */
    SendAddress addAddress(AddressDetailBean address);

    /**
     * 设置该地址为默认地址
     *
     * @param username
     * @param id
     */
    void setDefaultAddress(String username, int id);

    /**
     * 根据用户名查询用户地址信息
     *
     * @param username
     * @return
     */
    List<SendAddress> queryAddressByUsername(String username);

    /**
     * 个根据id删除地址
     *
     * @param id
     * @return
     */
    boolean removeAddressById(int id);

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    AddressDetailBean queryAddressById(int id);
}
