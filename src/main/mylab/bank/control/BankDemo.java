package mylab.bank.control;

import mylab.bank.entity.Account;
import mylab.bank.entity.Bank;
import mylab.bank.entity.SavingAccount;
import mylab.bank.exception.AccountNotFoundException;

public class BankDemo {
	public static void main(String[] args) {
		Bank bank = new Bank();
		testCreateAccount(bank);
		testDepositWithdraw(bank);
		testInterest(bank);
		testTransfer(bank);
		testErrorCases(bank);
	}
	
	public static void testCreateAccount(Bank bank) {
		System.out.println("=== 계좌 생성 ===");
		System.out.println(bank.createSavingsAccount("홍길동", 10000, 3));
		System.out.println(bank.createCheckingAccount("김철수", 20000, 5000));
		System.out.println(bank.createSavingsAccount("이영희", 30000, 2));
		System.out.println();
		bank.printAllAccounts();
	}
	
	public static void testDepositWithdraw(Bank bank) {
		System.out.println("=== 입금/출금 테스트 ===");
		bank.deposit("AC1000", 5000);
		bank.withdraw("AC1001", 3000);
		System.out.println();
	}
	
	public static void testInterest(Bank bank) {
		System.out.println("=== 이자 적용 테스트 ===");
		try {
			Account a = bank.findAccount("AC1000");
			if (a instanceof SavingAccount) {
				((SavingAccount) a).applyInterest();
			} else {
				System.out.println("AC1000은 저축 계좌가 아닙니다.");
			}
		} catch (AccountNotFoundException e) {
			System.out.println(e.getMessage());
		}
		System.out.println();
	}
	
	public static void testTransfer(Bank bank) {
		System.out.println("=== 정상 이체 테스트 ===");
		bank.transfer("AC1002", "AC1001", 10000);
		System.out.println();
	}
	
	public static void testErrorCases(Bank bank) {
		System.out.println("=== 오류 케이스 테스트 ===");
		// 존재하지 않는 계좌
		System.out.println("1. 존재하지 않는 계좌 테스트:");
		bank.withdraw("AC9999", 1000);
		
		// 잔액 부족
		System.out.println("\n2. 잔액 부족 테스트:");
		bank.withdraw("AC1001", 100000);
		
		// 출금 한도 초과 (체크 계좌)
		System.out.println("\n3. 출금 한도 초과 테스트:");
		bank.withdraw("AC1001", 10000);
		
		// 이체 실패 케이스
		System.out.println("\n4. 이체 실패 테스트:");
		bank.transfer("AC1001", "AC1000", 50000);
		
		System.out.println();
	}
}