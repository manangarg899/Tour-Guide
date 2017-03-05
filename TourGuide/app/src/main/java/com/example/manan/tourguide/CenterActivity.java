package com.example.manan.tourguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class CenterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_center);

        /**
         * calling explicit intents on click
         */

        ImageView rel_places = (ImageView) findViewById(R.id.rel_places);
        rel_places.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CenterActivity.this, ReligiousplacesActivity.class);
                startActivity(intent);
            }
        });

        ImageView restaurant = (ImageView) findViewById(R.id.restaurant);
        restaurant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CenterActivity.this, RestaurantActivity.class);
                startActivity(intent);
            }
        });

        ImageView galleria = (ImageView) findViewById(R.id.galleria);
        galleria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CenterActivity.this, GalleriaActivity.class);
                startActivity(intent);
            }
        });

        ImageView attraction = (ImageView) findViewById(R.id.attraction);
        attraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CenterActivity.this, AttractionActivity.class);
                startActivity(intent);
            }
        });


    }
}
