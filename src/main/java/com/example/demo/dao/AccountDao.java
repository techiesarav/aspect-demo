package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.Account;

@Repository
public class AccountDao {

	public void addSomeStuff() {
		System.out.println("In Account Dao,First Method");
	}
	
	public void addSomeStuff1() {
		System.out.println("In Account Dao,Second Method");
	}
	
	public void addSomeStuff2(int i) {
		System.out.println("In Account Dao,args Method");
	}
	
	public List<Account> findAccounts(boolean check){
		if(check) {
			throw new RuntimeException("Runtime exception");
		}
		Account ac1 = new Account("first","1");
		Account ac2 = new Account("second","2");
		List<Account> aList = new ArrayList<>();
		aList.add(ac1);
		aList.add(ac2);
		return aList;
	}
}
