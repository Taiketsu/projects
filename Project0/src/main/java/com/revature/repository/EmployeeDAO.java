package com.revature.repository;

import java.util.List;

import com.revature.model.Employee;
import com.revature.model.User;

public interface EmployeeDAO {
	
	public boolean insert(Employee emp);
	public boolean insertUser(User user);
	public boolean deleteUser(User user);
	public List<Employee> getAll();
	

}
