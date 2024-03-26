package edu.miu.cs.cs544.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class RandomController {

    @GetMapping("/rand")
    public Integer randomGenerator(){
        Random random = new Random();
        return random.nextInt();
    }
}
