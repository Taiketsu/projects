package com.revature.repository;

import java.util.List;

import com.revature.model.Account;
import com.revature.model.Employee;
import com.revature.model.User;

public interface EmployeeDAO {
	
	
	public boolean approveUser(User user, int acctID, double bal);
	public boolean deleteUser(User user);
	public Employee findEmployee(int id);
	public List<Employee> getAll();
	public List<User> getAllPending();
	public boolean cancelAccount(User user, Account acct);
	

}
