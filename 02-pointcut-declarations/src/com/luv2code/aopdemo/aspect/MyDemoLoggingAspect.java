package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	// this is where we add all of our related advices for logging

	// HOW TO REUSE POINTCUT EXPRESSION?
	// Ans : POINTCUT DECLARATION
	// HOW TO DECLARE POINTCUT DECLARATION?
	// Ans : @Pointcut

	// pointcut declaration to match methods in a package
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {
	}

	// match methods in a package
	// use the pointcut method name
	@Before("forDaoPackage()")
	public void m8beforeAddAccountAdvice() {
		System.out.println(
				"===>>> m8beforeAddAccountAdvice Executing @Before advice on any return type, specific package, any class, any method, 0 or more arguments of any type");
	}

	// reusing pointcut declaration
	@Before("forDaoPackage()")
	public void performApiAnalytics() {
		System.out.println("===>>> Performing API Analytics");
	}

	// how to apply multiple pointcut expression to single advice
	// execute an advice only if certain condition is met
	// e.g. all methods in a package EXCEPT getter/setter methods

	// combine pointcut expression/declaration using logic operator &&, ||, !
}
