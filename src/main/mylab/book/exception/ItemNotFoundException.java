package mylab.book.exception;

public class ItemNotFoundException extends Exception {
    public ItemNotFoundException() {
        super("항목을 찾을 수 없습니다.");
    }
    
    public ItemNotFoundException(String message) {
        super(message);
    }
}