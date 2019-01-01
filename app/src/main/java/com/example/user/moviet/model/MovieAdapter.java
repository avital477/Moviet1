package com.example.user.moviet.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.user.moviet.R;

import java.util.ArrayList;

public class MovieAdapter extends ArrayAdapter<String> {

    ArrayList<String> movies_id;

public MovieAdapter(Context context, ArrayList<String> movies) {
        super(context, 0, movies);
        movies_id = movies;
}

@Override
public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
//        String movies = getItem(position);
        final String new_movie_id  = movies_id.get(position);

    // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.movie_item, parent, false);
        }
        // Lookup view for data population
        TextView tvName = (TextView) convertView.findViewById(R.id.movie_id_txt);

//        TextView tvHome = (TextView) convertView.findViewById(R.id.tvHome);
        // Populate the data into the template view using the data object
//        tvName.setText(user.name);
//        tvHome.setText(user.hometown);
        tvName.setText(new_movie_id);
        // Return the completed view to render on screen
        return convertView;
        }
        }