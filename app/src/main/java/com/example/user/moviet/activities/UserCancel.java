package com.example.user.moviet.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.moviet.R;
import com.example.user.moviet.model.User;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static com.example.user.moviet.activities.MainActivity.user;

public class UserCancel extends AppCompatActivity {


    EditText cinema;
    EditText genre;
    EditText date;
    EditText movie;
    EditText id;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_cancel);

        cinema= (EditText)findViewById(R.id.editText7);
        genre= (EditText)findViewById(R.id.editText9);
        date= (EditText)findViewById(R.id.editText10);
        movie= (EditText)findViewById(R.id.editText11);

        final String cinemaString = cinema.getText().toString();
        final String genreString = genre.getText().toString();
        final String dateString = date.getText().toString();
        final String movieString = movie.getText().toString();

//        final String idUser= user.getEmail();


        Button cancelMyOrder= (Button) findViewById(R.id.button8) ;
        cancelMyOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(UserCancel.this, "your cinema: "+ idUser,Toast.LENGTH_SHORT).show();
                final DatabaseReference db = FirebaseDatabase.getInstance().getReference();
                db.child("Managers").child("hi").push();
//                .child("Cinema").child("Genre").child("Date").child("Movie").child("Id").setValue("hello");

               // Toast.makeText(UserCancel.this, user.getEmail(),Toast.LENGTH_SHORT).show();
//                db.child("Managers").child("Cinema").child("Genre").child("Date").child("Movie").child("Id").setValue("hello");
//                db.child("Managers").child("Cinema").child("Genre").child("Date").(movieString);


            }
        });


    }


}
