package com.luv2code.aopdemo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;

public class AfterThrowingDemoApp {

	public static void main(String[] args) {

		// read the spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

		// call method to find the accounts
		List<Account> accounts = new ArrayList<Account>();
		try {
			boolean tripWire = true;
			accounts = theAccountDAO.findAccounts(tripWire);
		} catch (Throwable e) {
			System.out.println("\n\nMain Program ... caught throwable: " + e);
		}
		// display the accounts
		System.out.println("Main Program : AfterThrowingDemoApp");
		System.out.println(accounts);
		System.out.println("\n");

		try {
			theAccountDAO.method1(true);
		} catch (Throwable e) {
			System.out.println("\n\nMain Program ... caught exception: " + e);
		}

		// close the context
		context.close();
	}

}
