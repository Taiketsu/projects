package com.revature.repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Account;
import com.revature.model.Employee;
import com.revature.model.User;
import com.revature.util.ConnectionUtil;

public class EmployeeDAOImpl implements EmployeeDAO {


	@Override
	public boolean deleteUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Employee> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee findEmployee(int empID) {
		Employee emp = null;
		
		try (Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "SELECT * FROM employees " + 
						"WHERE emp_id = " + empID;
			
			
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				int id = rs.getInt("emp_ID");
				String userName = rs.getString("user_name");
				String password = rs.getString("password");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				String email = rs.getString("email");
				int salary = rs.getInt("salary");
				String title = rs.getString("title");
				
				
				
				emp = new Employee(id, userName, password, firstName, lastName, email, salary, title);
				//list.add(account);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return emp;
		//return list;
	}

	@Override
	public boolean approveUser(User user, int acctID, double bal) {
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "{ call approvepending(?, ?, ?, ?, ?, ?, ?) }";
			
			CallableStatement stmt = conn.prepareCall(sql);
			
			stmt.setString(1, user.getUserName());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getFirstName());
			stmt.setString(4, user.getLastName());
			stmt.setString(5, user.getEmail());
			stmt.setDouble(6, bal);
			stmt.setInt(7, acctID);
			
			return stmt.execute();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public List<User> getAllPending() {
List<User> list = new ArrayList<>();
		
		try (Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM pendingcustomers";
			
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
	public boolean cancelAccount(User user, Account account) {
			try(Connection conn = ConnectionUtil.getConnection()) {
				
				String sql = "{ call cancel_account(?, ?) }";
				
				CallableStatement stmt = conn.prepareCall(sql);
				
				stmt.setInt(1, user.getId());
				stmt.setInt(2, account.getAccountNumber());
				
				return stmt.execute();
				
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
			return false;
		}
	
		
	}


