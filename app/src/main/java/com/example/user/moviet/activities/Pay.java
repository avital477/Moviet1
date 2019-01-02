package com.example.user.moviet.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.user.moviet.R;

public class Pay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);

        Button pay= (Button) findViewById(R.id.button6) ;
        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(Pay.this, "Your reservation has been confirmed, enjoy! :) ", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
