package com.SpringBoot.AOPdemo.DAO;

import com.SpringBoot.AOPdemo.Account;

import java.util.List;

public interface AccountDAO {

    void addAccount(Account theAccount, boolean vipFlag);

    void doWork();

    // adding new getter and setter methods so they can be called via DAO interface
    String getName();
    void setName(String name);
    String getServiceCode();
    void setServiceCode(String serviceCode);

    List<Account> findAccounts();
    // new method findAccounts that accepts a boolean parameter to demo throwing exception
    List<Account> findAccounts(boolean tripWire);
}
