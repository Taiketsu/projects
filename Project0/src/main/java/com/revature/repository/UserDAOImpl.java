package com.revature.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.User;
import com.revature.util.ConnectionUtil;

public class UserDAOImpl implements UserDOA{

	@Override
	public boolean insert(User user) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "INSERT INTO Customers (user_name, password, first_name, last_name, email) VALUES (?, ?, ?, ?, ?)";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, user.getUserName());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getFirstName());
			stmt.setString(4, user.getLastName());
			stmt.setString(5, user.getEmail());
		
			
			return stmt.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return false;
	}
	

	@Override
	public List<User> getAll() {
	List<User> list = new ArrayList<>();
		
		try (Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM customers";
			
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				int id = rs.getInt("customer_id");
				String userName = rs.getString("user_name");
				String password  = rs.getString("password");
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				String email = rs.getString("email");
				
				
				User user = new User(id, userName, password, first_name, last_name, email);
				list.add(user);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}


	@Override
	public boolean insertPending(User user) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "INSERT INTO pendingcustomers (user_name, password, first_name, last_name, email) VALUES (?, ?, ?, ?, ?)";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, user.getUserName());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getFirstName());
			stmt.setString(4, user.getLastName());
			stmt.setString(5, user.getEmail());
		
			
			return stmt.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return false;
	}
}

