package com.example.user.moviet.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.moviet.R;
import com.example.user.moviet.model.MovieAdapter;
import com.example.user.moviet.model.Select;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Choose_Cinema extends AppCompatActivity {


    public static Select mySelection;
    Spinner spCountries;
    Spinner spBusinessType;

//    ListView listView;
//
//    ArrayList<String> myMovies = new ArrayList<String>();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose__cinema);

        spCountries = (Spinner) findViewById(R.id.spCountries);
        spBusinessType = (Spinner) findViewById(R.id.spBussinessType);



//Button 10 choose date **************************************
        TextView textView=findViewById(R.id.textView9);
        Button button10 = findViewById(R.id.button10);
        String date=getIntent().getStringExtra("date");
        if(date!=null)
            textView.setText(date);

        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent (Choose_Cinema.this, Choose_Date.class);
                startActivity(intent);
            }
        });
//End Button 10*********************************

// button 13 - next *****************************
        Button button13 = findViewById(R.id.button13);

        button13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String MyCinema = spCountries.getSelectedItem().toString();
                final String MyGenre = spBusinessType.getSelectedItem().toString().trim();
                final String MyDate = Choose_Date.date;
                final DatabaseReference db = FirebaseDatabase.getInstance().getReference();

                db.child("Cinemas");
                db.child(MyCinema.replaceAll(".", "|"));
                db.child(MyGenre.replaceAll(".", "|"));

                db.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        mySelection = new Select(MyCinema,MyGenre,MyDate);

                        Intent i = new Intent(Choose_Cinema.this,Choose_Movie.class);
                        startActivity(i);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
     // END button 13 - next *****************************

    }
    }

