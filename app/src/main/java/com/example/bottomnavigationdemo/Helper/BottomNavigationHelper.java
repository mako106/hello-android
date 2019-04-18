package com.example.bottomnavigationdemo.Helper;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class BottomNavigationHelper {
    private static final String TAG = "BottomNavigationHelper";

    public static void setupBottomNavigation(BottomNavigationViewEx bottomNavigationViewEx){
        bottomNavigationViewEx.enableAnimation(false);
        bottomNavigationViewEx.enableItemShiftingMode(false);
        bottomNavigationViewEx.enableShiftingMode(false);
        bottomNavigationViewEx.setTextVisibility(false);

    }
}
