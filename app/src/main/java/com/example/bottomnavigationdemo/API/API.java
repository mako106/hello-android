package com.example.bottomnavigationdemo.API;

import com.example.bottomnavigationdemo.Entity.FeedBack;
import com.example.bottomnavigationdemo.Entity.Notification;
import com.example.bottomnavigationdemo.Entity.Plain;
import com.example.bottomnavigationdemo.Entity.TokenFirebase;
import com.example.bottomnavigationdemo.Entity.User;
import com.example.bottomnavigationdemo.Pojo.UserLogin;
import com.example.bottomnavigationdemo.Pojo.complainResult;
import com.example.bottomnavigationdemo.Pojo.feedBackResult;
import com.example.bottomnavigationdemo.Pojo.loginResult;
import com.example.bottomnavigationdemo.Pojo.registerResult;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface API {

    String API_URL = "https://1-dot-maptest-69.appspot.com";


    @POST("/api/v1/user/register")
    Call<registerResult> register(@Body User user);

    @POST("/api/v1/user/login")
    Call<loginResult> login(@Body UserLogin userLogin);

    @POST("/api/v1/complain")
    Call<complainResult> complainCall(@Body Plain plain);

    //get all notification
    @GET("/api/v1/noti")
    Call<List<Notification>> getNotificationCalls();

    //get notification by id

    @POST("/api/v1/feedback")
    Call<feedBackResult> sendFeeback(@Body FeedBack feedback);


    //save token FCM
    @POST("/api/v1/fcm/")
    Call<registerResult> saveToken(@Body TokenFirebase tokenFirebase);

}
