package com.salesanalyzer;

import java.time.LocalDate;

public record Sale(String product, String category, int quantity, double price, LocalDate date) {



}
