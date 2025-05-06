package mylab.book.entity;

import java.time.LocalDate;

public class Magazine extends Publication {
    private String publishPeriod;
    
    public Magazine() {
    }
    
    public Magazine(String title, LocalDate publishDate, int page, int price, String publishPeriod) {
        super(title, publishDate, page, price);
        this.publishPeriod = publishPeriod;
    }
    
    public String getPublishPeriod() {
        return publishPeriod;
    }
    
    public void setPublishPeriod(String publishPeriod) {
        this.publishPeriod = publishPeriod;
    }
    
    @Override
    public String toString() {
        return super.toString() + " [����] �����ֱ�:" + publishPeriod 
               + ", " + page + "��, " + getPriceString() 
               + ", ������:" + publishDate;
    }
}