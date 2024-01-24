package com.example.coffeeshopbatabase.Entity;

import jakarta.persistence.*;

@Entity
public class ShopMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int menu_id;
    @Column(columnDefinition = "LONGTEXT")
    private String menu_image;
    private String title;
    private String price;
    private String description;

}
