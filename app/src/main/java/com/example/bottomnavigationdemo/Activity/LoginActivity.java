package com.example.bottomnavigationdemo.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bottomnavigationdemo.API.RetrofitClient;
import com.example.bottomnavigationdemo.Pojo.UserLogin;
import com.example.bottomnavigationdemo.Pojo.loginResult;
import com.example.bottomnavigationdemo.R;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edUser, edPass;
    Button btnLogin;
    TextView txtRegister;
    ProgressBar spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edPass =(EditText) findViewById(R.id.edPass);
        edUser = (EditText)findViewById(R.id.edUser);
        btnLogin =(Button) findViewById(R.id.btnLogin);
        txtRegister =(TextView) findViewById(R.id.txtRegister);
        btnLogin.setOnClickListener(this);
        txtRegister.setOnClickListener(this);
        spinner=(ProgressBar)findViewById(R.id.pB_login);
        spinner.setVisibility(View.GONE);

    }

    private void userLogin() throws IOException {
        String password = edPass.getText().toString().trim();
        String user = edUser.getText().toString().trim();

        UserLogin userLogin = new UserLogin(user, password);
        Call<loginResult> call = RetrofitClient
                .getInstance()
                .getApi()
                .login(userLogin);

        call.enqueue(new Callback<loginResult>() {
            @Override
            public void onResponse(Call<loginResult> call, Response<loginResult> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(LoginActivity.this, "Invalid email or password!", Toast.LENGTH_SHORT).show();
                    spinner.setVisibility(View.GONE);
                    return;
                }
                loginResult l = response.body();
                Toast.makeText(LoginActivity.this, "login success with email: " + l.getUserEmail(), Toast.LENGTH_LONG).show();
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                intent.putExtra("USER_NAME", edUser.getText().toString());
                startActivity(intent);

            }
            @Override
            public void onFailure(Call<loginResult> call, Throwable t) {
                Toast.makeText(LoginActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLogin:
                try {
                    userLogin();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                spinner.setVisibility(View.VISIBLE);
                break;
            case R.id.txtRegister:
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
