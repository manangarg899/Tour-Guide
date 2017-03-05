package com.example.manan.tourguide;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class RestaurantActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attraction);

        Toast.makeText(this, getResources().getString(R.string.toast), Toast.LENGTH_SHORT).show();

        /**
         * creating list of some famous restaurants.
         */

        final ArrayList<Places> places = new ArrayList<Places>();
        places.add(new Places(getResources().getString(R.string.restaurants_string_1), R.drawable.the_tavern, 30.332989, 78.053555));
        places.add(new Places(getResources().getString(R.string.restaurants_string_2), R.drawable.kfc, 30.366436, 78.070387));
        places.add(new Places(getResources().getString(R.string.restaurants_string_3), R.drawable.dominos, 30.292604, 78.058802));

        /**
         * inflating activity_attraction using custom adapter
         */

        PlacesAdapter placeAdapter = new PlacesAdapter(this, places);
        ListView listView = (ListView) findViewById(R.id.activity_attraction);
        listView.setAdapter(placeAdapter);

        /**
         * setting onItemClick listener to intent clicked place in maps.
         */

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Places place = places.get(position);

                String label = place.getName();
                String uriBegin = "geo:" + place.getLatitude() + "," + place.getLongitude();
                String query = place.getLatitude() + "," + place.getLongitude() + "(" + label + ")";
                String uriString = uriBegin + "?q=" + Uri.encode(query) + "&z=16";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uriString));
                startActivity(intent);

            }
        });
    }
}
