package com.example.user.moviet;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class Choose_Genre extends AppCompatActivity {
    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose__genre);


        listview = (ListView) findViewById(R.id.listviewGenre);
        final ArrayList<String> ListOfGenre = new ArrayList<>();
        ListOfGenre.add("Action");
        ListOfGenre.add("Comedy");
        ListOfGenre.add("Crime");
        ListOfGenre.add("Drama");
        ListOfGenre.add("Docudrama");
        ListOfGenre.add("Romantic");
        ListOfGenre.add("Historical");


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ListOfGenre);
        listview.setAdapter(arrayAdapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent myIntent = new Intent(getBaseContext(), Choose_Movie.class);
                startActivity(myIntent);


            }

        });
    }

}





//        CalendarView calendarView = findViewById(R.id.calendarView2);
//        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
//            @Override
//            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
//
//                String date = year +"."+ month+"."+ dayOfMonth;
//                Toast.makeText(Choose_Genre.this, "Date: " + date,Toast.LENGTH_SHORT).show();
//            }
//        });



