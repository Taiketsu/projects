package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import com.revature.model.Account;
import com.revature.model.User;
import com.revature.repository.AccountDAOImpl;

public class UserAccountMenu extends Menu {
	
	
	
	AccountDAOImpl aDI = new AccountDAOImpl();
	
	String fName;
	String lName;
	int acctNumber;
	double currBal;
	double debts;
	double credits;
	Account acct;
	
	//opens up the menu 
	public void openMenu(User user) {
		List<String> list = new ArrayList<>();
		acct =  aDI.findAccount(user.getId());
		
		fName = user.getFirstName();
		lName = user.getLastName();
		acctNumber = acct.getAccountNumber();
		currBal = acct.getTotalAmount();
		debts = acct.getDebitAmount();
		credits = acct.getCreditAmount();
			
		list.add("Welcome in!");
		list.add("I'm getting your account info now!");
		list.add("Just press enter to continue!!");
		
		printMenu(list);
		
		INPUT.nextLine();
		
		displayAccountInfo();
		
	}
	
	//displays the current account information for the user then asks if the user would
	// like to do anything with their account
	
	public void displayAccountInfo() {
		
		List<String> list = new ArrayList<>();
		
		// adds choices to be printed from my print menu function
		list.add("Welcome back, " + fName + " " + lName);
		list.add("Account Number: " + acctNumber);
		list.add("Current Available Balance: " + currBal);
		list.add("Is there anything that you would like to do?");
		list.add("Please enter yes or no.");
		
		printMenu(list);
		
		handleChoice();
		
	}

	private void handleChoice() {
//		
		String choice = INPUT.nextLine();
		
		switch(choice) {
		case "yes":
			nextMenu();
			break;
		case "no":
			System.out.println("No problem!");
			System.out.println("See you later then!!");
			System.exit(0);
			break;
		default:
			System.out.println("Sorry I didn't quite get that would you mind trying again?");
			handleChoice();
		}
	}
	
	private void nextMenu() {
		List<String> list = new ArrayList<>();
		
		list.add("What would you like to do?");
		list.add("Deposit");
		list.add("Withdraw");
		list.add("Transfer");
		
		printMenu(list);
		
		list.clear();
		
		switch(INPUT.nextLine().toLowerCase()) {
		case "deposit":
			depositMoney();
			break;
		case "withdraw":
			withdrawMoney();
			break;
		case "transfer":
			transferMoney();
			break;
		default:
			list.add("Sorry I didn't catch that please try again");
			list.add("Press Enter to continue");
			
			printMenu(list);
			
			INPUT.nextLine();
			
			nextMenu();
		}
	}

	private void transferMoney() {
		System.out.println("How much would you like to transfer?");
		
		String input = INPUT.nextLine();
		while(!isNumber(input)) {
			System.out.println("Sorry but you must enter a number");
			System.out.println("Please try again!");
			System.out.println("Please enter a number.");
			
			INPUT.nextLine();
			
			}		
				
			double amount = Double.parseDouble(input);
			
			System.out.println("What account did you want to transfer to?");
			
			input = INPUT.nextLine();
			while(!isInt(input)) {
				System.out.println("Sorry but you must enter a number");
				System.out.println("Please try again!");
				System.out.println("Please enter a number.");
				
				INPUT.nextLine();
			}
			
			int otherAcct = Integer.parseInt(input);
			
		if(amount <=0 || otherAcct <=0 ) {
			System.out.println("Sorry! amount or account ID cannot be 0 or less than 0");
			System.out.println("Please try again!");
			System.out.println("Press enter to continue..");
				
			INPUT.nextLine();
			transferMoney();
		}else {
			System.out.println("Alright I am transferring the funds now!");
			aDI.transfer(acct, amount, otherAcct);
			currBal -= amount;
			System.out.println("Alright that's done now!");
			System.out.println("I'll send you back to the previous menu!");
			System.out.println("Press enter to continue...");
					
			INPUT.nextLine();
			displayAccountInfo();
		}	
		
	}

	private void depositMoney() {
		List<String> list = new ArrayList<>();
		
		list.add("How much would you like to deposit?");
		
		printMenu(list);
		
		String input = INPUT.nextLine();
		
		list.clear();
		while(!isNumber(input)) {
			list.add("Sorry but you must enter a number");
			list.add("Please try again!");
			list.add("Please enter to a number now");
			
			printMenu(list);
			INPUT.nextLine();
			
			list.clear();
			
			}		
				
			double amount = Double.parseDouble(input);
			
			
		if(amount <=0) {
			list.add("Sorry! amount cannot be 0 or less than 0");
			list.add("Please try again!");
			list.add("Press enter to continue..");
			
			printMenu(list);
			
			list.clear();
			INPUT.nextLine();
			depositMoney();
		}else {
			System.out.println("Alright I am depositing into the account now!");
			aDI.deposit(acct, amount);
			currBal += amount;
			list.add("Alright that's done now!");
			list.add("I'll send you back to the previous menu!");
			list.add("Press enter to continue...");
			
			printMenu(list);
			
			list.clear();
			INPUT.nextLine();
			displayAccountInfo();
		}	
	}

	private void withdrawMoney() {
		System.out.println("How much would you like to withdraw?");
		
		String input = INPUT.nextLine();
		if(isNumber(input)) {
			double amount = Double.parseDouble(input);
			
			if(amount <=0) {
				System.out.println("Sorry! amount cannot be 0 or less than 0");
				System.out.println("Please try again!");
				System.out.println("Press enter to continue..");
				
				INPUT.nextLine();
				withdrawMoney();
			}else {
				System.out.println("Alright I am withdrawing from the account now!");
				aDI.withdraw(acct, amount);
					currBal -= amount;
					System.out.println("Alright that's done now!");
					System.out.println("I'll send you back to the previous menu!");
					System.out.println("Press enter to continue...");
					
					INPUT.nextLine();
					displayAccountInfo();
				}	
		}else {
			System.out.println("Sorry but you must enter a number");
			System.out.println("Please try again!");
			System.out.println("Press enter to continue...");
			
			INPUT.nextLine();
			withdrawMoney();
		}
	}

}
