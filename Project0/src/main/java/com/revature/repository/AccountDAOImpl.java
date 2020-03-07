package com.revature.repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Account;
import com.revature.util.ConnectionUtil;

public class AccountDAOImpl implements AccountDAO {

	@Override
	public boolean insert(Account account) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "INSERT INTO account (balance) VALUES (?)";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setDouble(1, account.getTotalAmount());
			
		
			
			return stmt.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return false;
	}
	

	@Override
	public List<Account> getAll() {
		
		List<Account> list = new ArrayList<>();
		
		try (Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM account";
			
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				int id = rs.getInt("account_number");
				double balance = rs.getDouble("balance");
				
				
				
				Account account = new Account(id, balance, 0, 0);
				list.add(account);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}