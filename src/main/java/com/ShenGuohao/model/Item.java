package com.ShenGuohao.model;

import java.io.Serializable;

public class Item implements Serializable {
    private  Product product;
    private int Quantity;

    public Item(){}
    public Item(Product product, int quantity) {
        this.product = product;
        Quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    @Override
    public String toString() {
        return "Item{" +
                "product=" + product +
                ", Quantity=" + Quantity +
                '}';
    }
}
