package com.example.user.moviet.activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.user.moviet.R;
import com.example.user.moviet.model.Select;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class InsertMovies extends AppCompatActivity {

    Spinner spCountries1;
    Spinner spBusinessType1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_movies);


        spCountries1 = (Spinner) findViewById(R.id.spCountries1);
        spBusinessType1 = (Spinner) findViewById(R.id.spBussinessType1);



//Button 110 choose date **************************************
        TextView textView=findViewById(R.id.textView9);
        Button button110 = findViewById(R.id.button110);
        String date=getIntent().getStringExtra("date");
        if(date!=null)
            textView.setText(date);

        button110.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent (InsertMovies.this, ManagerDate.class);
                startActivity(intent);
            }
        });
//End Button 110*********************************


// button 113 - next *****************************
        Button button113 = findViewById(R.id.button113);

        button113.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String MyCinema = spCountries1.getSelectedItem().toString();
                final String MyGenre = spBusinessType1.getSelectedItem().toString().trim();
                final String MyDate = ManagerDate.date;

                final DatabaseReference db = FirebaseDatabase.getInstance().getReference();

                EditText editText13=findViewById(R.id.editText13);
                String MyMovie = editText13.getText().toString();

                db.child("Cinemas")
                        .child(MyCinema).child(MyGenre).child(MyDate).child(MyMovie).child("Theater").setValue(50);


            }
        });
// END button 113 - next *****************************
    }
}
