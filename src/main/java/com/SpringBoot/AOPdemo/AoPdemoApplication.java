package com.SpringBoot.AOPdemo;

import com.SpringBoot.AOPdemo.DAO.AccountDAO;
import com.SpringBoot.AOPdemo.DAO.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AoPdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AoPdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO) {
		return runner -> {
			//demoBeforeAdvice(accountDAO, membershipDAO);
			demoAfterReturningAdvice(accountDAO);
		};
	}

	private void demoAfterReturningAdvice(AccountDAO accountDAO) {
		List<Account> accounts = accountDAO.findAccounts();
		System.out.println("Main app: demoAfterReturningAdvice");
		System.out.println("-----");
        // the calling method is returned the post-processed result list by the @AfterReturning advice.
		// the account names will all be in upper case now.
		System.out.println(accounts);
		System.out.println("-----");
	}

	private void demoBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {
		// call business method
		Account tempAccount = new Account();
		tempAccount.setName("John");
		tempAccount.setLevel("Gold");
		accountDAO.addAccount(tempAccount, true);
		accountDAO.doWork();
		// call membership business method
		membershipDAO.addMember();
		membershipDAO.check();
		// both the @Before advice methods of logging aspect are called for both the DAO's methods since they satisfy the
		// pointcut expression matching criteria for any method,
		// having 0 or more parameters of any type, inside any class ,inside DAO package

		// calling new getter and setter methods. The Before advice methods of logging aspect should not be called
		// due to new combined pointcut expression.
		accountDAO.setName("John");
		accountDAO.setServiceCode("Gold");
		String name = accountDAO.getName();
		String service = accountDAO.getServiceCode();
	}

}
