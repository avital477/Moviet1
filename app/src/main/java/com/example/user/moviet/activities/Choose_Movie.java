package com.example.user.moviet.activities;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
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
    private static final String TAG = "Choose_Movie";

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
        Log.v(TAG, "MyCinema "+MyCinema+" Mydate "+MyDate);
        ref = database.getReference("Cinemas").child(MyCinema).child(MyGenre).child(MyDate);
        ref.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    int count=0;
//                Log.v(TAG, dataSnapshot.toString());
//                Log.v(TAG, dataSnapshot.getChildren().toString());
                for(DataSnapshot ds : dataSnapshot.getChildren()){
                    String name = ds.getKey();
//                    Toast.makeText(Choose_Movie.this,"My name "+name,Toast.LENGTH_SHORT).show();
                    myMovies.add(name);
                    count++;
                }
//                dataSnapshot.child(dataSnapshot.getKey());
//
//                Toast.makeText(Choose_Movie.this,dataSnapshot.child(dataSnapshot.getKey()).toString(),Toast.LENGTH_SHORT).show();
//                    for(DataSnapshot ds: dataSnapshot.getChildren()) {
//                    myMovies.add(ds.getValue()+ " "+ ds.getKey());
////                        Toast.makeText(Choose_Movie.this,ds.,Toast.LENGTH_SHORT).show();
//
//                    count++;
//                }

                    ArrayAdapter<String> adapter = new MovieAdapter(getApplicationContext(),myMovies);
                    if (count==0) {
                        Toast.makeText(Choose_Movie.this, "No movies today, go back and choose another date.",Toast.LENGTH_SHORT).show();
                    }

                    listView.setAdapter(adapter);
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                String myChoise = myMovies.get(position);
                                Intent intent= new Intent(Choose_Movie.this,Choose_Seat.class);
                                intent.putExtra("My choise: ",myChoise);
                                startActivity(intent);
                        }
                    });
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }
}
