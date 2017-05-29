package com.example.barend.projecttwobutton.datatypes;

import com.example.barend.projecttwobutton.backend.keys.JsonKeys;
import com.example.barend.projecttwobutton.helpers.JsonHelper;

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

    public String getLat() {
        return mLat;
    }

    public void setLat(String lat) {
        mLat = lat;
    }

    public String getLng() {
        return mLng;
    }

    public void setLng(String lng) {
        mLng = lng;
    }

    //endregion

    //region to and from api
    public static Geo fromApi(JSONObject jsonObject) {
        Geo toReturn = new Geo();

        JsonHelper jsonHelper = new JsonHelper(jsonObject);

        toReturn.setLat(jsonHelper.getString(JsonKeys.LAT));
        toReturn.setLng(jsonHelper.getString(JsonKeys.LNG));

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