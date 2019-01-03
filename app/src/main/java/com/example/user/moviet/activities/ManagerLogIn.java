package com.example.user.moviet.activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.moviet.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ManagerLogIn extends AppCompatActivity {

    EditText passowrdInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_log_in);

        passowrdInput = (EditText) findViewById(R.id.editText12);

        Button button11 = findViewById(R.id.button11);
        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String passwordInputString = passowrdInput.getText().toString().trim();
                final DatabaseReference db = FirebaseDatabase.getInstance().getReference();

// need to check password of manager
                db.child("Manager");
                db.child("manager1");
                db.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        if (passowrdInput.getText().toString().equals(dataSnapshot.child("Manager").child("manager1").getValue().toString())){
                            Intent intent = new Intent(ManagerLogIn.this, InsertMovies.class);
                            startActivity(intent);
                        }
                        else{
                            Toast.makeText(ManagerLogIn.this, "Wrong Password!!! Try again.", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });


            }
        });

    }
}
