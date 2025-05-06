package mylab.music.entity;

public class MP3 extends DigitalMedia implements Playable {
    private int fileSize; // MB 단위
    private int volume;

    public MP3() {
        super();
        this.fileSize = 0;
        this.volume = 5; // 기본 볼륨 설정
    }
    
    public MP3(String title, String artist, int fileSize) {
        this(title, artist, "MP3", fileSize);
    }
    
    public MP3(String title, String artist, String format, int fileSize) {
        super(title, artist, format);
        this.fileSize = fileSize;
        this.volume = 5; // 기본 볼륨 설정
    }
    
    @Override
    public void setVolume(int volume) {
        this.volume = volume;
        System.out.println("볼륨이 " + volume + "로 설정되었습니다.");
    }
    
    @Override
    public void stop() {
        System.out.println("MP3 재생이 중지되었습니다.");
    }
    
    @Override
    public void play() {
        super.play(); // 부모 클래스의 play 메소드 호출
        System.out.println("현재 볼륨: " + volume);
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("파일 크기: " + fileSize + "MB");
    }
    
    public int getFileSize() {
        return fileSize;
    }
    
    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }
    
    public int getVolume() {
        return volume;
    }
}