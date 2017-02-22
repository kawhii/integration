package com.carl.breakfast.web.service;

import com.carl.breakfast.dao.pojo.user.CommonAddress;

import java.util.List;

/**
 * @author Carl
 * @date 2017/1/30
 * @since JDK1.7
 * <p>
 * 版权所有.(c)2008-2017.卡尔工作室
 */
public interface ICommonAddressService {
    List<CommonAddress> listByType(Type type);

    CommonAddress findById(String id);

    enum Type {
        FLOW("F"),
        BUILD("D");
        private String name;

        Type(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
