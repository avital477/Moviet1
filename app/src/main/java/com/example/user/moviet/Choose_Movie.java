package com.example.user.moviet;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static com.example.user.moviet.R.id.spBussinessType;
import static com.example.user.moviet.R.id.spCountries;
import static com.example.user.moviet.R.id.textView9;
//import static com.example.user.moviet.S

public class Choose_Movie extends AppCompatActivity {

    TextView textView7;
    TextView textView8;
    TextView textView10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose__movie);

        textView7 = (TextView) findViewById(R.id.textView7);
        textView8 = (TextView) findViewById(R.id.textView8);
        textView10 = (TextView) findViewById(R.id.textView10);

        textView7.setText(Choose_Cinema.mySelection.getMyDate());
        textView8.setText(Choose_Cinema.mySelection.getMyGenre());
        textView10.setText(Choose_Cinema.mySelection.getMyCinema());




    }

}
