package com.example.coffeeshopbatabase.Entity;

import jakarta.persistence.*;

@Entity
public class ShopItems {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int item_id;
    private String title;
    private String category;
    private int price;
    @Column(columnDefinition = "LONGTEXT")
    private String image;

    public ShopItems() {
    }

    public ShopItems(int item_id, String title, String category, int price, String image) {
        this.item_id = item_id;
        this.title = title;
        this.category = category;
        this.price = price;
        this.image = image;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
