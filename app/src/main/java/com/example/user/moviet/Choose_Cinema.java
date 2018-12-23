package com.example.user.moviet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Choose_Cinema extends AppCompatActivity {
    // Wigets - GUI
    Spinner spCountries;
    Spinner spBusinessType;

    // Data Source


    // Adapter
//    ArrayAdapter<String> adapterBusinessType;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose__cinema);

        // Initialize Spinners

        spCountries = (Spinner) findViewById(R.id.spCountries);
        spBusinessType = (Spinner) findViewById(R.id.spBussinessType);

        // Initialize and set Adapter
//        adapterBusinessType = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, businessType);
//        spBusinessType.setAdapter(adapterBusinessType);

        // Country Item Selected Listener
        spCountries.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapter, View v, int position, long id) {
                // On selecting a spinner item
                String item = adapter.getItemAtPosition(position).toString();

                // Showing selected spinner item
//                Toast.makeText(getApplicationContext(), "Cinema : " + item, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }
        });


        // Business Type Item Selected Listener
        spBusinessType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapter, View v, int position, long id) {
                // On selecting a spinner item
                String item = adapter.getItemAtPosition(position).toString();

                // Showing selected spinner item
//                Toast.makeText(getApplicationContext(), "Genre : " + item, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }

        });


        TextView textView=findViewById(R.id.textView9);
        Button button = findViewById(R.id.button10);

        String date=getIntent().getStringExtra("date");
        if(date!=null)
            textView.setText(date);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent (Choose_Cinema.this, Choose_Date.class);
                startActivity(intent);
            }
        });
        Button button13 = findViewById(R.id.button13);
        button13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent (Choose_Cinema.this, Choose_Movie.class);
                startActivity(intent);
            }
        });


    }


}


//
//    ListView listview;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_choose__cinema);
//
//        listview = (ListView)findViewById(R.id.listview);
//        final ArrayList<String> ListOfCinemas = new ArrayList <> ();
//        ListOfCinemas.add("Tel Aviv");
//        ListOfCinemas.add("Petach Tikva");
//        ListOfCinemas.add("Ariel");
//        ListOfCinemas.add("Itzhar");
//        ListOfCinemas.add("Haifa");
//        ListOfCinemas.add("Jerusalem");
//        ListOfCinemas.add("Beer-Sheva");
////        ListOfCinemas.add("Hispin");
////        ListOfCinemas.add("Katzrin");
////        ListOfCinemas.add("Tzfat");
//
//
//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,ListOfCinemas);
//        listview.setAdapter(arrayAdapter);
//        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView <?> parent, View view, int position, long id) {
//
//                Intent myIntent = new Intent(getBaseContext(), Choose_Date.class);
//                startActivity(myIntent);
//
//                //  Toast.makeText(Choose_Cinema.this, "hannnniiii" + position + " " + ListOfCinemas.get(position).toString(),Toast.LENGTH_SHORT).show();
//            }
//
//
//        });
//
//    }
//
//}
