package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class FortuneService {

	public String getFortune(boolean check) {
		if(check) {
			throw new RuntimeException("runtime excecption");
		}
		return "Today will b a greate day!";
		}
	}
