package com.example.user.moviet.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.user.moviet.R;

public class Order_or_Cancle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_or__cancle);

        Button order= (Button) findViewById(R.id.button2) ;
        order.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent myIntent = new Intent(getBaseContext(), Choose_Cinema.class);
                        startActivity(myIntent);

            }
        });

//        Button cancel= (Button) findViewById(R.id.button4) ;
//        cancel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent myIntent = new Intent(getBaseContext(), UserCancel.class);
//                startActivity(myIntent);
//
//            }
//        });




    }




//    public void onButtonClick(View v){
//        Intent myIntent = new Intent(getBaseContext(), Choose_Cinema.class);
//        startActivity(myIntent);
//    }
//    public void onButtonClick(View v) {
//        Intent myIntent = new Intent(getBaseContext(), Choose_Cinema.class);
//        startActivity(myIntent);
//    }

}
