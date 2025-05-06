package mylab.bank.entity;

import mylab.bank.exception.InsufficientBalanceException;
import mylab.bank.exception.WithdrawalLimitExceededException;

public class CheckingAccount extends Account {
	private double withdrawalLimit;
	
	public CheckingAccount(String accountNumber, 
			String ownerName, double initialBalance, double withdrawalLimit) {
		super(accountNumber, ownerName, initialBalance);
		this.withdrawalLimit = withdrawalLimit;
	}
	
	public double getWithdrawalLimit() {
		return withdrawalLimit;
	}
	
	@Override
	public void withdraw(double amount) throws InsufficientBalanceException, WithdrawalLimitExceededException {
		if (getBalance() < amount)
			throw new InsufficientBalanceException("��� �ܾ��� �����մϴ�.");
		if (withdrawalLimit < amount)
			throw new WithdrawalLimitExceededException("��� �ѵ��� �ʰ��߽��ϴ�.");
		setBalance(getBalance() - amount);
	}
}