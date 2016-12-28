package com.carl.breakfast.dao.sys;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * 基础测试类
 *
 * @author Carl
 * @date 2016/11/27
 * © 2016 - 2020 , all rights reserved .卡尔工作室
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration()
@ContextConfiguration(locations = {"classpath:/context/applicationContext.xml", "classpath:/context/servlet-context.xml"})
public class BaseTest {
}
