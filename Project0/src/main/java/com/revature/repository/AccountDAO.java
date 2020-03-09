package com.revature.repository;

import java.util.List;

import com.revature.model.Account;

public interface AccountDAO {
	
	public boolean insert(Account account);
	public Account findAccount(int i);
	public List<Account> getAll();
	public boolean withdraw(Account acc, double amount);
	public boolean deposit(Account acc, double amount);
	public boolean transfer(Account acc, double amount, int target);
	public Account findAccountNumber(int i);
}
