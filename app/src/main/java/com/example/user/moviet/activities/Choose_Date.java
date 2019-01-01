package com.example.user.moviet.activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CalendarView;

import com.example.user.moviet.R;

public class Choose_Date extends AppCompatActivity {

public static String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose__date);

        CalendarView calendarView = findViewById(R.id.calendarView2);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                month = month + 1;
                date = dayOfMonth + "-" + month + "-" + year;
//                Toast.makeText(Choose_Date.this, "Date: " + date,Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Choose_Date.this, Choose_Cinema.class);
                intent.putExtra("date", "\n\n The date is:  " + date + "\n");
                startActivity(intent);
            }
        });

//        TextView textView = findViewById(R.id.textView);
//       Button button = findViewById(R.id.button5);
//
//        String date = getIntent().getStringExtra("date");
//        if(date!= null)
////            textView.setText(date);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent intent = new Intent (Choose_Date.this, Choose_Genre.class);
//                startActivity(intent);
//            }
//        });
//    }

//    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//        Intent myIntent = new Intent(getBaseContext(), Choose_Genre.class);
//        startActivity(myIntent);
//    }
//
//    public void onButtonClick(View v) {
//        Intent myIntent = new Intent(getBaseContext(), Choose_Genre.class);
//        startActivity(myIntent);
//    }
    }

}
