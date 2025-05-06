package mylab.book.control;

import mylab.book.entity.*;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class ManageBook {
    
    public static void main(String[] args) {
        Publication[] publications = createPublications();
        
        printPublications(publications);
        
        System.out.println("\n==== 가격 변경 ====");
        String targetBook = "작별하지않는다";
        int targetIndex = -1;
        
        for (int i = 0; i < publications.length; i++) {
            if (publications[i].getTitle().equals(targetBook)) {
                targetIndex = i;
                break;
            }
        }
        
        if (targetIndex != -1) {
            int originalPrice = publications[targetIndex].getPrice();
            System.out.println(targetBook + " 변경 전 가격: " + new DecimalFormat("#,###").format(originalPrice) + "원");
            
            modifyPrice(publications[targetIndex]);
            
            int newPrice = publications[targetIndex].getPrice();
            System.out.println(targetBook + " 변경 후 가격: " + new DecimalFormat("#,###").format(newPrice) + "원");
            System.out.println("차액: " + new DecimalFormat("#,###").format(originalPrice - newPrice) + "원");
        }
        
        StatisticsAnalyzer analyzer = new StatisticsAnalyzer();
        analyzer.printStatistics(publications);
    }
    
    private static Publication[] createPublications() {
        Publication[] publications = new Publication[7];
        
        publications[0] = new Magazine("마이크로소프트", LocalDate.of(2007, 10, 1), 328, 9900, "매월");
        publications[1] = new Magazine("경영과컴퓨터", LocalDate.of(2007, 10, 3), 316, 9000, "매월");
        publications[2] = new Novel("빠삐용", LocalDate.of(2007, 7, 1), 396, 9800, "베르나르베르베르", "현대소설");
        publications[3] = new Novel("남한산성", LocalDate.of(2007, 4, 14), 383, 11000, "김훈", "대하소설");
        publications[4] = new ReferenceBook("실용주의프로그래머", LocalDate.of(2007, 1, 14), 496, 25000, "소프트웨어공학");
        publications[5] = new Novel("소년이온다", LocalDate.of(2014, 5, 1), 216, 15000, "한강", "장편소설");
        publications[6] = new Novel("작별하지않는다", LocalDate.of(2021, 9, 9), 332, 15120, "한강", "장편소설");
        
        return publications;
    }
    
    private static void printPublications(Publication[] publications) {
        System.out.println("==== 도서 정보 출력 ====");
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