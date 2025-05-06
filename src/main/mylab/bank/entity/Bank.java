package mylab.bank.entity;

import java.util.ArrayList;
import java.util.List;

import mylab.bank.exception.AccountNotFoundException;
import mylab.bank.exception.InsufficientBalanceException;
import mylab.bank.exception.WithdrawalLimitExceededException;

public class Bank {
	private List<Account> accounts;
	private int nextAccountNumber;
	
	public Bank() {
		accounts = new ArrayList<>();
		nextAccountNumber = 1000;
	}
	
	public String createSavingsAccount(String ownerName, 
			double initialBalance, double interestRate) {
		String ret = "���� ���°� �����Ǿ����ϴ�: ";
		Account a = new SavingAccount("AC" + String.valueOf(nextAccountNumber++), 
				ownerName, initialBalance, interestRate);
		SavingAccount temp = (SavingAccount)a;
		a.setInfo(a.toString() + ", ������: " + temp.getInterestRate() + "%");
		accounts.add(a);
		return ret + a.getInfo();
	}
	
	public String createCheckingAccount(String ownerName, 
			double initialBalance, double withdrawalLimit) {
		String ret = "üũ ���°� �����Ǿ����ϴ�: ";
		Account a = new CheckingAccount("AC" + String.valueOf(nextAccountNumber++),
				ownerName, initialBalance, withdrawalLimit);
		CheckingAccount temp = (CheckingAccount)a;
		a.setInfo(a.toString() + ", ��� �ѵ�: " + temp.getWithdrawalLimit() + "��");
		accounts.add(a);
		return ret + a.getInfo();
	}
	
	public Account findAccount(String accountNumber) throws AccountNotFoundException {
		for (Account a : accounts) {
			if (a.getAccountNumber().equals(accountNumber))
				return a;
		}
		throw new AccountNotFoundException(accountNumber + " ���¹�ȣ�� �������� �ʽ��ϴ�.");
	}
	
	public void deposit(String accountNumber, double amount) {
		try {
			Account a = findAccount(accountNumber);
			a.deposit(amount);
			System.out.println(amount + "���� �ԱݵǾ����ϴ�. ���� �ܾ�: " + a.getBalance() + "��");
		} catch (AccountNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public boolean withdraw(String accountNumber, double amount) {
		try {
			Account a = findAccount(accountNumber);
			a.withdraw(amount);
			System.out.println(amount + "���� ��ݵǾ����ϴ�. ���� �ܾ�: " + a.getBalance() + "��");
			return true;
		} catch (AccountNotFoundException e) {
			System.out.println(e.getMessage());
			return false;
		} catch (InsufficientBalanceException e) {
			System.out.println(e.getMessage());
			return false;
		} catch (WithdrawalLimitExceededException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public void transfer(String fromAccountNumber, String toAccountNumber, double amount) {
		System.out.println("=== ���� ��ü �׽�Ʈ ===");
		try {
			// �� ���°� �����ϴ��� ���� Ȯ��
			Account src = findAccount(fromAccountNumber);
			Account dest = findAccount(toAccountNumber);
			
			// ����� ���� �õ��ϰ� �����ϸ� �Ա� ����
			if (withdraw(fromAccountNumber, amount)) {
				deposit(toAccountNumber, amount);
				System.out.println(amount + "���� " 
					+ fromAccountNumber + "���� " 
					+ toAccountNumber + "�� "
					+ "�۱ݵǾ����ϴ�.");
			} else {
				System.out.println("���� ��ü ����: ����� �� �����ϴ�.");
			}
		} catch (AccountNotFoundException e) {
			System.out.println("���� ��ü ����: " + e.getMessage());
		}
	}
	
	public void printAllAccounts() {
		System.out.println("===��� ���� ���===");
		for (Account a : accounts) {
			System.out.println(a.getInfo());
		}
		System.out.println("===============\n");
	}
}