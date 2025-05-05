package workshop.account.entity;

public class Account {
	private String custId;
	private String acctId;
	private int balance;
	
	// setter
	public void setCustId(String custId) {
		this.custId = custId;
	}
	
	public void setAcctId(String acctId) {
		this.acctId = acctId;
	}
	
//	public void setBalance(int balance) {
//		this.balance = balance;
//	} 
//	-> 입금 출금으로 대체
	
	// getter
	public String getCustId() {
		return custId;
	}
	
	public String getAcctId() {
		return acctId;
	}
	
	public int getBalance() {
		return balance;
	}
	
	// deposit
	public void deposit(int amount) {
		this.balance += amount;
	}
	
	// withdraw
	public void withdraw(int amount) {
		if (amount > balance) {
			System.out.println("잔액 부족");
		}
		this.balance -= amount;
	}
	
	public static void main(String[] args) {
		
	}
}
