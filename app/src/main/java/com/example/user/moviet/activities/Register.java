package com.example.user.moviet.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.user.moviet.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {

    EditText emailInput;
    EditText passowrdInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        emailInput = (EditText)findViewById(R.id.editText3);
        passowrdInput = (EditText)findViewById(R.id.editText4);


        Button button7 = findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final DatabaseReference db = FirebaseDatabase.getInstance().getReference();
                String EmailString=emailInput.getText().toString();
                db.child("Users").child(EmailString.replace(".", "|")).setValue(passowrdInput.getText().toString());
                Intent myIntent = new Intent(Register.this, Order_or_Cancle.class);
                startActivity(myIntent);
               // Toast.makeText(Register.this,emailInput.getText().toString()+" , "+passowrdInput.getText().toString(), Toast.LENGTH_LONG).show();

            }
        });

    }


}
