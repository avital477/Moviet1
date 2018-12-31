package com.example.user.moviet;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
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

import java.util.ArrayList;
import java.util.Iterator;

import static com.example.user.moviet.R.id.list;
import static com.example.user.moviet.R.id.spBussinessType;
import static com.example.user.moviet.R.id.spCountries;
import static com.example.user.moviet.R.id.textView9;
//import static com.example.user.moviet.S

public class Choose_Movie extends AppCompatActivity {

    TextView textView7;
    TextView textView8;
    TextView textView10;
    TextView textView12;
    ListView listView;
    FirebaseDatabase database;
    DatabaseReference ref;
    ArrayList<String> myMovies;
    ArrayAdapter<String> adapter;
    Select select;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose__movie);

        textView7 = (TextView) findViewById(R.id.textView7);
        textView8 = (TextView) findViewById(R.id.textView8);
        textView10 = (TextView) findViewById(R.id.textView10);
       // textView12 = (TextView) findViewById(R.id.textView12);

        textView7.setText(Choose_Cinema.mySelection.getMyDate());
        textView8.setText(Choose_Cinema.mySelection.getMyGenre());
        textView10.setText(Choose_Cinema.mySelection.getMyCinema());

        String MyCinema=Choose_Cinema.mySelection.getMyCinema();
        String MyGenre=Choose_Cinema.mySelection.getMyGenre();
        String MyDate=Choose_Cinema.mySelection.getMyDate();

        select=new Select();
        listView=(ListView) findViewById(R.id.list);
        database= FirebaseDatabase.getInstance();
        ref= database.getReference("Cinemas").child(MyCinema).child(MyGenre).child(MyDate);
        myMovies=new ArrayList<>();
        adapter= new ArrayAdapter<String>(this,R.layout.activity_choose__movie,R.id.list,myMovies);
        ref.addValueEventListener(new ValueEventListener() {


       // DatabaseReference reference = (DatabaseReference) FirebaseDatabase.getInstance().getReference();
       // final DatabaseReference MyDB = reference.child("Cinemas").child(MyCinema).child(MyGenre).child(MyDate);
       // MyDB.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

//                textView12.setText(dataSnapshot.getValue().toString());
//                Iterator<DataSnapshot> iterator = dataSnapshot.getChildren().iterator();
                Toast.makeText(Choose_Movie.this, dataSnapshot.getValue().toString(),Toast.LENGTH_SHORT).show();

                    for(DataSnapshot ds: dataSnapshot.getChildren()){
                        select = ds.getValue(Select.class);
                        myMovies.add(select.toString());
                    }
                    listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }




}
