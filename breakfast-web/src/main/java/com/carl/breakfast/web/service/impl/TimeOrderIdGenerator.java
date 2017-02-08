package com.carl.breakfast.web.service.impl;

import com.carl.breakfast.web.service.IOrderIdGenerator;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Carl
 * @date 2017/2/9
 * 版权所有.(c)2017 - 2020. 卡尔工作室
 */
@Component
public class TimeOrderIdGenerator implements IOrderIdGenerator {
    private DateFormat formatter = new SimpleDateFormat("yyyyMMddhhmmssSS");

    @Override
    public String create() {
        return formatter.format(new Date());
    }
}
