package mylab.bank.entity;

import mylab.bank.exception.InsufficientBalanceException;
import mylab.bank.exception.WithdrawalLimitExceededException;

public class Account {
	private String accountNumber;
	private String ownerName;
	private double balance;
	private String info;
	
	public Account(String accountNumber, String ownerName, double balance) {
		this.accountNumber = accountNumber;
		this.ownerName = ownerName;
		this.balance = balance;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public void setInfo(String info) {
		this.info = info;
	}
	
	public String getInfo() {
		return info;
	}
	
	public void deposit(double amount) {
		balance += amount;
	}
	
	public void withdraw(double amount) throws InsufficientBalanceException, WithdrawalLimitExceededException {
		if (balance < amount)
			throw new InsufficientBalanceException("��� �ܾ��� �����մϴ�.");
		balance -= amount;
	}

	@Override
	public String toString() {
		return "���¹�ȣ: " + accountNumber + 
				", ������: " + ownerName + 
				", �ܾ�: " + balance + "��";
	}
}