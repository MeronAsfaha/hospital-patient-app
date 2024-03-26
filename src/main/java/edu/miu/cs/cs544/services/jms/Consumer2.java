package edu.miu.cs.cs544.services.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class Consumer2 {
    @JmsListener(destination = "${springjms.cs544Queue}")
    public void receive(String message){
        System.out.println(message + " Receipt is" + randomNumGenerator());
    }

    public int randomNumGenerator(){
        Random random = new Random(1000L);
        return random.nextInt();
    }
}
