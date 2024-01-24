package com.example.coffeeshopbatabase.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ShopHours {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int shop_hours_id;
    private String weekends;
    private String weekdays;
    private String holidays;


}
