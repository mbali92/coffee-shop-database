package com.example.coffeeshopbatabase.Entity;

import jakarta.persistence.*;

@Entity
public class ShopCartItems {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cart_id;
    private String title;
    private String category;
    private int price;
    private int quantity;
    @Column(columnDefinition = "LONGTEXT")
    private String image;

    public ShopCartItems() {
    }

    public ShopCartItems(int cart_id, String title, String category, int price, int quantity, String image) {
        this.cart_id = cart_id;
        this.title = title;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.image = image;
    }

    public int getCart_id() {
        return cart_id;
    }

    public void setCart_id(int cart_id) {
        this.cart_id = cart_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

