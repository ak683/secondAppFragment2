package com.example.secondapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.secondapp.database.UserDbSchema;

public class UserFragment  extends Fragment {
    User user;
    TextView userInfo;
    Button buttonDel;



    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        int position = getActivity().getIntent().getIntExtra("position",1);
        user = Users.get(getActivity()).getUserList().get(position);


    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_user, viewGroup, false);
        userInfo = view.findViewById(R.id.userInfo);
        userInfo.setText(user.getUserName()+" "+user.getUserLastName()+"\n"+user.getPhone());
        buttonDel = view.findViewById(R.id.buttonDel);
        


        buttonDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            delete();

            }

            private void delete() {
            }
        });
        




        return view;

    }


}
