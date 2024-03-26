package edu.miu.cs.cs544;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class HospitalPatientApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitalPatientApplication.class, args);
    }

}
