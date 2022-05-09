package com.ShenGuohao.model;

import java.io.InputStream;

public class Product {
    private int productId;
    private int categoryId;
    private String productName;
    private String productDescription;
    private InputStream pricture;
    private double price;

    public Product(){}

    public Product(int productId, int categoryId, String productName, String productDescription, InputStream pricture, double price) {
        this.productId = productId;
        this.categoryId = categoryId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.pricture = pricture;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public InputStream getPricture() {
        return pricture;
    }

    public void setPricture(InputStream pricture) {
        this.pricture = pricture;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", categoryId=" + categoryId +
                ", productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", pricture=" + pricture +
                ", price=" + price +
                '}';
    }
}
