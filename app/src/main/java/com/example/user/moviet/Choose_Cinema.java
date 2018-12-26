package com.example.user.moviet;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Choose_Cinema extends AppCompatActivity {

    Spinner spCountries;
    Spinner spBusinessType;
    //DON'T FORGET DATE


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose__cinema);

        spCountries = (Spinner) findViewById(R.id.spCountries);
        spBusinessType = (Spinner) findViewById(R.id.spBussinessType);

//Button 10**************************************
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

        Button button13 = findViewById(R.id.button13);
        button13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String MyCinemas = spCountries.toString().trim();
                final String MyGenre = spBusinessType.toString().trim();
                final DatabaseReference db = FirebaseDatabase.getInstance().getReference();


                db.child("Cinemas");
                db.child(MyCinemas.replace(".", "|"));
                db.child(MyGenre.replace(".", "|"));


                db.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                    Intent intent = new Intent (Choose_Cinema.this, Choose_Movie.class);
                    startActivity(intent);
//                  Toast.makeText(Choose_Cinema.this, dataSnapshot.toString(), Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
        }

        // Initialize and set Adapter

//        adapterBusinessType = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, businessType);
//        spBusinessType.setAdapter(adapterBusinessType);

        // Country Item Selected Listener
//        spCountries.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//
//            @Override
//            public void onItemSelected(AdapterView<?> adapter, View v, int position, long id) {
//                // On selecting a spinner item
//                String item = adapter.getItemAtPosition(position).toString();
//
//                // Showing selected spinner item
////                Toast.makeText(getApplicationContext(), "Cinema : " + item, Toast.LENGTH_LONG).show();
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> arg0) {
//
//            }
//        });
//
//
//        // Business Type Item Selected Listener
//        spBusinessType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//
//            @Override
//            public void onItemSelected(AdapterView<?> adapter, View v, int position, long id) {
//                // On selecting a spinner item
//                String item = adapter.getItemAtPosition(position).toString();
//
//                // Showing selected spinner item
////                Toast.makeText(getApplicationContext(), "Genre : " + item, Toast.LENGTH_LONG).show();
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> arg0) {
//                // TODO Auto-generated method stub
//
//            }
//
//        });
//
////
    }

