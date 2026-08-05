package com.SpringBoot.AOPdemo.DAO;

import com.SpringBoot.AOPdemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {

    // adding fields and respective getter and setter methods to help demonstrate combining of pointcut expressions
    // with logical operators
    private String name;

    private String serviceCode;

    // adding some print statements in all getters and setters for debugging purposes
    public String getName() {
        System.out.println(getClass() + ": getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + ": setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + ": getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + ": setServiceCode()");
        this.serviceCode = serviceCode;
    }

    @Override
    public void addAccount(Account theAccount, boolean vipFlag) {
        System.out.println(getClass() + " :DOING DB WORK: ADDING AN ACCOUNT");
    }

    // added to demonstrate pointcut expression matching on any method in any class in specific package
    @Override
    public void doWork() {
        System.out.println(getClass() + "doWork()");
    }
}
