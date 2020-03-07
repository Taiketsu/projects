package com.revature;

import com.revature.services.GeneralMenu;
import com.revature.repository.UserDAOImpl;

public class Driver {
	
	static GeneralMenu menu = new GeneralMenu();
	static UserDAOImpl userImpl = new UserDAOImpl();

	public static void main(String[] args) {
		
		// Initializing array list from GeneralMenu()
		// stores all general user info just to check log-in validation
		menu.users = userImpl.getAll();
				
		//Start of the entire
		menu.startMenu();
		
		// closing the scanner opened in start menu.
		menu.INPUT.close();
	}

}
