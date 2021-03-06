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
import com.example.user.moviet.model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class MainActivity extends AppCompatActivity {

    EditText emailInput;
    EditText passowrdInput;
    public static User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//register*********
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, Register.class);
                startActivity(intent);
            }
        });
//end register***********

        emailInput = (EditText) findViewById(R.id.editText);
        passowrdInput = (EditText) findViewById(R.id.editText2);

//start******
        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String emailInputString = emailInput.getText().toString().trim();
                final String passwordInputString = passowrdInput.getText().toString().trim();
                final DatabaseReference db = FirebaseDatabase.getInstance().getReference();

                db.child("Users");
                db.child(emailInputString.replace(".", "|"));
                db.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        if (dataSnapshot.exists()) {
                            boolean loginIsOk = false;
                            final Object myPasswordPath = dataSnapshot.child("Users").child(emailInputString.replace(".", "|")).getValue();
                            final Object myEmailPath = dataSnapshot.child("Users").child(emailInputString.replace(".", "|")).getKey();


                            if (myPasswordPath.toString() != null) {
                                if (passwordInputString.equals(myPasswordPath) && emailInputString.replace(".", "|").equals(myEmailPath)) { // User is correct and Password is correct
                                    loginIsOk = true;
                                    user = new User(emailInputString, passwordInputString);
//                                    Toast.makeText(MainActivity.this, myEmailPath.toString(), Toast.LENGTH_LONG).show();
                                    Intent myIntent = new Intent(MainActivity.this, Order_or_Cancle.class);
                                    startActivity(myIntent); // Go to order or cancel activity

                                }
                                else { // User is correct, but password is wrong.
                                    Toast.makeText(MainActivity.this, "Wrong Password! Please try again " + myPasswordPath, Toast.LENGTH_LONG).show();
                                }
                            }
                        }else{
                            Intent myIntent = new Intent(MainActivity.this, MainActivity.class);
                            startActivity(myIntent);
                            Toast.makeText(MainActivity.this, "Wrong User! Please try again", Toast.LENGTH_LONG).show();

                        }
//                        if (!dataSnapshot.exists()){
//                            Intent myIntent = new Intent(MainActivity.this, MainActivity.class);
////                            startActivity(myIntent);
////                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                    }
                });
                // User is wrong
//                Toast.makeText(MainActivity.this, "Wrong User! Please try again", Toast.LENGTH_LONG).show();
//                Intent myIntent = new Intent(MainActivity.this, MainActivity.class);
//                startActivity(myIntent);
            }
        });
//Endstart******

        // manager*************************

        Button manager = findViewById((R.id.button9));
        manager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(MainActivity.this, ManagerLogIn.class);
                   startActivity(myIntent);
            }
        });


    }
}
