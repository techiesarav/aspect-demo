package com.example.demo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Account;
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


	@AfterReturning(
			pointcut = "execution(* com.example.demo.dao.*.findAccounts(..))",
			returning = "result")
	public void logAccounts(JoinPoint joinPoint,List<Account> result) {
		System.out.println("After Returning....");

		//pre-process/post-process data
		for(Account account:result) {
			account.setName(account.getName().toUpperCase());
		}
		System.out.println(result);
	}

	@AfterThrowing(
			pointcut = "execution(* com.example.demo.dao.*.findAccounts(..))",
			throwing = "exc")
	public void afterThrowsExceptions(JoinPoint joinPoint,Throwable exc) {
		System.out.println("After Returning....");

		//throw exceptions

		System.out.println(exc.getMessage());
	}
	
	@Around("execution(* com.example.demo.service.*.getFortune(..))")
	public Object handleAroundAdvice(ProceedingJoinPoint pjoinPoint) throws Throwable {
		System.out.println("calculate timer....");
		Object result = null;
		long start = System.currentTimeMillis();
		try {
			result =pjoinPoint.proceed();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			result = "exception handled! cool!!";
		}
		long end = System.currentTimeMillis();
		//find duration
		long duration = end-start;
		System.out.println("Time taken to execute getFortune method "+duration);
		return result;
	}


		@Before("com.example.demo.aspect.LoggingAspect.forDaoPackage()")
		public void printMethodDefintions(JoinPoint joinPoint) {
			MethodSignature ms = (MethodSignature) joinPoint.getSignature();
			System.out.println("Method Signature "+ms.getName());
			Object[] args = joinPoint.getArgs();
			for(Object arg : args) {
				System.out.println("Args :"+arg.toString());
			}
		}

		//To Log Method start and end
		@Around("com.example.demo.aspect.LoggingAspect.forDaoPackage()")
		public void logMethodStartAndEnd(ProceedingJoinPoint pjoin) throws Throwable {
			String name = pjoin.getSignature().getName();
			System.out.println("<--------------->");
			System.out.println(name+" Method Execution Starts..");
			pjoin.proceed();
			System.out.println(name+" Method Execution Ends..");
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
