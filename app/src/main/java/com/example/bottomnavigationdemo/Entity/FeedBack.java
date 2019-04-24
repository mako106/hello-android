package com.example.bottomnavigationdemo.Entity;

public class FeedBack {
    private String id;
    private String userID;
    private String des;
    private String title;

    public FeedBack() {
    }

    public FeedBack(String des, String title) {
        this.des = des;
        this.title = title;
    }

    public FeedBack(String id, String userID, String des, String title) {
        this.id = id;
        this.userID = userID;
        this.des = des;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
