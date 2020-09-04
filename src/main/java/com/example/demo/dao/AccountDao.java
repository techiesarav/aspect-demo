package com.example.demo.dao;

import org.springframework.stereotype.Repository;

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
}
