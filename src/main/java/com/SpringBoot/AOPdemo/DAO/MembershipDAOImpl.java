package com.SpringBoot.AOPdemo.DAO;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO {
    @Override
    public boolean addMember() {
        System.out.println(getClass() + " :DOING DB WORK: ADDING A MEMBERSHIP ACCOUNT");
        return true;
    }

    // added to demonstrate pointcut expression matching on any method in any class in specific package
    @Override
    public void check() {
        System.out.println(getClass()+" performing check!");
    }
}
