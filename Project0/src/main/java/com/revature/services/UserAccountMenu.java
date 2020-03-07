package com.revature.services;

import java.util.Scanner;

public class UserAccountMenu {
	
	String st = GeneralMenu.HEADER;
	Scanner sc = GeneralMenu.INPUT;
	String fName = "Nathan";
	String lName = "Mejia";
	int acctNumber = 1;
	double currBal= 100.00;
	double debts = 0;
	double credits = 0;
	
	//opens up the menu 
	public void openMenu() {
		System.out.println(st);
		System.out.println("Welcome in!");
		System.out.println("I'm getting your account info now!");
		System.out.println("Just press enter to continue!!");
		System.out.println(st);
		
		sc.nextLine();
		
		displayAccountInfo();
		
	}
	
	//displays the current account information for the user then asks if the user would
	// like to do anything with their account
	
	public void displayAccountInfo() {
		System.out.println(st);
		System.out.println("Welcome back, " + fName + " " + lName);
		System.out.println("Account Number: " + acctNumber);
		System.out.println("Current Available Balance: " + currBal);
		System.out.println("Pending Debits: " + debts);
		System.out.println("Pending Credits: " + credits);
		System.out.println(st);
		System.out.println("Is there anything that you would like to do?");
		System.out.println("Please enter yes or no.");
		
		handleChoice();
		
	}

	private void handleChoice() {
		
		String choice = sc.nextLine();
		
		switch(choice) {
		case "yes":
			// TODO travel to next menu
			System.out.println("Travelling to next menu");
		case "no":
			System.out.println("No problem!");
			System.out.println("See you later then!!");
			System.exit(0);
		default:
			System.out.println("Sorry I didn't quite get that would you mind trying again?");
			handleChoice();
		}
	}

}
