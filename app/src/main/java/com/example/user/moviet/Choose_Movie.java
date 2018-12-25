package com.example.user.moviet;

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
    Spinner getCinema;
    Spinner getGenre;
    TextView getDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose__cinema);
        getCinema=(Spinner)findViewById(spCountries);
        getGenre = (Spinner)findViewById(spBussinessType);
        getDate=(TextView)findViewById(textView9);
    }

    public void onLoginClick(View v){
        final String genreString= getGenre.toString();
        final String dateString= getDate.toString();
        final String cinemaString= getCinema.toString();
        final DatabaseReference db = FirebaseDatabase.getInstance().getReference();

        db.child("Moviet")
                .child(cinemaString.replace(".", "|")).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                boolean isCinema = false;
//                boolean isGenre = false;
//                boolean isDate = false;
                Select selection=null;
                Toast.makeText(Choose_Movie.this,"MyCinema ",Toast.LENGTH_SHORT).show();

                if(dataSnapshot.exists()){
                    selection=dataSnapshot.getValue(Select.class);
                 //   if (cinemaString.equals(user.getPassword())) {
                        Toast.makeText(Choose_Movie.this,"MyCinema "+selection.getMyCinema(),Toast.LENGTH_SHORT).show();
                 //   }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
//        DatabaseReference r_db = db.child("Ariel").child(Genre1.replace(".", "|"));

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_choose__movie);

//        DatabaseReference dbCinema;
//      dbCinema= FirebaseDatabase.getInstance().getReference("moviet");
//        dbCinema.addListenerForSingleValueEvent(valueEventListener);

//        Firebase.setAndroidContext(this);
//        send= (Button) findViewById(R.id.send_data);

    }

}
