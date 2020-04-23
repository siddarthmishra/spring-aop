package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(5)
public class MyDemoLoggingAspect {

	// match methods in a package
	// use the pointcut method name
	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackage()")
	public void m8beforeAddAccountAdvice() {
		System.out.println(
				"===>>> MyDemoLoggingAspect m8beforeAddAccountAdvice Executing @Before advice on any return type, specific package, any class, any method, 0 or more arguments of any type");
	}
}
