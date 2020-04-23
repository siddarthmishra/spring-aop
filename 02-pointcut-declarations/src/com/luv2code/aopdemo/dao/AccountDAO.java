package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {

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

}
