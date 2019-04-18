package com.example.bottomnavigationdemo.Pojo;
import com.google.gson.annotations.SerializedName;

public class loginResult {
    @SerializedName("userEmail")
    private String userEmail;

    @SerializedName("tokenKey")
    private String tokenKey;

    @SerializedName("secretToken")
    private String secretToken;

    @SerializedName("createdTime")
    private long createdTime;

    @SerializedName("expiredTime")
    private long expiredTime;

    @SerializedName("status")
    private int status;


    public loginResult() {
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getTokenKey() {
        return tokenKey;
    }

    public void setTokenKey(String tokenKey) {
        this.tokenKey = tokenKey;
    }

    public String getSecretToken() {
        return secretToken;
    }

    public void setSecretToken(String secretToken) {
        this.secretToken = secretToken;
    }

    public long getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(int createdTime) {
        this.createdTime = createdTime;
    }

    public long getExpiredTime() {
        return expiredTime;
    }

    public void setExpiredTime(int expiredTime) {
        this.expiredTime = expiredTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
