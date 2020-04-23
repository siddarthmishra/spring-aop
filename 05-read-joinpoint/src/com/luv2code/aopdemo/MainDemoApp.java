package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {

		// read the spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

		// get membership bean from spring container
		MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

		// call the business method
		theAccountDAO.addAccount();
		System.out.println(theAccountDAO.fetchAccountNumber() + "\n");
		Account account = new Account();
		account.setName("John Doe");
		account.setLevel("Platinum");
		theAccountDAO.addAccount(account);
		theAccountDAO.addAccount(account, true);

		// call the accountdao getter/setter methods
		theAccountDAO.setName("foobar");
		theAccountDAO.setServiceCode("silver");
		theAccountDAO.getName();
		theAccountDAO.getServiceCode();

		// call membership business method
		theMembershipDAO.addAccount();
		theMembershipDAO.displayAccountNumber("50100102");

		// close the context
		context.close();
	}

}
