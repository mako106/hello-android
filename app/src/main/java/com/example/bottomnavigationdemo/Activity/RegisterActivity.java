package com.example.bottomnavigationdemo.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bottomnavigationdemo.API.RetrofitClient;
import com.example.bottomnavigationdemo.Entity.User;
import com.example.bottomnavigationdemo.Pojo.registerResult;
import com.example.bottomnavigationdemo.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    EditText  edEmail, edPass, edComfirmPass;
    Button btnRegister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edEmail =(EditText) findViewById(R.id.edEmail);
        edPass = (EditText)findViewById(R.id.edPassword);
        edComfirmPass =(EditText) findViewById(R.id.edConfirmPass);
        btnRegister = (Button)findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(this);

    }

    private void userRegister() {
        String email = edEmail.getText().toString();
        String password = edPass.getText().toString();
        String confirmPass = edComfirmPass.getText().toString();

        if (!password.endsWith(confirmPass)){
            Toast.makeText(RegisterActivity.this, "Password not valid", Toast.LENGTH_LONG).show();
        }
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        Call<registerResult> call = RetrofitClient
                .getInstance()
                .getApi()
                .register(user);

        call.enqueue(new Callback<registerResult>() {
            @Override
            public void onResponse(Call<registerResult> call, Response<registerResult> response) {
                registerResult s = response.body();
                if (s == null){
                    Log.d("Error", s.getTitle());
                    return;
                }
                Toast.makeText(RegisterActivity.this, s.getDescription(), Toast.LENGTH_LONG).show();
                //chuyeenr page
            }
            @Override
            public void onFailure(Call<registerResult> call, Throwable t) {
                Toast.makeText(RegisterActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnRegister:
                userRegister();
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
                break;
        }
    }
}
