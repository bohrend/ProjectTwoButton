package com.example.barend.projecttwobutton.datatypes;

import org.json.JSONObject;

/**
 * Created by Barend on 2017/05/29.
 */

public class Geo {

    //region members
    private String mLat;
    private String mLng;
    //endregion

    //region getters and setters
    public String getmLat() {
        return mLat;
    }

    public void setmLat(String mLat) {
        this.mLat = mLat;
    }

    public String getmLng() {
        return mLng;
    }

    public void setmLng(String mLng) {
        this.mLng = mLng;
    }
    //endregion

    //region to and from api
    public static Geo fromApi(JSONObject jsonObject) {
        Geo toReturn = new Geo();

        return toReturn;
    }

    //endregion

    //region toString
    @Override
    public String toString() {
        return "Geo{" +
                "mLat='" + mLat + '\'' +
                ", mLng='" + mLng + '\'' +
                '}';
    }
    //endregion
}