package com.example.barend.projecttwobutton.datatypes;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.barend.projecttwobutton.keys.JsonKeys;
import com.example.barend.projecttwobutton.helpers.JsonHelper;

import org.json.JSONObject;

/**
 * Created by Barend on 2017/05/29.
 */

public class Geo implements Parcelable {

    //region members
    private String mLat;
    private String mLng;
    //endregion

    //region contructors
    public Geo() {
    }

    ;
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

    //region parcelable related (used for passing datatype around in app

    protected Geo(Parcel in) {
        mLat = in.readString();
        mLng = in.readString();
    }

    public static final Creator<Geo> CREATOR = new Creator<Geo>() {
        @Override
        public Geo createFromParcel(Parcel in) {
            return new Geo(in);
        }

        @Override
        public Geo[] newArray(int size) {
            return new Geo[size];
        }
    };


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mLat);
        parcel.writeString(mLng);
    }

    //endregion
}