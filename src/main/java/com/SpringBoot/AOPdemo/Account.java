package com.SpringBoot.AOPdemo;

// created to help demonstrate parameter matching in pointcut expression of Advice method of Aspect class.
public class Account {

    private String name;

    private String level;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
