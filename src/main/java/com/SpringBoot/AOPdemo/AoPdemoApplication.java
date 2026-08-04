package com.SpringBoot.AOPdemo;

import com.SpringBoot.AOPdemo.DAO.AccountDAO;
import com.SpringBoot.AOPdemo.DAO.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AoPdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AoPdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO) {
		return runner -> {
			demoBeforeAdvice(accountDAO, membershipDAO);
		};
	}

	private void demoBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {
		// call business method
		accountDAO.addAccount();
		// call membership business method
		membershipDAO.addAccount();
		// the @Before advice of logging aspect is called only for AccountDAO's addAccount()
		// because of pointcut expression update.
	}

}
