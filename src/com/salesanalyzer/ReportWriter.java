package com.salesanalyzer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ReportWriter {
    private final BufferedWriter writer;
    public String timestamp = LocalDateTime.now().format
            (DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));

    public ReportWriter() throws IOException {
        new File("output").mkdirs();
         writer = new BufferedWriter(new FileWriter
                ("output/report_" + timestamp + ".csv"));

    }
    public void writeResult(List<Sale> sales) throws IOException {
        writer.write("===== Sales Analysis Report =====\n");
        writer.write("Generated: " + LocalDate.now() + "\n");
        writer.write("\n");
        writer.write("Total Revenue: $" + String.format("%.2f", SaleAnalyzer.totalRevenue(sales)) + "\n");
        writer.write("Average Order Value: $" + String.format("%.2f", SaleAnalyzer.averageOrderValue(sales)) + "\n");
        writer.write("\n");
        writer.write("Revenue by Category: \n");
        String[] categories = {"Technology", "Furniture", "OfficeSupplies"};
        for(String category : categories){
            writer.write("\t" + category + ": $" +
                    String.format("%.2f", SaleAnalyzer.totalRevByCategory(sales, category)) + "\n");

        }
        writer.write("\n");
        writer.write("Top 5 Best Selling Products by Revenue: \n");
        List<Sale> top5 = SaleAnalyzer.topFiveBestSelling(sales);
        for(int i = 0; i < top5.size(); i++){
            Sale sale = top5.get(i);
            writer.write("\t" + (i + 1) + ". " + sale.product() +
                    " - $" + String.format("%.2f", (sale.quantity() * sale.price())) + "\n");
        }
        writer.write("\n");
        writer.write("Revenue from sales above $100: $" +
                String.format("%.2f", SaleAnalyzer.revenueByFilter(sales, sale-> sale.price() > 100)) + "\n");
        writer.write("Revenue from high volume sales (quantity > 10): $" +
                String.format("%.2f", SaleAnalyzer.revenueByFilter(sales, sale -> sale.quantity() > 10)) + "\n");


    }
    public void close() throws IOException {
        writer.close();
    }

}
