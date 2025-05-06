package mylab.book.entity;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class Publication {
    protected String title;
    protected LocalDate publishDate;
    protected int page;
    protected int price;
    
    public Publication() {
    }
    
    public Publication(String title, LocalDate publishDate, int page, int price) {
        this.title = title;
        this.publishDate = publishDate;
        this.page = page;
        this.price = price;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public LocalDate getPublishDate() {
        return publishDate;
    }
    
    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }
    
    public int getPage() {
        return page;
    }
    
    public void setPage(int page) {
        this.page = page;
    }
    
    public int getPrice() {
        return price;
    }
    
    public void setPrice(int price) {
        this.price = price;
    }
    
    public String getPriceString() {
        DecimalFormat formatter = new DecimalFormat("#,###");
        return formatter.format(price) + "¿ø";
    }
    
    @Override
    public String toString() {
        return title;
    }
}