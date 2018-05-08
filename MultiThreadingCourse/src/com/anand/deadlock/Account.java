package com.anand.deadlock;

public class Account {

	private int balance = 100000;
	
	public void deposit(int amount) {
		balance = balance+amount;
	}
	
	public void withdraw(int amount) {
		balance = balance-amount;
	}
		
	public int getBalance() {
		return balance;
	}

	public static void transfer(Account depositAccount, Account withdrawAccount, int amount) {
		depositAccount.deposit(amount);
		withdrawAccount.withdraw(amount);
	}
}
