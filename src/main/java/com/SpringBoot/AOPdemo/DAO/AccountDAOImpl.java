package com.SpringBoot.AOPdemo.DAO;

import com.SpringBoot.AOPdemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {
    @Override
    public void addAccount(Account theAccount, boolean vipFlag) {
        System.out.println(getClass() + " :DOING DB WORK: ADDING AN ACCOUNT");
    }
}
