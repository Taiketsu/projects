package com.revature;

import com.revature.repository.AccountDAOImpl;
import com.revature.repository.UserDAOImpl;
import com.revature.services.GeneralMenu;
import com.revature.services.UserAccountMenu;

public class Driver {
	
	static GeneralMenu menu = new GeneralMenu();
	static UserDAOImpl userImpl = new UserDAOImpl();
	static UserAccountMenu m2 = new UserAccountMenu();
	
	static AccountDAOImpl aDI = new AccountDAOImpl();

	public static void main(String[] args) {
		
		// Initializing array list from GeneralMenu()
		// stores all general user info just to check log-in validation
		menu.users = userImpl.getAll();
		
		
		//Start of the entire program
		menu.startMenu();
		
		
		//m2.openMenu();
		
		//System.out.println(aDI.findAccount(2).toString());
		
		// closing the scanner opened in start menu.
		GeneralMenu.INPUT.close();
	}

}
