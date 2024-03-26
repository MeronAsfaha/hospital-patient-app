package edu.miu.cs.cs544.services.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    @JmsListener(destination = "${springjms.cs544Queue}")
    public void receive(String message){
        System.out.println("hello "+ message);
    }
}
