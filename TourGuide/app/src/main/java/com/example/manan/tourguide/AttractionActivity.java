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

public class AttractionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attraction);

        Toast.makeText(this, getResources().getString(R.string.toast), Toast.LENGTH_SHORT).show();

        /**
         * creating list of visiting places
         */

        final ArrayList<Places> places = new ArrayList<Places>();
        places.add(new Places(getResources().getString(R.string.attraction_place_1), R.drawable.malsideer, 30.3897, 78.0747));
        places.add(new Places(getResources().getString(R.string.attraction_place_2), R.drawable.tigerfalls, 30.704893, 77.890341));
        places.add(new Places(getResources().getString(R.string.attraction_place_3), R.drawable.funvalley, 30.135775, 78.164686));
        places.add(new Places(getResources().getString(R.string.attraction_place_4), R.drawable.robbers_cave, 30.3771, 78.0605));
        places.add(new Places(getResources().getString(R.string.attraction_place_5), R.drawable.sahastradhara, 30.388392, 78.129361));

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
