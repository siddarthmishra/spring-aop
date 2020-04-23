package com.luv2code.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;
import com.luv2code.aopdemo.AroundWithLoggerDemoApp;

@Aspect
@Component
@Order(5)
public class MyDemoLoggingAspect {

	private static Logger myLogger = Logger.getLogger(AroundWithLoggerDemoApp.class.getName());

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

	// add a new advice for @AfterReturning on the findAccounts methods
	@AfterReturning(pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))", returning = "listOfAccounts")
	public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> listOfAccounts) {

		// print out which method we are advising on
		String method = joinPoint.getSignature().toShortString();
		System.out.println("===>>> Executing @AfterReturning on method : " + method);

		// print out the results of the method call
		System.out.println("===>>> result is : " + listOfAccounts);

		// let's post-process the data... let's modify it

		// convert the account names to upper case
		convertAccountNamesToUpperCase(listOfAccounts);

		// print out the results of the method call
		System.out.println("===>>> result is : " + listOfAccounts);

	}

	private void convertAccountNamesToUpperCase(List<Account> accounts) {
		for (Account account : accounts) {
			account.setName(account.getName().toUpperCase());
		}
	}

	@AfterReturning("execution(* com.luv2code.aopdemo.dao.AccountDAO.method1(..))")
	public void method1AfterReturning() {
		System.out.println("===>>> @AfterReturning method1AfterReturning()");
	}

	@AfterThrowing(pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))", throwing = "theExe")
	public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable theExe) {

		// print out which method we are advising on
		String method = joinPoint.getSignature().toShortString();
		System.out.println("===>>> Executing @AfterThrowing on method : " + method);

		// log the exception
		System.out.println("===>>> The Exception is : " + theExe);
	}

	@AfterThrowing("execution(* com.luv2code.aopdemo.dao.AccountDAO.method1(..))")
	public void method1AfterThrowing() {
		System.out.println("===>>> @AfterThrowing method1AfterThrowing()");
	}

	@After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {

		// print out which method we are advising on
		String method = joinPoint.getSignature().toShortString();
		System.out.println("===>>> Executing @After (finally) on method : " + method);
	}

	@After("execution(* com.luv2code.aopdemo.dao.AccountDAO.method1(..))")
	public void method1AfterFinally() {
		System.out.println("===>>> @After (finally) method1AfterFinally()");
	}

	@Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

		// print out method we are advising on
		String method = proceedingJoinPoint.getSignature().toShortString();
		// System.out.println("===>>> Executing @Around (finally) on method : " +
		// method);
		myLogger.info("===>>> Executing @Around (finally) on method : " + method);

		// get begin timestamp
		long start = System.currentTimeMillis();

		// now, let's execute the method
		// proceedingJoinPoint -> handle to target method
		// .proceed() -> Execute the target method
		Object result = null;
		try {
			result = proceedingJoinPoint.proceed();
		} catch (Throwable e) {
			// log the exception
			myLogger.warning(e.getMessage());

			// give user a custom message
			result = "Major accident! But no worries, your private AOP helicopter is on the way!";

			// rethrow exception
			throw e;
		}

		// get end timestamp
		long end = System.currentTimeMillis();

		// compute duration and display it
		long duration = end - start;
		// System.out.println("===>>> Duration : " + duration / 1000.0 + " seconds");
		myLogger.info("===>>> Duration : " + duration / 1000.0 + " seconds");

		return result;
	}

	@Around("execution(* com.luv2code.aopdemo.service.*.method1())")
	public void method1Around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		myLogger.info("===>>> Executing @Around method1Around()");
		proceedingJoinPoint.proceed(); // <-
		/*
		 * If the above line is commented, call will not be made to method1() in
		 * TrafficFortuneService class. The call returns back to main program from here.
		 */
	}
}
