package com.example.httpMicroservice;

public class Product {
    private String productName;
    private int price;
    private double rating;
    private int discount;
    private String availability;

    public Product(String productName, int price, double rating, int discount, String availability) {
        this.productName = productName;
        this.price = price;
        this.rating = rating;
        this.discount = discount;
        this.availability = availability;
    }
}