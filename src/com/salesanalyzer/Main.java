package com.salesanalyzer;

import java.io.File;
import java.util.List;

public class Main {
    static void main(String[] args) throws Exception {
        SaleLoader loader = new SaleLoader();
        List<Sale> sales = loader.loadSales();

    ReportWriter reportWriter = new ReportWriter();
    reportWriter.writeResult(sales);
    reportWriter.close();

    File processedDir = new File("processed/" + reportWriter.timestamp);
    processedDir.mkdirs();

    File source = new File("Input/sales.csv");
    File destination = new File(processedDir, ".sales.csv");
    source.renameTo(destination);

        System.out.println("Report generated and data archived");
   }
}
