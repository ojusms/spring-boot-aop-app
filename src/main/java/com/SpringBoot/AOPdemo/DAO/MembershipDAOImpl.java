package com.SpringBoot.AOPdemo.DAO;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO {
    @Override
    public boolean addMember() {
        System.out.println(getClass() + " :DOING DB WORK: ADDING A MEMBERSHIP ACCOUNT");
        return true;
    }
}
