package com.luv2code.aopdemo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;

public class AfterFinallyDemoApp {

	public static void main(String[] args) {

		// read the spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

		// call method to find the accounts
		List<Account> accounts = new ArrayList<Account>();
		try {
			boolean tripWire = false;
			System.out.println("==========Calling findAccounts()==========");
			accounts = theAccountDAO.findAccounts(tripWire);
			System.out.println("\n");
			tripWire = true; // exception case
			System.out.println("==========Calling findAccounts()==========");
			accounts = theAccountDAO.findAccounts(tripWire);
		} catch (Exception e) {
			System.out.println("\nMain Program ... caught exception: " + e);
		}
		// display the accounts
		System.out.println("Main Program : AfterFinallyDemoApp");
		System.out.println(accounts);
		System.out.println("\n");

		try {
			System.out.println("==========Calling method1()==========");
			theAccountDAO.method1(false);
			System.out.println("\n");
			System.out.println("==========Calling method1()==========");
			theAccountDAO.method1(true); // exception case
		} catch (Exception e) {
			System.out.println("\nMain Program ... caught exception: " + e);
		}

		// close the context
		context.close();
	}

}
