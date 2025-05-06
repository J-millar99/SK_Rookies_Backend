package mylab.book.control;

import mylab.book.entity.*;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class StatisticsAnalyzer {
    public Map<String, Double> calculateAveragePriceByType(Publication[] publications) {
        Map<String, Double> totalPriceByType = new HashMap<>();
        Map<String, Integer> countByType = new HashMap<>();
        
        for (Publication pub : publications) {
            String type = getPublicationType(pub);
            
            totalPriceByType.put(type, totalPriceByType.getOrDefault(type, 0.0) + pub.getPrice());
            countByType.put(type, countByType.getOrDefault(type, 0) + 1);
        }
        
        Map<String, Double> avgPriceByType = new HashMap<>();
        for (String type : totalPriceByType.keySet()) {
            double avgPrice = totalPriceByType.get(type) / countByType.get(type);
            avgPriceByType.put(type, avgPrice);
        }
        
        return avgPriceByType;
    }
    
    public Map<String, Double> calculatePublicationDistribution(Publication[] publications) {
        Map<String, Integer> countByType = new HashMap<>();
        
        for (Publication pub : publications) {
            String type = getPublicationType(pub);
            countByType.put(type, countByType.getOrDefault(type, 0) + 1);
        }
        
        Map<String, Double> distributionByType = new HashMap<>();
        int totalCount = publications.length;
        
        for (String type : countByType.keySet()) {
            double percentage = (countByType.get(type) * 100.0) / totalCount;
            distributionByType.put(type, percentage);
        }
        
        return distributionByType;
    }
    
    public double calculatePublicationRatioByYear(Publication[] publications, String year) {
        int count = 0;
        
        for (Publication pub : publications) {
            String pubYear = pub.getPublishDate().toString().substring(0, 4);
            
            if (pubYear.equals(year)) {
                count++;
            }
        }
        
        return (count * 100.0) / publications.length;
    }
    
    private String getPublicationType(Publication pub) {
        if (pub instanceof Novel) {
            return "소설";
        } else if (pub instanceof Magazine) {
            return "잡지";
        } else if (pub instanceof ReferenceBook) {
            return "참고서";
        } else {
            return "기타";
        }
    }
    
    public void printStatistics(Publication[] publications) {
        DecimalFormat priceFormat = new DecimalFormat("#,###.##");
        DecimalFormat percentFormat = new DecimalFormat("#.##");
        
        System.out.println("\n===== 출판물 통계 분석 =====");
        
        Map<String, Double> avgPriceByType = calculateAveragePriceByType(publications);
        System.out.println("1. 타입별 평균 가격:");
        for (Map.Entry<String, Double> entry : avgPriceByType.entrySet()) {
            System.out.println("   - " + entry.getKey() + ": " + priceFormat.format(entry.getValue()) + "원");
        }
        
        Map<String, Double> distribution = calculatePublicationDistribution(publications);
        System.out.println("\n2. 출판물 유형 분포:");
        for (Map.Entry<String, Double> entry : distribution.entrySet()) {
            System.out.println("   - " + entry.getKey() + ": " + percentFormat.format(entry.getValue()) + "%");
        }
        
        String targetYear = "2007";
        double yearRatio = calculatePublicationRatioByYear(publications, targetYear);
        System.out.println("\n3. " + targetYear + "년에 출판된 출판물 비율: " + percentFormat.format(yearRatio) + "%");
        
        System.out.println("=============================");
    }
}