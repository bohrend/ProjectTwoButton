package com.example.barend.projecttwobutton.datatypes;

import com.example.barend.projecttwobutton.backend.keys.JsonKeys;
import com.example.barend.projecttwobutton.helpers.JsonHelper;

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

    public String getStreet() {
        return mStreet;
    }

    public void setStreet(String street) {
        mStreet = street;
    }

    public String getSuite() {
        return mSuite;
    }

    public void setSuite(String suite) {
        mSuite = suite;
    }

    public String getCity() {
        return mCity;
    }

    public void setCity(String city) {
        mCity = city;
    }

    public String getZipcode() {
        return mZipcode;
    }

    public void setZipcode(String zipcode) {
        mZipcode = zipcode;
    }

    public Geo getGeo() {
        return mGeo;
    }

    public void setGeo(Geo geo) {
        mGeo = geo;
    }


    //endregion

    //region to and from api
    public static Address fromApi(JSONObject jsonObject) {
        Address toReturn = new Address();
        JsonHelper jsonHelper = new JsonHelper(jsonObject);

        toReturn.setStreet(jsonHelper.getString(JsonKeys.STREET));
        toReturn.setSuite(jsonHelper.getString(JsonKeys.SUITE));
        toReturn.setCity(jsonHelper.getString(JsonKeys.CITY));
        toReturn.setZipcode(jsonHelper.getString(JsonKeys.ZIPCODE));

        toReturn.setGeo(Geo.fromApi(jsonHelper.getObject(JsonKeys.GEO)));

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
