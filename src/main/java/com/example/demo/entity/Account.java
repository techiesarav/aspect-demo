package com.example.demo.entity;

public class Account{
	
	String name;
	
	String level;

	public String getLevel() {
		return level;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Account(String name, String level) {
		super();
		this.name = name;
		this.level = level;
	}

	@Override
	public String toString() {
		return "Account [name=" + name + ", level=" + level + "]";
	}
}