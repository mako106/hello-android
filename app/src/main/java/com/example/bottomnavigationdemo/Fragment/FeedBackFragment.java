package com.example.bottomnavigationdemo.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bottomnavigationdemo.API.RetrofitClient;
import com.example.bottomnavigationdemo.Entity.FeedBack;
import com.example.bottomnavigationdemo.Pojo.feedBackResult;
import com.example.bottomnavigationdemo.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class FeedBackFragment extends Fragment  implements View.OnClickListener {
    private EditText edDes,edTitle ;
    private Button btnSend;
    public FeedBackFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_feed_back, container, false);
        edTitle = (EditText) view.findViewById(R.id.f_edTitle);
        edDes = (EditText) view.findViewById(R.id.f_edDesFeedback);
        btnSend = (Button) view.findViewById(R.id.f_btnSend);
        btnSend.setOnClickListener(this);

        return view;
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.f_btnSend:
sendFeedback();
break;

        }
    }
    private void sendFeedback() {
        String des = edDes.getText().toString();
        String title = edTitle.getText().toString();
        if (!TextUtils.isEmpty(des)){
            Toast.makeText(getActivity(), "Description not null", Toast.LENGTH_LONG).show();
            return;
        }
        FeedBack feedback = new FeedBack(title,des);
        Call<feedBackResult> call = RetrofitClient.getInstance().getApi().sendFeeback(feedback);
        call.enqueue(new Callback<feedBackResult>() {
            @Override
            public void onResponse(Call<feedBackResult> call, Response<feedBackResult> response) {
                feedBackResult f = response.body();
                if (response.isSuccessful()){
                    Toast.makeText(getActivity(), " success with feedback: " + f.getTitle(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<feedBackResult> call, Throwable t) {

            }
        });
    }
}
