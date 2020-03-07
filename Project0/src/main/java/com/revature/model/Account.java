package com.revature.model;

public class Account {
	
	private int accountNumber;
	private double totalAmount;
	private double debitAmount;
	private double creditAmount;
	
	public Account() {
		super();
		// Auto-generated constructor stub
	}

	public Account(int accountNumber, double totalAmount, double debitAmount, double creditAmount) {
		super();
		this.accountNumber = accountNumber;
		this.totalAmount = totalAmount;
		this.debitAmount = debitAmount;
		this.creditAmount = creditAmount;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public double getDebitAmount() {
		return debitAmount;
	}

	public void setDebitAmount(double debitAmount) {
		this.debitAmount = debitAmount;
	}

	public double getCreditAmount() {
		return creditAmount;
	}

	public void setCreditAmount(double creditAmount) {
		this.creditAmount = creditAmount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountNumber;
		long temp;
		temp = Double.doubleToLongBits(creditAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(debitAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(totalAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Account))
			return false;
		Account other = (Account) obj;
		if (accountNumber != other.accountNumber)
			return false;
		if (Double.doubleToLongBits(creditAmount) != Double.doubleToLongBits(other.creditAmount))
			return false;
		if (Double.doubleToLongBits(debitAmount) != Double.doubleToLongBits(other.debitAmount))
			return false;
		if (Double.doubleToLongBits(totalAmount) != Double.doubleToLongBits(other.totalAmount))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", totalAmount=" + totalAmount + ", debitAmount="
				+ debitAmount + ", creditAmount=" + creditAmount + "]";
	}


	
	
}