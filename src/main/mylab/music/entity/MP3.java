package mylab.music.entity;

public class MP3 extends DigitalMedia implements Playable {
    private int fileSize; // MB ����
    private int volume;

    public MP3() {
        super();
        this.fileSize = 0;
        this.volume = 5; // �⺻ ���� ����
    }
    
    public MP3(String title, String artist, int fileSize) {
        this(title, artist, "MP3", fileSize);
    }
    
    public MP3(String title, String artist, String format, int fileSize) {
        super(title, artist, format);
        this.fileSize = fileSize;
        this.volume = 5; // �⺻ ���� ����
    }
    
    @Override
    public void setVolume(int volume) {
        this.volume = volume;
        System.out.println("������ " + volume + "�� �����Ǿ����ϴ�.");
    }
    
    @Override
    public void stop() {
        System.out.println("MP3 ����� �����Ǿ����ϴ�.");
    }
    
    @Override
    public void play() {
        super.play(); // �θ� Ŭ������ play �޼ҵ� ȣ��
        System.out.println("���� ����: " + volume);
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("���� ũ��: " + fileSize + "MB");
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