package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component
@Order(5)
public class MyDemoLoggingAspect {

	// match methods in a package
	// use the pointcut method name
	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackage()")
	public void m8beforeAddAccountAdvice(JoinPoint joinPoint) {
		System.out.println(
				"===>>> MyDemoLoggingAspect m8beforeAddAccountAdvice Executing @Before advice on any return type, specific package, any class, any method, 0 or more arguments of any type");

		// display the method signature
		MethodSignature methodSign = (MethodSignature) joinPoint.getSignature();
		System.out.println("\tMethod Signature : " + methodSign);

		// display method arguments
		Object[] args = joinPoint.getArgs();
		for (Object arg : args) {
			System.out.println("\t" + arg);
			if (arg instanceof Account) {
				Account account = (Account) arg;
				System.out.println("\t\tAccount Name : " + account.getName());
				System.out.println("\t\tAccount Level : " + account.getLevel());
			}
		}
	}
}
