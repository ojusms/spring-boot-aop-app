package com.SpringBoot.AOPdemo;

import com.SpringBoot.AOPdemo.DAO.AccountDAO;
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
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO) {
		return runner -> {
			accountDAO.addAccount();
		};
	}

}
