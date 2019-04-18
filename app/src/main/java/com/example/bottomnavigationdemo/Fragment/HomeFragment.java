package com.example.bottomnavigationdemo.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.bottomnavigationdemo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

     Button btn;

    public HomeFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);


        btn = (Button)rootView.findViewById(R.id.btn2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFragment(new MapFragment(), false, "one");
            }
        });

        return rootView;
    }

    public void addFragment(Fragment fragment, boolean addToBackStack, String tag) {
        FragmentManager manager = getFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        if (addToBackStack) {
            ft.addToBackStack(tag);
        }
        ft.replace(R.id.container_frame, fragment, tag);
        ft.commitAllowingStateLoss();
    }


}
