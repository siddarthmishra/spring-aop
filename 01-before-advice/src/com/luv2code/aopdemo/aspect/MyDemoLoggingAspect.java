package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	// this is where we add all of our related advices for logging

	// let's start with an @Before advice
	
	// pointcut expression
	/*
	 * execution(modifiers-pattern? return-type-pattern declaring-type-pattern?
	 * method-name-pattern(param-pattern) throws-pattern?)
	 */

	// ? = optional

	/*
	 * declaring-type-pattern is fully qualified name. If this is not mentioned, it
	 * matches any method-name-pattern(param-pattern) in any class
	 */

	// below matches any addAccount() method in any class
	@Before("execution(public void addAccount())")
	public void m1BeforeAddAccountAdvice() {
		System.out
		.println("===>>> m1BeforeAddAccountAdvice Executing @Before advice on any addAccount() in any class");
	}

	@Before("execution(public void com.luv2code.aopdemo.dao.AccountDAO.addAccount())")
	public void m2beforeAddAccountAdvice() {
		System.out.println("====>>> m2beforeAddAccountAdvice Executing @Before advice on AccountDAO addAccount()");
	}

	// any method starting with add in any class
	@Before("execution(public void add*())")
	public void m3beforeAddAccountAdvice() {
		System.out.println("====>>> m3beforeAddAccountAdvice Executing @Before advice on any add*() in any class");
	}

	// any method with return type String in any class
	@Before("execution(String *())")
	public void m4beforeAddAccountAdvice() {
		System.out.println(
				"====>>> m4beforeAddAccountAdvice Executing @Before advice on any method with return type String in any class");
	}

	/*
	 * param-pattern : () - matches a method with no arguments ; (*) - matches a
	 * method with one argument of any type ; (..) - matches a method with 0 or more
	 * arguments of any type
	 */

	// any add*(com.luv2code.aopdemo.Account) in any class
	// for user defined types, fully qualified type is required
	@Before("execution(* add*(com.luv2code.aopdemo.Account))")
	public void m5beforeAddAccountAdvice() {
		System.out.println(
				"====>>> m5beforeAddAccountAdvice Executing @Before advice on any add*(com.luv2code.aopdemo.Account) with com.luv2code.aopdemo.Account paramater in any class");
	}

	// any method with String as parameter in any class
	@Before("execution(* *(String))")
	public void m6beforeAddAccountAdvice() {
		System.out.println(
				"====>>> m6beforeAddAccountAdvice Executing @Before advice on any method with String as parameter in any class");
	}

	// parameter with Account type followed by 0 or more any type paramater
	@Before("execution(* add*(com.luv2code.aopdemo.Account, ..))")
	public void m7beforeAddAccountAdvice() {
		System.out.println(
				"====>>> m7beforeAddAccountAdvice Executing @Before advice on any add*(com.luv2code.aopdemo.Account, ..) in any class");
	}

	// match methods in a package
	@Before("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	public void m8beforeAddAccountAdvice() {
		System.out.println(
				"====>>> m8beforeAddAccountAdvice Executing @Before advice on any return type, specific package, any class, any method, 0 or more arguments of any type");
	}
	
	// HOW TO REUSE POINTCUT EXPRESSION?
	// Ans : POINTCUT DECLARATION
	// HOW TO DECLARE POINTCUT DECLARATION? 
	// Ans : @Pointcut
	
	
	
}
