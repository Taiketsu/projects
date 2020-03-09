package com.revature.services;

import java.util.List;
import java.util.Scanner;

public class Menu {
	
	public static final String HEADER = "+++++++++++++++++++++++++++++++++++++++++++++";
	public static final Scanner INPUT = new Scanner(System.in);
	
	// uses a for loop to print messages
		public void printMenu(List<String> list) {
			System.out.println(HEADER);
			for(String s : list) {
				System.out.println(s);
			}
			System.out.println(HEADER);
		}
		
		public boolean isNumber(String input) {
			if(input == null) {
				return false;
			}
			try {
				Double.parseDouble(input);
				
			}catch(NumberFormatException e) {
				return false;
			}
			
			return true;
		}
		
		public boolean isInt(String input) {
			if(input == null) {
				return false;
			}
			try {
				Integer.parseInt(input);
				
			}catch(NumberFormatException e) {
				return false;
			}
			
			return true;
		}

}
