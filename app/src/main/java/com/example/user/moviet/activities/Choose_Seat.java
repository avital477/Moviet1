package com.example.user.moviet.activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.moviet.R;
import com.example.user.moviet.model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static com.example.user.moviet.activities.MainActivity.user;

public class Choose_Seat extends AppCompatActivity {


    TextView TotalPrice;
    int NumOfSeats;
    TextView textView15;
    private static final String TAG = "Choose_Seat";
    DatabaseReference ref;
    String freeSeats;
    TextView textView19;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choos__seat);

        final String myChoise = getIntent().getStringExtra("My choise: ");
        final DatabaseReference db = FirebaseDatabase.getInstance().getReference();


        textView15 = (TextView) findViewById(R.id.textView15);
        textView19 = (TextView) findViewById(R.id.textView19);

        ref = db.child("Cinemas")
                .child(Choose_Cinema.mySelection.getMyCinema())
                .child(Choose_Cinema.mySelection.getMyGenre())
                .child(Choose_Cinema.mySelection.getMyDate())
                .child(myChoise).child("Theater");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                freeSeats = dataSnapshot.getValue().toString();
                textView19.setText(freeSeats);

//                textView15.setText(textView15.getText());
//                Toast.makeText(Choose_Seat.this, "freeSeats "+freeSeats,Toast.LENGTH_SHORT).show();
               // Toast.makeText(Choose_Seat.this, user.getEmail()+" "+user.getPassword(),Toast.LENGTH_SHORT).show();

//                if (NumOfSeats > Integer.parseInt(freeSeats)) {
//                    Toast.makeText(Choose_Seat.this, "You can only order less than " + freeSeats + " seats!",Toast.LENGTH_SHORT).show();
//                    Intent myIntent = new Intent(Choose_Seat.this, Choose_Seat.class);
//                    startActivity(myIntent);
//                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
//------ Start OK Button ------------------------------------------------------------------
        Button tprice= (Button) findViewById(R.id.tprice) ;
        tprice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


               // if (Integer.parseInt(editText5.getText()) <)
                EditText editText5 = (EditText) findViewById(R.id.editText5);
                NumOfSeats = Integer.parseInt(editText5.getText().toString());

                if (NumOfSeats > Integer.parseInt(freeSeats)) {
                    Toast.makeText(Choose_Seat.this, "You can only order less than " + freeSeats + " seats!",Toast.LENGTH_SHORT).show();
//                    Intent myIntent = new Intent(Choose_Seat.this, Choose_Seat.class);
//                    startActivity(myIntent);
                }
                else {
                    TotalPrice = (TextView) findViewById(R.id.textView14);
                    TotalPrice.setText("Total price: " + NumOfSeats * 10 + "$");
                }
//                Toast.makeText(Choose_Seat.this, "your price: "+NumOfSeats,Toast.LENGTH_SHORT).show();

            }
        });
//------- End OK Button ------------------------------------------------------------------
//--------------------start next button-----------------------------------
        Button next= (Button) findViewById(R.id.next) ;
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.child("Cinemas")
                        .child(Choose_Cinema.mySelection.getMyCinema())
                        .child(Choose_Cinema.mySelection.getMyGenre())
                        .child(Choose_Cinema.mySelection.getMyDate())
                        .child(myChoise).child(user.getEmail()).setValue(NumOfSeats);


                int updateSeats = Integer.parseInt(freeSeats)- NumOfSeats;

                db.child("Cinemas")
                        .child(Choose_Cinema.mySelection.getMyCinema())
                        .child(Choose_Cinema.mySelection.getMyGenre())
                        .child(Choose_Cinema.mySelection.getMyDate())
                        .child(myChoise).child("Theater").setValue(updateSeats);

//                Toast.makeText(Choose_Seat.this, "update free seats: "+updateSeats,Toast.LENGTH_SHORT).show();

                Intent myIntent = new Intent(Choose_Seat.this, Pay.class);
                startActivity(myIntent);
            }
        });
//------- End next Button ------------------------------------------------------------------

    }
}
