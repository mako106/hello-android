package com.example.bottomnavigationdemo.Entity;

public class Notification {
    private String id;
    private long data;
    private String location;
     private String  title;
    private String description;
    private String date;

    public Notification() {
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public long getData() {
        return data;
    }
    public void setData(long data) {
        this.data = data;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
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

    public Notification(String title, String des, String time) {
        this.title = title;
        this.description = des;
        this.date = time;
    }
}
