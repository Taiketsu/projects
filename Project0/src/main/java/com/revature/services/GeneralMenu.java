package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.Driver;
import com.revature.model.User;
import com.revature.repository.UserDAOImpl;

public class GeneralMenu extends Menu {
	
	// Start of variables opens the scanner as input
	// Header so no longer need to type the header manually
	// makes an Arraylist that will be used to check user inputs.
	
	public static final String HEADER = "+++++++++++++++++++++++++++++++++++++++++++++";
	public List<User> users = new ArrayList<>();
	private UserDAOImpl userDAO = new UserDAOImpl();
	UserAccountMenu um = new UserAccountMenu();
	EmployeeMenu em = new EmployeeMenu();
	
	//Test logging
	private static Logger log = Logger.getLogger(Driver.class);
	
	
	
	// Start of the menus asks the user what they would like to do and goes from there
	public void startMenu() {
		List<String> list = new ArrayList<>();
		
		log.info("Test start.");
		
		list.add("Welcome to Revature Banking!");
		list.add("What would you like to do today?");
		list.add("log in");
		list.add("sign up");
		list.add("please type your response and use the actions I have given you.");
		
		printMenu(list);
		
		decisionTree();
		
	}
	
	// Handles the logic for user decision then takes them to the correct menu to continue
	private void decisionTree() {
		String s;
		s = INPUT.nextLine();
		switch(s) {
		case "log in":
			System.out.println("Are you an employee?");
			String str = INPUT.nextLine();
			switch(str.toLowerCase()) {
			case "yes":
				System.out.println("Sending to employee login now.");
				em.login();
				break;
			case "no":
				login();
				break;
			default:
				System.out.println("I didn't catch that.");
				System.out.println("Please try again.");
				System.out.println("Press enter to continue");
				startMenu();
			}
			break;
		case "sign up":
			signup();
			break;
		default:
			System.out.println(HEADER);
			System.out.println("I didn't understand that. Please try again.");
			System.out.println(HEADER);
			decisionTree();
		}
	}
	
	// Start of sign up logic prompts the user to enter a user name
	private void signup() {
		System.out.println(HEADER);
		System.out.println("Alright let's get going then!");
		System.out.println("First tell me what you would like your username to be.");
		System.out.println("This is not case sensitive but it does have to be unique!");
		System.out.println(HEADER);
		String s = INPUT.nextLine();
		
		signUpLogic(s);
	}

	// Does multiple things it first makes sure the string entered isn't blank
	// if not it then starts up a for loop that iterates through each user in ther
	// array users. sending them each to check user input. then checks what is returned
	// if true it turns true bool over to true. if it comes back false nothing happens
	// it then sends true bool over to check false to finish the logic.
	private void signUpLogic(String s) {
		if(!s.equals("")) {
			boolean bool = true;
			boolean trueBool = false;
			for(User user : users) {
				bool = checkUserInput(s, user);
				if(bool == true) {
					trueBool = true;
				}
					}
			checkFalse(s, trueBool);
		}else {
			System.out.println(HEADER);
			System.out.println("Your username cannot be blank!");
			System.out.println(HEADER);
			signUpLogic(INPUT.nextLine());
		}
	}
	
	// simply checks the state of trueBool if it remained false it will initiate
	// get user info if true lets the user know the name they tried has already 
	// been taken then takes input and sends them back to signUpLogic() to try again
	private void checkFalse(String s, boolean bool) {
		if(bool == false) {
			getUserInfo(s);
		}else {
			System.out.println(HEADER);
			System.out.println("I'm sorry that was already taken. Please try a new name.");
			System.out.println(HEADER);
			
			signUpLogic(INPUT.nextLine());
		}
	}
	
	// Gets the remaining information needed to fully create a provisional user
	// then sends back to the main menu
	
	private void getUserInfo(String s) {
		String firstName = null;
		String lastName = null;
		String email = null;
		String p = null;
		
		System.out.println(HEADER);
		System.out.println("Username accepted! Please make your password \n"
			+ "This is case sensitive!");
		System.out.println(HEADER);
		
		p = INPUT.nextLine();
		
		System.out.println(HEADER);
		System.out.println("Thanks for that!");
		System.out.println("Let me ask a few questions about you now!");
		System.out.println("What is your First Name?");
		System.out.println(HEADER);
		
		firstName = INPUT.nextLine();
		
		System.out.println(HEADER);
		System.out.println("Thanks!");
		System.out.println("What's your last name?");
		System.out.println(HEADER);
		
		lastName = 	INPUT.nextLine();
		
		System.out.println(HEADER);
		System.out.println("Last question I promise!!");
		System.out.println("What's your email address?");
		System.out.println(HEADER);
		
		email = INPUT.nextLine();
		
		System.out.println(HEADER);
		System.out.println("Okay I am now making your user!");
		System.out.println("You will not be able to log in until we have"
				+ "confirmed all your documentaion.");
		System.out.println("Don't worry we will let you know when that happens.");
		System.out.println("Press enter to confirm!");
		System.out.println(HEADER);
		
		userDAO.insertPending(new User(0,s,p,firstName,lastName,email));
		INPUT.nextLine();
		
		System.out.println(HEADER);
		System.out.println("Alright user has been created!");
		System.out.println("I am now going to send you back to the main menu.");
		System.out.println("Press Enter to continue...");
		System.out.println(HEADER);
		
		INPUT.nextLine();
		startMenu();
	}
	
	// Checks user name returns false if it doesn't match, returns true if it does
	private boolean checkUserInput(String s, User user) {
		if(!s.toLowerCase().equalsIgnoreCase(user.getUserName())) {
			return false;
		}
		return true;
		
	}
	
	// Start of the login logic prompts user for their user name and password
	// it saves the user that was found to match them and then checks the password
	// will then either kick them out if credentials were wrong
	// or will load them into the appropriate menu depending on if they are a customer or
	// an employee
	
	private void login() {
		boolean bool = false;
		User loggedUser = null;
		boolean trueBool = false;
		
		System.out.println(HEADER);
		System.out.println("Alright!");
		System.out.println("Please tell me your username!");
		System.out.println(HEADER);
		
		String s = INPUT.nextLine();
		
		for(User user : users) {
			bool = checkUserInput(s, user);	
			if(bool == true) {
				loggedUser = user;
				trueBool = true;
			}
		}
		if(trueBool == true) {
			System.out.println(HEADER);
			System.out.println("Welcome back, " + loggedUser.getUserName() + "!");
			System.out.println("What is your password?");
			System.out.println(HEADER);
			
			String p = INPUT.nextLine();
			
			if(p.equals(loggedUser.getPassword())) {
				System.out.println(HEADER);
				System.out.println("Alright! I am now logging you in and will"
						+ "redirect you to the correct menu!");
				System.out.println(HEADER);
				
				um.openMenu(loggedUser);
			}else {
				System.out.println(HEADER);
				System.out.println("I am sorry but your password didn't match"
						+ "what I have on file check spelling and try again.");
				System.out.println("Press enter to continue");
				System.out.println(HEADER);
				INPUT.nextLine();
				login();
			}
		}else {
			System.out.println(HEADER);
			System.out.println("I'm sorry I couldn't find a user named that.");
			System.out.println("Please check your spelling and try again.");
			System.out.println("Please press enter to continue.");
			System.out.println(HEADER);
			INPUT.nextLine();
			login();
		}
	}	
	

}
