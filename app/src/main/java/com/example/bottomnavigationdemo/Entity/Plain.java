package com.example.bottomnavigationdemo.Entity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class Plain {
    private long id;
    private String email;
    private String title;
    private String category;
    private String longitude;
    private String latitude;
    private String description;
    private String date;
    private int status;



    public Plain(long  id , int status, String longitude, String latitude){
        this.id = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
        this.status = 0;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public Plain( String email, String title, String category, String description ) {
        this.email = email;
        this.title = title;
        this.category = category;
        this.description = description;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
