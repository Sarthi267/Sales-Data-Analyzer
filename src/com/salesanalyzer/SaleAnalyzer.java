package com.salesanalyzer;


import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SaleAnalyzer {

    public static double totalRevenue (List<Sale> sales){
        return sales.stream()
                .mapToDouble(sale -> sale.quantity() * sale.price())
                .sum();
    }
    public static double totalRevByCategory (List<Sale> sales, String category){
        return sales.stream()
                .filter(sale -> sale.category().equals(category))
                .mapToDouble(sale -> sale.quantity() * sale.price())
                .sum();
    }
    public static List<Sale> topFiveBestSelling (List<Sale> sales){
        return sales.stream()
                .sorted(Comparator.comparingDouble((Sale sale) -> sale.quantity() * sale.price()).reversed())
                .limit(5)
                .collect(Collectors.toList());
    }
    public static double averageOrderValue (List<Sale> sales){
        return sales.stream()
                .mapToDouble(sale -> sale.quantity() * sale.price())
                .average()
                .orElse(0.0);
    }
    public static double revenueByFilter(List<Sale> sales, Predicate<Sale> filter){
        return sales.stream()
                .filter(filter)
                .mapToDouble(sale -> sale.quantity() * sale.price())
                .sum();
    }



}
