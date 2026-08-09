package com.SpringBoot.AOPdemo;

import com.SpringBoot.AOPdemo.DAO.AccountDAO;
import com.SpringBoot.AOPdemo.DAO.MembershipDAO;
import com.SpringBoot.AOPdemo.Service.TrafficFortuneService;
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
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO,
	                                           TrafficFortuneService trafficFortuneService) {
		return runner -> {
			//demoBeforeAdvice(accountDAO, membershipDAO);
			//demoAfterReturningAdvice(accountDAO);
			//demoAfterThrowingAdvice(accountDAO);
			//demoAfterFinallyAdvice(accountDAO);
			demoAroundAdvice(trafficFortuneService);
		};
	}

	private void demoAroundAdvice(TrafficFortuneService trafficFortuneService) {
		System.out.println("Main add: demoAroundAdvice");
		String result = trafficFortuneService.getFortune();
		System.out.println("Fortune is: "+result);
	}

	private void demoAfterFinallyAdvice(AccountDAO accountDAO) {
		// similar to demoAfterThrowingAdvice() but wrap it in a try/catch block to catch any
		// exception that might be thrown. Setting tripWire to true so the findAccounts throws an exception
		// @After advice is called regardless of true or false value for tripWire
		List<Account> accounts = null;
		boolean tripWire = true;
		try {
			accounts = accountDAO.findAccounts(tripWire);
		} catch (Exception e) {
			System.out.println("Main app: ... caught Exception: " + e);
		}
		System.out.println("Main app: demoAfterFinallyAdvice");
		System.out.println("-----");
		System.out.println(accounts);
		System.out.println("-----");
	}

	private void demoAfterThrowingAdvice(AccountDAO accountDAO) {
		// similar to demoAfterReturningAdvice() but wrap it in a try/catch block to catch any
		// exception that might be thrown. Setting tripWire to true so the findAccounts throws an exception
		List<Account> accounts = null;
		boolean tripWire = true;
			try {
				accounts = accountDAO.findAccounts(tripWire);
			} catch (Exception e) {
				System.out.println("Main app: ... caught Exception: " + e);
			}
		System.out.println("Main app: demoAfterThrowingAdvice");
		System.out.println("-----");
		System.out.println(accounts);
		System.out.println("-----");
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
