package com.example.bottomnavigationdemo.Pojo;

public class complainResult {
    private String userID;
    private String title;
    private String category;
    private String location;
    private String des;
    private long date;

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public complainResult() {
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public complainResult(String userID, String title, String category, String location, String des) {
        this.userID = userID;
        this.title = title;
        this.category = category;
        this.location = location;
        this.des = des;
        this.date = System.currentTimeMillis();
    }
}
