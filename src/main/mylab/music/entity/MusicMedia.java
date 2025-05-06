package mylab.music.entity;

public abstract class MusicMedia {
    protected String title;
    protected String artist;
    
    public MusicMedia() {
        this.title = "";
        this.artist = "";
    }
    
    public MusicMedia(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }
    
    public abstract void play();
    
    public void displayInfo() {
        System.out.println("제목: " + title + ", 아티스트: " + artist);
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getArtist() {
        return artist;
    }
    
    public void setArtist(String artist) {
        this.artist = artist;
    }
}