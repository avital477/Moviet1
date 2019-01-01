package com.example.user.moviet.activities;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.moviet.R;
import com.example.user.moviet.model.Movie;
import com.example.user.moviet.model.MovieAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
//import static com.example.user.moviet.S

public class Choose_Movie extends AppCompatActivity {

    TextView textView7;
    TextView textView8;
    TextView textView10;
    ListView listView;
    FirebaseDatabase database;
    DatabaseReference ref;
    ArrayList<String> myMovies = new ArrayList<String>();
//    ArrayAdapter<String> adapter = new ArrayAdapter<Movie>(this,R.layout.activity_choose__movie,myMovies);




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose__movie);

        listView = (ListView) findViewById(R.id.list);
        textView7 = (TextView) findViewById(R.id.textView7);
        textView8 = (TextView) findViewById(R.id.textView8);
        textView10 = (TextView) findViewById(R.id.textView10);

        textView7.setText(Choose_Cinema.mySelection.getMyDate());
        textView8.setText(Choose_Cinema.mySelection.getMyGenre());
        textView10.setText(Choose_Cinema.mySelection.getMyCinema());

        final String MyCinema=Choose_Cinema.mySelection.getMyCinema();
        final String MyGenre=Choose_Cinema.mySelection.getMyGenre();
        final String MyDate=Choose_Cinema.mySelection.getMyDate();


        database = FirebaseDatabase.getInstance();
        ref = database.getReference("Cinemas").child(MyCinema).child(MyGenre).child(MyDate);


        ref.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                Toast.makeText(Choose_Movie.this,dataSnapshot.child("0").getValue().toString()+" "+dataSnapshot.child("2").getValue().toString()+" "+dataSnapshot.child("Shrek").child("0").getValue().toString(),Toast.LENGTH_SHORT).show();
                    int count=0;
                    for(DataSnapshot ds: dataSnapshot.getChildren()) {
                        myMovies.add(ds.getValue()+ " "+ ds.getKey());
                        count++;
//                        Toast.makeText(Choose_Movie.this, ds.getValue().toString(),Toast.LENGTH_SHORT).show();
//                        adapter.add(ds.getValue().toString());
                    }
                    ArrayAdapter<String> adapter = new MovieAdapter(getApplicationContext(),myMovies);
                    if (count==0) {
                        Toast.makeText(Choose_Movie.this, "No movies today, choose another date.",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Choose_Movie.this,Choose_Cinema.class));
                    }
                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }
}
