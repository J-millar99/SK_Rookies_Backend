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
		System.out.println("=== ���� ���� ===");
		System.out.println(bank.createSavingsAccount("ȫ�浿", 10000, 3));
		System.out.println(bank.createCheckingAccount("��ö��", 20000, 5000));
		System.out.println(bank.createSavingsAccount("�̿���", 30000, 2));
		System.out.println();
		bank.printAllAccounts();
	}
	
	public static void testDepositWithdraw(Bank bank) {
		System.out.println("=== �Ա�/��� �׽�Ʈ ===");
		bank.deposit("AC1000", 5000);
		bank.withdraw("AC1001", 3000);
		System.out.println();
	}
	
	public static void testInterest(Bank bank) {
		System.out.println("=== ���� ���� �׽�Ʈ ===");
		try {
			Account a = bank.findAccount("AC1000");
			if (a instanceof SavingAccount) {
				((SavingAccount) a).applyInterest();
			} else {
				System.out.println("AC1000�� ���� ���°� �ƴմϴ�.");
			}
		} catch (AccountNotFoundException e) {
			System.out.println(e.getMessage());
		}
		System.out.println();
	}
	
	public static void testTransfer(Bank bank) {
		System.out.println("=== ���� ��ü �׽�Ʈ ===");
		bank.transfer("AC1002", "AC1001", 10000);
		System.out.println();
	}
	
	public static void testErrorCases(Bank bank) {
		System.out.println("=== ���� ���̽� �׽�Ʈ ===");
		// �������� �ʴ� ����
		System.out.println("1. �������� �ʴ� ���� �׽�Ʈ:");
		bank.withdraw("AC9999", 1000);
		
		// �ܾ� ����
		System.out.println("\n2. �ܾ� ���� �׽�Ʈ:");
		bank.withdraw("AC1001", 100000);
		
		// ��� �ѵ� �ʰ� (üũ ����)
		System.out.println("\n3. ��� �ѵ� �ʰ� �׽�Ʈ:");
		bank.withdraw("AC1001", 10000);
		
		// ��ü ���� ���̽�
		System.out.println("\n4. ��ü ���� �׽�Ʈ:");
		bank.transfer("AC1001", "AC1000", 50000);
		
		System.out.println();
	}
}