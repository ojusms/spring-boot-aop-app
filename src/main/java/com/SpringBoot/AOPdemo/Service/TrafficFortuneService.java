package com.SpringBoot.AOPdemo.Service;

public interface TrafficFortuneService {

    String getFortune();

    // a method with a boolean parameter to throw an exception or not.
    String getFortune(boolean tripWire);
}
