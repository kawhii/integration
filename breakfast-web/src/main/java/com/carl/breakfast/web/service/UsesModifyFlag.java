package com.carl.breakfast.web.service;

/**
 * 用户修改标志
 *
 * @author Carl
 * @date 2017/1/24
 * @since JDK1.7
 * <p>
 * 版权所有.(c)2008-2017.卡尔工作室
 */
public enum UsesModifyFlag {
    /**
     * 用户不存在
     */
    NO_USER,
    /**
     * 密码错误
     */
    PASSWORD_ERROR,
    /**
     * 修改成功
     */
     SUCCESS,
     /**
     * 结果集异常
     */
    RESULT_ERROR
}
