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
        System.out.println(item.getTitle() + "��(��) ��ٱ��Ͽ� �߰��Ǿ����ϴ�.");
    }
    
    public boolean removeItem(String title) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getTitle().equals(title)) {
                Publication removed = items.remove(i);
                System.out.println(removed.getTitle() + "��(��) ��ٱ��Ͽ��� ���ŵǾ����ϴ�.");
                return true;
            }
        }
        System.out.println("��ٱ��Ͽ��� " + title + "��(��) ã�� �� �����ϴ�.");
        return false;
    }
    
    public void displayCart() {
        if (items.isEmpty()) {
            System.out.println("��ٱ��ϰ� ����ֽ��ϴ�.");
            return;
        }
        
        System.out.println("===== ��ٱ��� ���� =====");
        DecimalFormat formatter = new DecimalFormat("#,###");
        
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + ". " + items.get(i));
        }
        
        int totalPrice = calculateTotalPrice();
        int discountedPrice = calculateDiscountedPrice();
        
        System.out.println("\n�� ����: " + formatter.format(totalPrice) + "��");
        System.out.println("���� ���� ����: " + formatter.format(discountedPrice) + "��");
        System.out.println("����� �ݾ�: " + formatter.format(totalPrice - discountedPrice) + "��");
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
            System.out.println("��ٱ��ϰ� ����ֽ��ϴ�. ��踦 ����� �� �����ϴ�.");
            return;
        }
        
        Map<String, Integer> typeCounts = new HashMap<>();
        
        for (Publication item : items) {
            String type;
            if (item instanceof Novel) {
                type = "�Ҽ�";
            } else if (item instanceof Magazine) {
                type = "����";
            } else if (item instanceof ReferenceBook) {
                type = "����";
            } else {
                type = "��Ÿ";
            }
            
            typeCounts.put(type, typeCounts.getOrDefault(type, 0) + 1);
        }
        
        System.out.println("\n===== ��ٱ��� ��� =====");
        System.out.println("�� �׸� ��: " + items.size());
        
        System.out.println("Ÿ�Ժ� ����:");
        for (Map.Entry<String, Integer> entry : typeCounts.entrySet()) {
            System.out.println("- " + entry.getKey() + ": " + entry.getValue() + "��");
        }
        System.out.println("=======================");
    }
    
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        
        Magazine magazine1 = new Magazine("����ũ�μ���Ʈ", LocalDate.of(2007, 10, 1), 328, 9900, "�ſ�");
        Magazine magazine2 = new Magazine("�濵����ǻ��", LocalDate.of(2007, 10, 3), 316, 9000, "�ſ�");
        Novel novel1 = new Novel("���߿�", LocalDate.of(2007, 7, 1), 396, 9800, "����������������", "����Ҽ�");
        Novel novel2 = new Novel("���ѻ꼺", LocalDate.of(2007, 4, 14), 383, 11000, "����", "���ϼҼ�");
        ReferenceBook ref1 = new ReferenceBook("�ǿ��������α׷���", LocalDate.of(2007, 1, 14), 496, 25000, "����Ʈ�������");
        
        cart.addItem(magazine1);
        cart.addItem(magazine2);
        cart.addItem(novel1);
        cart.addItem(novel2);
        cart.addItem(ref1);
        
        cart.displayCart();
        
        cart.printStatistics();
        
        cart.removeItem("���߿�");
        
        cart.displayCart();
    }
}