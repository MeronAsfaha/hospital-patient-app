package edu.miu.cs.cs544.services.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class Producer {
    @Autowired
    private JmsTemplate jmsTemplate;
    @Value(value= "${springjms.cs544Queue}")
    private String queueName;

    public void send(String message){
        jmsTemplate.convertAndSend(queueName,message);
    }
}
