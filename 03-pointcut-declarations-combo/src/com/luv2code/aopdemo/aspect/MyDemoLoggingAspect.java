package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	// this is where we add all of our related advices for logging

	// how to apply multiple pointcut expression to single advice
	// execute an advice only if certain condition is met
	// e.g. all methods in a package EXCEPT getter/setter methods
	// combine pointcut expression/declaration using logic operator &&, ||, !

	// pointcut declaration to match methods in a package
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {
	}

	// create point cut for getter methods
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
	private void getter() {
	}

	// create pointcut for setter methods
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
	private void setter() {
	}

	// create pointcut : include package and exclude getter/setter methods
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void forDaoPackageNoGetterSetter() {
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

	// this will not be called for getter/setter methods
	@Before("forDaoPackageNoGetterSetter()")
	public void m9forDaoPackageNoGetterSetter() {
		System.out.println("===>>> m9forDaoPackageNoGetterSetter");
	}

	// how to control the order of advice being applied
	// Ans : Refactor: Place advices in separate Aspects
	// then add Control order on Aspects using the @Order annotation
	// e.g. @Order(1) -> Lower number have higher precedence (Range :
	// Integer.MIN_VALUE to Integer.MAX_VALUE)
	// Two or more Aspects can have same order e.g. @Order(6)
}
