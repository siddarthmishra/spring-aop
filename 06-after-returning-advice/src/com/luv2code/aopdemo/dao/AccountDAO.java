package com.luv2code.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {

	private String name;
	private String serviceCode;

	public String getName() {
		System.out.println(this.getClass().toString() + " in getName()\n");
		return name;
	}

	public void setName(String name) {
		System.out.println(this.getClass().toString() + " in setName()\n");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(this.getClass().toString() + " in getServiceCode()\n");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(this.getClass().toString() + " in setServiceCode()\n");
		this.serviceCode = serviceCode;
	}

	public void addAccount() {
		System.out.println(this.getClass().toString() + " : Doing my DB work: Adding an account\n");
	}

	public String fetchAccountNumber() {
		return this.getClass().toString() + " accountNumber";
	}

	public void addAccount(Account account) {
		System.out.println(
				this.getClass().toString() + " : Doing my DB work: Adding an account with parameter Account\n");
	}

	public void addAccount(Account account, boolean vipFlag) {
		System.out.println(this.getClass().toString()
				+ " : Doing my DB work: Adding an account with parameter Account and boolean\n");
	}

	// add new method: findAccounts()
	public List<Account> findAccounts() {
		List<Account> myAccounts = new ArrayList<Account>();

		// create some sample accounts and add them to account list
		myAccounts.add(new Account("John Doe", "Gold"));
		myAccounts.add(new Account("Foo Bar", "Silver"));
		myAccounts.add(new Account("Madhu", "Platinum"));

		return myAccounts;
	}

	public void method1() {

	}

}
