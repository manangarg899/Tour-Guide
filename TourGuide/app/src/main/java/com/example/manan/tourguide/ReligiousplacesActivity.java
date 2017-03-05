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

public class ReligiousplacesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attraction);

        Toast.makeText(this, getResources().getString(R.string.toast), Toast.LENGTH_SHORT).show();

        /**
         * creating list of some famous temples
         */

        final ArrayList<Places> places = new ArrayList<Places>();
        places.add(new Places(getResources().getString(R.string.rel_place_string_1), R.drawable.tapkeshwar_temple, 30.357266, 78.016651));
        places.add(new Places(getResources().getString(R.string.rel_place_string_2), R.drawable.tibetan_buddhist_temple, 30.379253, 78.087033));
        places.add(new Places(getResources().getString(R.string.rel_place_string_3), R.drawable.sai_baba, 30.379898, 78.087236));

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
