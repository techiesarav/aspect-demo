package com.example.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
/**
 * aspect is a java class which contains all related advices
 * like logging,security
 * @author ramsa
 *
 */
@Aspect
@Component
public class LoggingAspect {
	
	//Declare a Point cut and re-use it.
	@Pointcut("execution(void com.example.demo.dao.*.add*(..))")
	public void forDaoPackage() {
		
	}
	
	@Before("com.example.demo.aspect.LoggingAspect.forDaoPackage()")
	public void beforeAdvice() {
		System.out.println("Executing Before Advice 1");
	}
	
	@Before("com.example.demo.aspect.LoggingAspect.forDaoPackage()")
	public void beforeAdvice2(JoinPoint joinPoint) {
		MethodSignature methodSig=(MethodSignature) joinPoint.getSignature();
		System.out.println(methodSig);
	}
	
	@Before("com.example.demo.aspect.LoggingAspect.forDaoPackage()")
	public void beforeAdvice1() {
		System.out.println("Executing Before Advice 2");
	}
	
	@Before("com.example.demo.aspect.LoggingAspect.forDaoPackage()")
	public void apiCallAddition() {
		System.out.println("---start API Call---");
	}
	
	@Before("com.example.demo.aspect.LoggingAspect.forDaoPackage()")
	public void syncCloudData() {
		System.out.println("---Sync Cloud Call---");
	}
}
