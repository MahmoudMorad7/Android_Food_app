package com.example.wagbaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class collection extends AppCompatActivity {

    FirebaseAuth auth;
    TextView textView;
    FirebaseUser user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection);


        auth=FirebaseAuth.getInstance();
        Button logout=findViewById(R.id.logout);
        user=auth.getCurrentUser();

        if(user==null){
            Intent intent=new Intent(getApplicationContext(),loginpage.class);
            startActivity(intent);
            finish();
        }

        else {
            //textView.setText(user.getEmail());
        }

        logout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent=new Intent(getApplicationContext(),loginpage.class);
                startActivity(intent);
                finish();
            }
        });

    }
}