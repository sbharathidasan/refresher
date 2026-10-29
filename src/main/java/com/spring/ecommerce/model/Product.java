package com.spring.ecommerce.model;
import lombok.Data;
@Data
public class Product {
    private Long id;
    private String name;
    private double price;
    private int stockQuantity;

    // Constructor
    public Product(Long id, String name, double price, int stockQuantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }
}