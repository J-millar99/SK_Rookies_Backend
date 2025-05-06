package mylab.book.entity;

import java.time.LocalDate;

public class Novel extends Publication {
    private String author;
    private String genre;
    
    public Novel() {
    }
    
    public Novel(String title, LocalDate publishDate, int page, int price, String author, String genre) {
        super(title, publishDate, page, price);
        this.author = author;
        this.genre = genre;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }
    
    public String getGenre() {
        return genre;
    }
    
    public void setGenre(String genre) {
        this.genre = genre;
    }
    
    @Override
    public String toString() {
        return super.toString() + " [소설] 저자:" + author + ", 장르:" + genre 
               + ", " + page + "쪽, " + getPriceString() 
               + ", 출판일:" + publishDate;
    }
}