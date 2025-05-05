package workshop.account.entity;

public class Account {
	private String custId;
	private String acctId;
	private int balance;
	
	// Default Constructor (생성자 : 객체가 생성될 때 호출)
	public Account() {
		System.out.println("Default Constructor Called..");
		
	}
	
	// Constructor Overloading (생성자 중복정의)
	public Account(String custId, String acctId, int balance) {
		this.custId = custId;
		this.acctId = acctId;
		this.balance = balance;
	}

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
}
