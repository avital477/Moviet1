package com.example.user.moviet.activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CalendarView;

import com.example.user.moviet.R;

public class ManagerDate extends AppCompatActivity {

    public static String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_date);

        CalendarView calendarView = findViewById(R.id.calendarView22);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                month = month + 1;
                date = dayOfMonth + "-" + month + "-" + year;
//                Toast.makeText(Choose_Date.this, "Date: " + date,Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ManagerDate.this, InsertMovies.class);
                intent.putExtra("date", "\n\n The date is:  " + date + "\n");
                startActivity(intent);
            }
        });

    }

}

