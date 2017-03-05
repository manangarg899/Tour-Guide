package com.example.manan.tourguide;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Manan on 26-01-2017.
 */

public class PlacesAdapter extends ArrayAdapter<Places> {

    public PlacesAdapter(Activity context, ArrayList<Places> places) {
        super(context, 0, places);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        /**
         * inflating view if it is null
         */

        View list_view = convertView;

        if (list_view == null) {
            list_view = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_view, parent, false);
        }

        Places currentPlace = getItem(position);

        ImageView imageView = (ImageView) list_view.findViewById(R.id.res_image);
        imageView.setImageResource(currentPlace.getImageResId());

        TextView textView = (TextView) list_view.findViewById(R.id.name);
        textView.setText(currentPlace.getName());

        return list_view;
    }
}
