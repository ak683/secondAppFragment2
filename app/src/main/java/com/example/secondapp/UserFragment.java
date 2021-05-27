package com.example.secondapp;

import android.database.sqlite.SQLiteDatabase;
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

import static com.example.secondapp.database.UserDbSchema.UserTable.Cols.UUID;

public class UserFragment  extends Fragment {
    User user;
    TextView userInfo;
    Button buttonDel;
    Button editBtn;
    Button backBtn;
    private int position;
    private SQLiteDatabase database;



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
        editBtn = view.findViewById(R.id.editBtn);
        backBtn = view.findViewById(R.id.backBtn);


        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("DEBUG", "UserFragment.click(editBtn)");
                Intent intent = new Intent(getActivity(), EditUserActivity.class);
                intent.putExtra("position", position);
                Log.d("DEBUG", "intent start EditUserActivity");
                startActivity(intent);
            }
        });

        buttonDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Users.get(getContext()).deleteUser(user.getUuid().toString());
                Intent intent = new Intent(getContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        //DeleteData();


        /*buttonDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }

            private void delete() {

            }
        });*/

        return view;


    /*public void DeleteData(){
        buttonDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer DeleteRow = database.delete(userInfo.getText().toString(),"Id = ?",new String[] {UUID});
            }

            });  */

    }


}
