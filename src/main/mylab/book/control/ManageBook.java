package mylab.book.control;

import mylab.book.entity.*;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class ManageBook {
    
    public static void main(String[] args) {
        Publication[] publications = createPublications();
        
        printPublications(publications);
        
        System.out.println("\n==== ���� ���� ====");
        String targetBook = "�ۺ������ʴ´�";
        int targetIndex = -1;
        
        for (int i = 0; i < publications.length; i++) {
            if (publications[i].getTitle().equals(targetBook)) {
                targetIndex = i;
                break;
            }
        }
        
        if (targetIndex != -1) {
            int originalPrice = publications[targetIndex].getPrice();
            System.out.println(targetBook + " ���� �� ����: " + new DecimalFormat("#,###").format(originalPrice) + "��");
            
            modifyPrice(publications[targetIndex]);
            
            int newPrice = publications[targetIndex].getPrice();
            System.out.println(targetBook + " ���� �� ����: " + new DecimalFormat("#,###").format(newPrice) + "��");
            System.out.println("����: " + new DecimalFormat("#,###").format(originalPrice - newPrice) + "��");
        }
        
        StatisticsAnalyzer analyzer = new StatisticsAnalyzer();
        analyzer.printStatistics(publications);
    }
    
    private static Publication[] createPublications() {
        Publication[] publications = new Publication[7];
        
        publications[0] = new Magazine("����ũ�μ���Ʈ", LocalDate.of(2007, 10, 1), 328, 9900, "�ſ�");
        publications[1] = new Magazine("�濵����ǻ��", LocalDate.of(2007, 10, 3), 316, 9000, "�ſ�");
        publications[2] = new Novel("���߿�", LocalDate.of(2007, 7, 1), 396, 9800, "����������������", "����Ҽ�");
        publications[3] = new Novel("���ѻ꼺", LocalDate.of(2007, 4, 14), 383, 11000, "����", "���ϼҼ�");
        publications[4] = new ReferenceBook("�ǿ��������α׷���", LocalDate.of(2007, 1, 14), 496, 25000, "����Ʈ�������");
        publications[5] = new Novel("�ҳ��̿´�", LocalDate.of(2014, 5, 1), 216, 15000, "�Ѱ�", "����Ҽ�");
        publications[6] = new Novel("�ۺ������ʴ´�", LocalDate.of(2021, 9, 9), 332, 15120, "�Ѱ�", "����Ҽ�");
        
        return publications;
    }
    
    private static void printPublications(Publication[] publications) {
        System.out.println("==== ���� ���� ��� ====");
        for (int i = 0; i < publications.length; i++) {
            System.out.println((i + 1) + ". " + publications[i]);
        }
    }
    
    private static void modifyPrice(Publication pub) {
        if (pub instanceof Magazine) {
            pub.setPrice((int)(pub.getPrice() * 0.6));
        } else if (pub instanceof Novel) {
            pub.setPrice((int)(pub.getPrice() * 0.8));
        } else if (pub instanceof ReferenceBook) {
            pub.setPrice((int)(pub.getPrice() * 0.9));
        }
    }
}