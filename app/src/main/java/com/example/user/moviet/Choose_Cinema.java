package com.example.user.moviet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Choose_Cinema extends AppCompatActivity {
    ListView listview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose__cinema);

        listview = (ListView)findViewById(R.id.listview);
        final ArrayList<String> ListOfCinemas = new ArrayList <> ();
        ListOfCinemas.add("Tel Aviv");
        ListOfCinemas.add("Petach Tikva");
        ListOfCinemas.add("Ariel");
        ListOfCinemas.add("Itzhar");
        ListOfCinemas.add("Haifa");
        ListOfCinemas.add("Jerusalem");
        ListOfCinemas.add("Beer-Sheva");
//        ListOfCinemas.add("Hispin");
//        ListOfCinemas.add("Katzrin");
//        ListOfCinemas.add("Tzfat");


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,ListOfCinemas);
        listview.setAdapter(arrayAdapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView <?> parent, View view, int position, long id) {

                Intent myIntent = new Intent(getBaseContext(), Choose_Date.class);
                startActivity(myIntent);

                //  Toast.makeText(Choose_Cinema.this, "hannnniiii" + position + " " + ListOfCinemas.get(position).toString(),Toast.LENGTH_SHORT).show();
            }


        });

    }

}
