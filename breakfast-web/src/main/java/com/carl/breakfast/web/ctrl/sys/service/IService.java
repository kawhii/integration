package com.carl.breakfast.web.ctrl.sys.service;

import com.carl.breakfast.dao.IDao;

/**
 * 获取dao类
 * @author Carl
 * @date 2016/11/28
 * © 2016 - 2020 , all rights reserved .卡尔工作室
 */
public interface IService<T extends IDao<?>> {
    T getDao();
}
