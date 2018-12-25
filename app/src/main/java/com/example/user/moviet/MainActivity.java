package com.example.user.moviet;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class MainActivity extends AppCompatActivity {

    EditText emailInput;
    EditText passowrdInput;

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

                db.child("Users").child(emailInputString.replace(".", "|"))
                        .addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                boolean loginIsOk = false;
                                User user = null;
//                                Toast.makeText(MainActivity.this, "before: " + dataSnapshot.getValue(), Toast.LENGTH_LONG).show();
                                if(dataSnapshot.getValue() != null){
//                                    Toast.makeText(MainActivity.this, emailInputString+" , "+passwordInputString, Toast.LENGTH_LONG).show();
                                    if(passwordInputString.equals(dataSnapshot.getValue())){
                                        loginIsOk = true;
//                                        Toast.makeText(MainActivity.this, "login is OK", Toast.LENGTH_LONG).show();
//                                        user.setEmail(emailInputString);
//                                        user.setPassword(passwordInputString);

                                        Intent myIntent = new Intent(MainActivity.this, Order_or_Cancle.class);
                                        startActivity(myIntent);

                                    }
                                    else Toast.makeText(MainActivity.this, "Wrong Password! Please try again", Toast.LENGTH_LONG).show();

                                }
                                else Toast.makeText(MainActivity.this, "Wrong User! Please try again", Toast.LENGTH_LONG).show();
                            }
                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) { }
                });
//                Toast.makeText(MainActivity.this, "Wrong User! Please try again", Toast.LENGTH_LONG).show();
            }
        });
//Endstart******
    }
}

