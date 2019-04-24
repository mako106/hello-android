package com.example.bottomnavigationdemo.Entity;

public class User {
    private String email;
    private String password;
    private String fullName;
    private String address;
    private String phone;
    private int idProof;
    private int status;

    public User(String email, String password, String fullName, String address, String phone) {
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.address = address;
        this.phone = phone;
    }

    public User() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getIdProof() {
        return idProof;
    }

    public void setIdProof(int idProof) {
        this.idProof = idProof;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public User(String email, String password) {

    }

    public User(String email, String password, String fullName, String address, String phone, int idProof, int status) {
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.address = address;
        this.phone = phone;
        this.idProof = idProof;
        this.status = 0;
    }
}
