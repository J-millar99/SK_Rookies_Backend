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
		String ret = "저축 계좌가 생성되었습니다: ";
		Account a = new SavingAccount("AC" + String.valueOf(nextAccountNumber++), 
				ownerName, initialBalance, interestRate);
		SavingAccount temp = (SavingAccount)a;
		a.setInfo(a.toString() + ", 이자율: " + temp.getInterestRate() + "%");
		accounts.add(a);
		return ret + a.getInfo();
	}
	
	public String createCheckingAccount(String ownerName, 
			double initialBalance, double withdrawalLimit) {
		String ret = "체크 계좌가 생성되었습니다: ";
		Account a = new CheckingAccount("AC" + String.valueOf(nextAccountNumber++),
				ownerName, initialBalance, withdrawalLimit);
		CheckingAccount temp = (CheckingAccount)a;
		a.setInfo(a.toString() + ", 출금 한도: " + temp.getWithdrawalLimit() + "원");
		accounts.add(a);
		return ret + a.getInfo();
	}
	
	public Account findAccount(String accountNumber) throws AccountNotFoundException {
		for (Account a : accounts) {
			if (a.getAccountNumber().equals(accountNumber))
				return a;
		}
		throw new AccountNotFoundException(accountNumber + " 계좌번호는 존재하지 않습니다.");
	}
	
	public void deposit(String accountNumber, double amount) {
		try {
			Account a = findAccount(accountNumber);
			a.deposit(amount);
			System.out.println(amount + "원이 입금되었습니다. 현재 잔액: " + a.getBalance() + "원");
		} catch (AccountNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public boolean withdraw(String accountNumber, double amount) {
		try {
			Account a = findAccount(accountNumber);
			a.withdraw(amount);
			System.out.println(amount + "원이 출금되었습니다. 현재 잔액: " + a.getBalance() + "원");
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
		System.out.println("=== 계좌 이체 테스트 ===");
		try {
			// 두 계좌가 존재하는지 먼저 확인
			Account src = findAccount(fromAccountNumber);
			Account dest = findAccount(toAccountNumber);
			
			// 출금을 먼저 시도하고 성공하면 입금 진행
			if (withdraw(fromAccountNumber, amount)) {
				deposit(toAccountNumber, amount);
				System.out.println(amount + "원이 " 
					+ fromAccountNumber + "에서 " 
					+ toAccountNumber + "로 "
					+ "송금되었습니다.");
			} else {
				System.out.println("계좌 이체 실패: 출금할 수 없습니다.");
			}
		} catch (AccountNotFoundException e) {
			System.out.println("계좌 이체 실패: " + e.getMessage());
		}
	}
	
	public void printAllAccounts() {
		System.out.println("===모든 계좌 목록===");
		for (Account a : accounts) {
			System.out.println(a.getInfo());
		}
		System.out.println("===============\n");
	}
}