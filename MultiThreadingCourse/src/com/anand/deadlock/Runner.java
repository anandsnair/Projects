package com.anand.deadlock;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {

	Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	Account account1 = new Account();
	Account account2 = new Account();

	public void firstThread() throws InterruptedException {
		Random random = new Random();
		for(int i = 0 ; i < 10000 ; i++) {
			lock.lock();	
			try {
				int transferAmount = random.nextInt(100);
				System.out.println("Transfering from account 1 to account 2 : " + transferAmount);
				Account.transfer(account1, account2, transferAmount);
			} finally {
				lock.unlock();
			}
		}
	}
	
	public void secondThread() throws InterruptedException {
		Random random = new Random();
		for(int i = 0 ; i < 10000 ; i++) {
			lock.lock();	
			try {
				int transferAmount = random.nextInt(100);
				System.out.println("Transfering from account 2 to account 1 : " + transferAmount);
				Account.transfer(account2, account1, transferAmount);
			} finally {
				lock.unlock();
			}
		}
	}
	
	public void finished() {
		System.out.println("Account 1 Balance "+  account1.getBalance() + "Account 2 Balance " + account2.getBalance());
		int total = account1.getBalance() + account2.getBalance();
		System.out.println("Total Balance = " + total);
	}
}
