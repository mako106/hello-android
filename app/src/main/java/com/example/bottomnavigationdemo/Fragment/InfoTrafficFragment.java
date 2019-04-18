package com.example.bottomnavigationdemo.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.bottomnavigationdemo.API.RetrofitClient;
import com.example.bottomnavigationdemo.Entity.Plain;
import com.example.bottomnavigationdemo.Pojo.complainResult;
import com.example.bottomnavigationdemo.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class InfoTrafficFragment extends Fragment implements View.OnClickListener {


    EditText edEmail,edTitle,edCategory,edDes;
    Button btnSend;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_complain, container, false);
        edEmail = (EditText)view.findViewById(R.id.c_edEmail);
        edTitle= (EditText)view.findViewById(R.id.c_edTitle);
        edCategory= (EditText)view.findViewById(R.id.c_edCategory);
        edDes= (EditText)view.findViewById(R.id.c_edDes);
        btnSend= (Button)view.findViewById(R.id.c_btnSend);
        btnSend.setOnClickListener(this);
        return view;
    }

    private void userComplain() {
        String email = edEmail.getText().toString();
        String title = edTitle.getText().toString();
        String category = edCategory.getText().toString();
        String description = edDes.getText().toString();

        Plain plain = new Plain(email,title,category,description);
        Call<complainResult> call = RetrofitClient.getInstance().getApi().complainCall(plain);
        call.enqueue(new Callback<complainResult>() {
            @Override
            public void onResponse(Call<complainResult> call, Response<complainResult> response) {
                complainResult cp =  response.body();
                if (cp == null){
                    Log.d("Error", "Error");
                    return;
                }
            }
            @Override
            public void onFailure(Call<complainResult> call, Throwable t) {
            }
        });
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case  R.id.c_btnSend:
                userComplain();
                break;
        }
    }
}
