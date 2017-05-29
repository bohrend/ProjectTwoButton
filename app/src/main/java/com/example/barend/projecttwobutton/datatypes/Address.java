package com.example.barend.projecttwobutton.datatypes;

import android.provider.Telephony;

import org.json.JSONObject;

/**
 * Created by Barend on 2017/05/29.
 */

public class Address {

    //region members
    private String mStreet;
    private String mSuite;
    private String mCity;
    private String mZipcode;
    private Geo mGeo;
    //endregion

    //region getters and setters

    public String getmStreet() {
        return mStreet;
    }

    public void setmStreet(String mStreet) {
        this.mStreet = mStreet;
    }

    public String getmSuite() {
        return mSuite;
    }

    public void setmSuite(String mSuite) {
        this.mSuite = mSuite;
    }

    public String getmCity() {
        return mCity;
    }

    public void setmCity(String mCity) {
        this.mCity = mCity;
    }

    public String getmZipcode() {
        return mZipcode;
    }

    public void setmZipcode(String mZipcode) {
        this.mZipcode = mZipcode;
    }

    public Geo getmGeo() {
        return mGeo;
    }

    public void setmGeo(Geo mGeo) {
        this.mGeo = mGeo;
    }

    //endregion

    //region to and from api
    public static Address fromApi(JSONObject jsonObject) {
        Address toReturn = new Address();

        return toReturn;
    }
    //endregion

    //region toString
    @Override
    public String toString() {
        return "Address{" +
                "mStreet='" + mStreet + '\'' +
                ", mSuite='" + mSuite + '\'' +
                ", mCity='" + mCity + '\'' +
                ", mZipcode='" + mZipcode + '\'' +
                ", mGeo=" + mGeo +
                '}';
    }
    //endregion
}
