package workshop.account.exception;

public class InsufficientBalanceException extends Exception {
	public InsufficientBalanceException(String errMessage) {
		// 부모의 생성자를 호출
		super(errMessage);
	}
}
