package com.example.bottomnavigationdemo.Activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.bottomnavigationdemo.Adapter.BottomNavigationBehavior;
import com.example.bottomnavigationdemo.Fragment.FeedBackFragment;
import com.example.bottomnavigationdemo.Fragment.HomeFragment;
import com.example.bottomnavigationdemo.Fragment.InfoTrafficFragment;
import com.example.bottomnavigationdemo.Fragment.NotiFragment;
import com.example.bottomnavigationdemo.Fragment.ProfileFragment;
import com.example.bottomnavigationdemo.R;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        // attaching bottom sheet behaviour - hide / show on scroll
        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) navigation.getLayoutParams();
        layoutParams.setBehavior(new BottomNavigationBehavior());

        // load the store fragment by default
        loadFragment(new NotiFragment());
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

    /**
     * loading fragment into FrameLayout
     *
     * @param fragment
     */
    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}