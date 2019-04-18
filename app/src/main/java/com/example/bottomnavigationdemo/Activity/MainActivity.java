package com.example.bottomnavigationdemo.Activity;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.bottomnavigationdemo.API.RetrofitClient;
import com.example.bottomnavigationdemo.Adapter.BottomNavigationBehavior;
import com.example.bottomnavigationdemo.Entity.TokenFirebase;
import com.example.bottomnavigationdemo.Fragment.FeedBackFragment;
import com.example.bottomnavigationdemo.Fragment.InfoTrafficFragment;
import com.example.bottomnavigationdemo.Fragment.HomeFragment;
import com.example.bottomnavigationdemo.Fragment.ProfileFragment;
import com.example.bottomnavigationdemo.Fragment.NotiFragment;
import com.example.bottomnavigationdemo.Helper.BottomNavigationHelper;
import com.example.bottomnavigationdemo.Pojo.registerResult;
import com.example.bottomnavigationdemo.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity  {
    private static final String TAG = "MyFirebaseMsgService";
    private static final String TAG_Google = "GoogleAPI";
    private static final int ERROR_DIALOG_REQUEST = 9001;


    private ActionBar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseApp.initializeApp(this);
        FirebaseInstanceId.getInstance().getInstanceId()
                .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                    @Override
                    public void onComplete(@NonNull Task<InstanceIdResult> task) {
                        if (!task.isSuccessful()) {
                            Log.w(TAG, "getInstanceId failed", task.getException());
                            return;
                        }

                        // Get new Instance ID token
                        String token = task.getResult().getToken();

                        // Log and toast
                        String msg = getString(R.string.msg_token_fmt, token);
                        Log.d(TAG, msg);
                        TokenFirebase tokenFirebase = new TokenFirebase();
                        tokenFirebase.setToken(token);
                        Call<registerResult> call = RetrofitClient.getInstance().getApi().saveToken(tokenFirebase);
                        call.enqueue(new Callback<registerResult>() {
                            @Override
                            public void onResponse(Call<registerResult> call, Response<registerResult> response) {
                                registerResult s = response.body();
                                Log.d("Response", response.message());
                                if (s == null) {
                                    Log.d("Error", "save fail");
                                    return;
                                }
                                Log.d("Save", "Success");
                            }

                            @Override
                            public void onFailure(Call<registerResult> call, Throwable t) {
                                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();

                            }
                        });
                    }
                });


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        // attaching bottom sheet behaviour - hide / show on scroll
        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) navigation.getLayoutParams();
        layoutParams.setBehavior(new BottomNavigationBehavior());


        bottomSetting();
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, new HomeFragment()).commit();


    }

    private void init(){

    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragment = new HomeFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_infoTraffic:
                    fragment = new InfoTrafficFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_feedblack:
                    fragment = new FeedBackFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_noti:
                    fragment = new NotiFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_about:
                    fragment = new ProfileFragment();
                    loadFragment(fragment);
                    return true;
            }
            return false;
        }
    };

    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }


    private void bottomSetting() {
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.navigation);
        BottomNavigationHelper.setupBottomNavigation(bottomNavigationViewEx);
    }



}
