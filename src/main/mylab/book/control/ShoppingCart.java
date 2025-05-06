package mylab.book.control;

import mylab.book.entity.*;
import mylab.book.exception.ItemNotFoundException;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private ArrayList<Publication> items;
    
    public ShoppingCart() {
        this.items = new ArrayList<>();
    }
    
    public void addItem(Publication item) {
        items.add(item);
        System.out.println(item.getTitle() + "이(가) 장바구니에 추가되었습니다.");
    }
    
    public boolean removeItem(String title) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getTitle().equals(title)) {
                Publication removed = items.remove(i);
                System.out.println(removed.getTitle() + "이(가) 장바구니에서 제거되었습니다.");
                return true;
            }
        }
        System.out.println("장바구니에서 " + title + "을(를) 찾을 수 없습니다.");
        return false;
    }
    
    public void displayCart() {
        if (items.isEmpty()) {
            System.out.println("장바구니가 비어있습니다.");
            return;
        }
        
        System.out.println("===== 장바구니 내용 =====");
        DecimalFormat formatter = new DecimalFormat("#,###");
        
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + ". " + items.get(i));
        }
        
        int totalPrice = calculateTotalPrice();
        int discountedPrice = calculateDiscountedPrice();
        
        System.out.println("\n총 가격: " + formatter.format(totalPrice) + "원");
        System.out.println("할인 적용 가격: " + formatter.format(discountedPrice) + "원");
        System.out.println("절약된 금액: " + formatter.format(totalPrice - discountedPrice) + "원");
        System.out.println("=========================");
    }
    
    public int calculateTotalPrice() {
        int total = 0;
        for (Publication item : items) {
            total += item.getPrice();
        }
        return total;
    }
    
    public int calculateDiscountedPrice() {
        int discountedTotal = 0;
        
        for (Publication item : items) {
            if (item instanceof Magazine) {
                discountedTotal += item.getPrice() * 0.9;
            } else if (item instanceof Novel) {
                discountedTotal += item.getPrice() * 0.85;
            } else if (item instanceof ReferenceBook) {
                discountedTotal += item.getPrice() * 0.8;
            } else {
                discountedTotal += item.getPrice();
            }
        }
        
        return discountedTotal;
    }
    
    public void printStatistics() {
        if (items.isEmpty()) {
            System.out.println("장바구니가 비어있습니다. 통계를 계산할 수 없습니다.");
            return;
        }
        
        Map<String, Integer> typeCounts = new HashMap<>();
        
        for (Publication item : items) {
            String type;
            if (item instanceof Novel) {
                type = "소설";
            } else if (item instanceof Magazine) {
                type = "잡지";
            } else if (item instanceof ReferenceBook) {
                type = "참고서";
            } else {
                type = "기타";
            }
            
            typeCounts.put(type, typeCounts.getOrDefault(type, 0) + 1);
        }
        
        System.out.println("\n===== 장바구니 통계 =====");
        System.out.println("총 항목 수: " + items.size());
        
        System.out.println("타입별 수량:");
        for (Map.Entry<String, Integer> entry : typeCounts.entrySet()) {
            System.out.println("- " + entry.getKey() + ": " + entry.getValue() + "개");
        }
        System.out.println("=======================");
    }
    
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        
        Magazine magazine1 = new Magazine("마이크로소프트", LocalDate.of(2007, 10, 1), 328, 9900, "매월");
        Magazine magazine2 = new Magazine("경영과컴퓨터", LocalDate.of(2007, 10, 3), 316, 9000, "매월");
        Novel novel1 = new Novel("빠삐용", LocalDate.of(2007, 7, 1), 396, 9800, "베르나르베르베르", "현대소설");
        Novel novel2 = new Novel("남한산성", LocalDate.of(2007, 4, 14), 383, 11000, "김훈", "대하소설");
        ReferenceBook ref1 = new ReferenceBook("실용주의프로그래머", LocalDate.of(2007, 1, 14), 496, 25000, "소프트웨어공학");
        
        cart.addItem(magazine1);
        cart.addItem(magazine2);
        cart.addItem(novel1);
        cart.addItem(novel2);
        cart.addItem(ref1);
        
        cart.displayCart();
        
        cart.printStatistics();
        
        cart.removeItem("빠삐용");
        
        cart.displayCart();
    }
}