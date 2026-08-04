package com.SpringBoot.AOPdemo.DAO;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO {
    @Override
    public void addMember() {
        System.out.println(getClass() + " :DOING DB WORK: ADDING A MEMBERSHIP ACCOUNT");
    }
}
