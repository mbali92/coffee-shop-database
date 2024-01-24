package com.example.coffeeshopbatabase.Entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ShopAbout {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int about_id;
    private String history_title;
    private String history_text;
    private String location_text;

    public ShopAbout() {
    }

    public ShopAbout(int about_id, String history_title, String history_text, String location_text) {
        this.about_id = about_id;
        this.history_title = history_title;
        this.history_text = history_text;
        this.location_text = location_text;
    }

    public int getAbout_id() {
        return about_id;
    }

    public void setAbout_id(int about_id) {
        this.about_id = about_id;
    }

    public String getHistory_title() {
        return history_title;
    }

    public void setHistory_title(String history_title) {
        this.history_title = history_title;
    }

    public String getHistory_text() {
        return history_text;
    }

    public void setHistory_text(String history_text) {
        this.history_text = history_text;
    }

    public String getLocation_text() {
        return location_text;
    }

    public void setLocation_text(String location_text) {
        this.location_text = location_text;
    }
}
