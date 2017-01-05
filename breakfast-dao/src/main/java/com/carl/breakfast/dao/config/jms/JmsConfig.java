package com.carl.breakfast.dao.config.jms;

import com.carl.breakfast.dao.config.BaseConfig;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.broker.BrokerService;
import org.apache.activemq.store.memory.MemoryPersistenceAdapter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.ConnectionFactory;
import java.io.IOException;

/**
 * jms
 *
 * @author Carl
 * @date 2016/12/28
 * @since JDK1.7
 * <p>
 * 版权所有.(c)2008-2016.卡尔工作室
 */
@Configuration
@EnableJms
@PropertySource("classpath:jms.properties")
public class JmsConfig extends BaseConfig {
    @Value("${jms.brokerUrl}")
    private String brokerUrl;
    @Value("${jms.destinationName}")
    private String destinationName;
    @Value("${jms.sessionTransacted}")
    private Boolean sessionTransacted;
    @Value("${jms.pubSubDomain}")
    private Boolean pubSubDomain;
    @Value("${jms.pubSubNoLocal}")
    private Boolean pubSubNoLocal;
    @Value("${jms.sessionAcknowledgeMode}")
    private Integer sessionAcknowledgeMode;
    @Value("${jms.deliveryPersistent}")
    private Boolean deliveryPersistent;

    @Value("${jms.username}")
    private String username;
    @Value("${jms.password}")
    private String password;

    @Bean
    public JmsTemplate jmsTemplate() {
        JmsTemplate jmsTemplate = new JmsTemplate();
        //连接工厂
        jmsTemplate.setConnectionFactory(connectionFactory());
        //是否事务
        jmsTemplate.setSessionTransacted(sessionTransacted);
        //目标名称
        jmsTemplate.setDefaultDestinationName(destinationName);
        //是否发布还是点对点
        jmsTemplate.setPubSubDomain(pubSubDomain);
        //
        jmsTemplate.setPubSubNoLocal(pubSubNoLocal);
        jmsTemplate.setSessionAcknowledgeMode(sessionAcknowledgeMode);
        jmsTemplate.setDeliveryPersistent(deliveryPersistent);
        return jmsTemplate;
    }

    @Bean
    public ConnectionFactory connectionFactory() {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setBrokerURL(brokerUrl);
        connectionFactory.setUserName(username);
        connectionFactory.setPassword(password);
        return connectionFactory;
    }

    @Bean
    public BrokerService brokerService() throws Exception {
        BrokerService broker = new BrokerService();
        broker.addConnector(brokerUrl);
        broker.setBrokerName("brokerService");
        broker.setPersistent(false);
        broker.setPersistenceAdapter(new MemoryPersistenceAdapter() );
        return broker;
    }
}
