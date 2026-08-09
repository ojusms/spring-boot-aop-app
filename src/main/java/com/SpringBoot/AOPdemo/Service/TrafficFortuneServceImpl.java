package com.SpringBoot.AOPdemo.Service;

import java.util.concurrent.TimeUnit;

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
}
