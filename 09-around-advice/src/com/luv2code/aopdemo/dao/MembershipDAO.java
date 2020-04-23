package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public void addAccount() {
		System.out.println(this.getClass().toString() + " Doing stuff. Adding a member account\n");
	}

	public void displayAccountNumber(String accountNumber) {
		System.out.println(this.getClass().toString() + " : Account Number : " + accountNumber);
	}

}
