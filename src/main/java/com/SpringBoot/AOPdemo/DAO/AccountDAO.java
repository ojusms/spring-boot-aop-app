package com.SpringBoot.AOPdemo.DAO;

import com.SpringBoot.AOPdemo.Account;

public interface AccountDAO {

    void addAccount(Account theAccount, boolean vipFlag);

    void doWork();

    // adding new getter and setter methods so they can be called via DAO interface
    String getName();
    void setName(String name);
    String getServiceCode();
    void setServiceCode(String serviceCode);
}
