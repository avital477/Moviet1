package com.example.user.moviet.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.user.moviet.R;

public class Order_or_Cancle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_or__cancle);
    }

    public void onButtonClick(View v){
        Intent myIntent = new Intent(getBaseContext(), Choose_Cinema.class);
        startActivity(myIntent);
    }

}
