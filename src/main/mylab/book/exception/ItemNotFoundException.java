package mylab.book.exception;

public class ItemNotFoundException extends Exception {
    public ItemNotFoundException() {
        super("�׸��� ã�� �� �����ϴ�.");
    }
    
    public ItemNotFoundException(String message) {
        super(message);
    }
}