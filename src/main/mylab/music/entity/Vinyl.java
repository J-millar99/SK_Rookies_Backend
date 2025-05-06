package mylab.music.entity;
public class Vinyl extends MusicMedia {
    private int rpm;  // ȸ�� �ӵ�
    
    public Vinyl() {
        super();
        this.rpm = 33;  // �⺻ ȸ�� �ӵ�
    }
    
    public Vinyl(String title, String artist, int rpm) {
        super(title, artist);
        this.rpm = rpm;
    }
    
    @Override
    public void play() {
        System.out.println("���̴� ���ڵ� '" + title + "'��(��) " + rpm + "rpm���� ����˴ϴ�.");
    }
    
    public void clean() {
        System.out.println("���̴� ���ڵ带 û���մϴ�.");
    }
   
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("ȸ�� �ӵ�: " + rpm + " rpm");
    }
    
    public int getRpm() {
        return rpm;
    }
    
    public void setRpm(int rpm) {
        this.rpm = rpm;
    }
}