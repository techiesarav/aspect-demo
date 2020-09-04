package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.example.demo.dao.AccountDao;
import com.example.demo.service.FortuneService;

@SpringBootApplication
@EnableAspectJAutoProxy
public class DemoApplication implements CommandLineRunner
{

	@Autowired
	AccountDao accountDao;
	
	@Autowired
	FortuneService fService;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	public void run(String... args) throws Exception {
		accountDao.addSomeStuff();
		accountDao.addSomeStuff1();
		accountDao.addSomeStuff2(5);
		try {
			accountDao.findAccounts(true);
		}
		catch(Exception ex){
			System.out.println("catch exceptions in main");
			System.out.println(ex.getMessage());
		}
		System.out.println(fService.getFortune(true));
	}
}