package mylab.book.entity;

import java.time.LocalDate;

public class ReferenceBook extends Publication {
    private String field;
    
    public ReferenceBook() {
    }
    
    public ReferenceBook(String title, LocalDate publishDate, int page, int price, String field) {
        super(title, publishDate, page, price);
        this.field = field;
    }
    
    public String getField() {
        return field;
    }
    
    public void setField(String field) {
        this.field = field;
    }
    
    @Override
    public String toString() {
        return super.toString() + " [참고서] 분야:" + field 
               + ", " + page + "쪽, " + getPriceString() 
               + ", 출판일:" + publishDate;
    }
}