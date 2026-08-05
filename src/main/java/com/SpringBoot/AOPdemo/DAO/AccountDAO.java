package com.SpringBoot.AOPdemo.DAO;

import com.SpringBoot.AOPdemo.Account;

public interface AccountDAO {

    void addAccount(Account theAccount, boolean vipFlag);
}
