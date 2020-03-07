package com.revature.repository;

import java.util.List;

import com.revature.model.User;

public interface UserDOA {
	
	public boolean insert(User user);
	
	public List<User> getAll();
	
	public boolean insertPending(User user);

}