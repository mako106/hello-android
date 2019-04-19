package com.example.bottomnavigationdemo.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.bottomnavigationdemo.API.RetrofitClient;
import com.example.bottomnavigationdemo.Adapter.ListNewAdapter;
import com.example.bottomnavigationdemo.Entity.Notification;
import com.example.bottomnavigationdemo.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class NotiFragment extends Fragment {


    ListView lvNew;
    ListNewAdapter adapter;
    List<Notification> listNotification = new ArrayList<>();

    public NotiFragment() {

    }

    public static NotiFragment newInstance(String param1, String param2) {
        NotiFragment fragment = new NotiFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_noti, container, false);

        lvNew = (ListView) view.findViewById(R.id.lvNotification);
        parserListNews();

        return view;
    }
    private void parserListNews() {
        Call<List<Notification>> list = RetrofitClient.getInstance().getApi().getNotificationCalls();
        list.enqueue(new Callback<List<Notification>>() {
            @Override
            public void onResponse(Call<List<Notification>> call, Response<List<Notification>> response) {
                listNotification = response.body();
                adapter = new ListNewAdapter(listNotification, NotiFragment.this);
                adapter.reloadData(listNotification);
                lvNew.setAdapter(adapter);
            }
            @Override
            public void onFailure(Call<List<Notification>> call, Throwable t) {

            }
        });
    }



}
