package com.SpringBoot.AOPdemo.Service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class TrafficFortuneServceImpl implements TrafficFortuneService {
    @Override
    public String getFortune() {
        // simulate a delay
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // return a 'fortune'
        return "Expect traffic this morning";
    }

    @Override
    public String getFortune(boolean tripWire) {
        if (tripWire)
            throw new RuntimeException("Accident on highway! Lanes closed!");
       return getFortune();
    }
}
