package mylab.bank.entity;

public class SavingAccount extends Account {
	private double interestRate;
	
	public SavingAccount(String accountNumber, 
			String ownerName, double initialBalance, double interestRate) {
		super(accountNumber, ownerName, initialBalance);
		this.interestRate = interestRate / 100;
	}
	
	public double getInterestRate() {
		return interestRate;
	}
	
	public void applyInterest() {
		double ret = getBalance() * interestRate;
		setBalance(getBalance() + ret);
		System.out.println(ret + "���� �ԱݵǾ����ϴ�. ���� �ܾ�: " + getBalance() + "��");
	}
}
