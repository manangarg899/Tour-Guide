package com.example.manan.tourguide;

/**
 * Created by Manan on 26-01-2017.
 */

public class Places {

    private String mName;
    private int mImageResId;
    private double mLatitude;
    private double mLongitude;

    /**
     * @param name       to svae the name of place
     * @param imageResId to save image resource id
     * @param latitude   to locate place to visit in image
     * @param longitude  to locate place to visit in image
     */

    public Places(String name, int imageResId, double latitude, double longitude) {
        mImageResId = imageResId;
        mName = name;
        mLatitude = latitude;
        mLongitude = longitude;
    }

    public int getImageResId() {
        return mImageResId;
    }

    public String getName() {
        return mName;
    }

    public double getLatitude() {
        return mLatitude;
    }

    public double getLongitude() {
        return mLongitude;
    }
}
