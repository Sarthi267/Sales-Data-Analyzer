package com.salesanalyzer;


import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SaleLoader {
public List<Sale> loadSales() throws Exception {
    List<Sale> sales = new ArrayList<>();
    Scanner scanner = new Scanner(new File("Input/sales.csv"));

    scanner.nextLine();

    while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        String[] parts = line.split(",");
        String product = parts[0];
        String category = parts[1];
        int quantity = Integer.parseInt(parts[2]);
        double price = Double.parseDouble(parts[3]);
        LocalDate date = LocalDate.parse(parts[4]);

        sales.add(new Sale(product, category, quantity, price, date));
    }
    scanner.close();
    return sales;

}


}
