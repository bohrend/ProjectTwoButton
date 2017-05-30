package com.example.barend.projecttwobutton.datatypes;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.barend.projecttwobutton.keys.JsonKeys;
import com.example.barend.projecttwobutton.helpers.JsonHelper;
import com.google.gson.JsonObject;

import org.json.JSONObject;

/**
 * Created by Barend on 2017/05/29.
 */

public class Address implements Parcelable {

    //region members
    private String mStreet;
    private String mSuite;
    private String mCity;
    private String mZipcode;
    private Geo mGeo;
    //endregion

    //region contructors
    public Address() {
    }

    ;
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
    public static Address fromApi(JsonObject jsonObject) {
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

    //region parcelable related (used for passing datatype around in app

    protected Address(Parcel in) {
        mStreet = in.readString();
        mSuite = in.readString();
        mCity = in.readString();
        mZipcode = in.readString();
        mGeo = in.readParcelable(Geo.class.getClassLoader());
    }

    public static final Creator<Address> CREATOR = new Creator<Address>() {
        @Override
        public Address createFromParcel(Parcel in) {
            return new Address(in);
        }

        @Override
        public Address[] newArray(int size) {
            return new Address[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mStreet);
        parcel.writeString(mSuite);
        parcel.writeString(mCity);
        parcel.writeString(mZipcode);
        parcel.writeParcelable(mGeo, i);
    }
    //endregion
}
