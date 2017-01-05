package com.carl.breakfast.dao.config;

import com.carl.breakfast.dao.config.jms.JmsConfig;
import org.apache.activemq.broker.BrokerService;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.jms.ConnectionFactory;
import javax.jms.Message;

import java.util.Collection;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/1/2.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = JmsConfig.class)
public class JmsConfigTest {
    @Autowired
    private JmsTemplate jmsTemplate;
    @Autowired
    private ConnectionFactory connectionFactory;

    @Autowired
    private BrokerService brokerService;

    @Test
    public void jmsTemplate() throws Exception {
        assertNotNull(jmsTemplate);
        String text = "msg";
        jmsTemplate.send(session -> {
            ActiveMQTextMessage message = new ActiveMQTextMessage();
            message.setText(text);
            return message;
        });
        Message msg = jmsTemplate.receive();
        assertTrue(msg instanceof ActiveMQTextMessage);
        String res = ((ActiveMQTextMessage)msg).getText();
        System.out.println(res);
        assertNotNull(res);

    }

    @Test
    public void received() throws Exception {
        Message message = jmsTemplate.receive();
        System.out.println(message);

    }

    @Test
    public void connectionFactory() throws Exception {
        assertNotNull(connectionFactory);
    }

    @Test
    public void brokerService() throws Exception {
        brokerService.start();
        Thread.sleep(60000);
    }
}