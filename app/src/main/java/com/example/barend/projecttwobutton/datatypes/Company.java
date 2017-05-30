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

public class Company implements Parcelable {

    //region members
    private String mName;
    private String mCatchPhrase;
    private String mBullStuff;
    //endregion

    //region contructors
    public Company() {
    }

    ;


    //endregion

    //region getters and setters

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getCatchPhrase() {
        return mCatchPhrase;
    }

    public void setCatchPhrase(String catchPhrase) {
        mCatchPhrase = catchPhrase;
    }

    public String getBullStuff() {
        return mBullStuff;
    }

    public void setBullStuff(String bullStuff) {
        mBullStuff = bullStuff;
    }


    //endregion

    //region to and from api
    public static Company fromApi(JsonObject jsonObject) {
        Company toReturn = new Company();
        JsonHelper jsonHelper = new JsonHelper(jsonObject);

        toReturn.setName(jsonHelper.getString(JsonKeys.COMPANY_NAME));
        toReturn.setCatchPhrase(jsonHelper.getString(JsonKeys.CATCHPHRASE));
        toReturn.setBullStuff(jsonHelper.getString(JsonKeys.BULLSTUFF));

        return toReturn;
    }
    //endregion

    //region toString

    @Override
    public String toString() {
        return "Company{" +
                "mName='" + mName + '\'' +
                ", mCatchPhrase='" + mCatchPhrase + '\'' +
                ", mBullStuff='" + mBullStuff + '\'' +
                '}';
    }

    //endregion

    //region parcelable related (used for passing datatype around in app
    protected Company(Parcel in) {
        mName = in.readString();
        mCatchPhrase = in.readString();
        mBullStuff = in.readString();
    }

    public static final Creator<Company> CREATOR = new Creator<Company>() {
        @Override
        public Company createFromParcel(Parcel in) {
            return new Company(in);
        }

        @Override
        public Company[] newArray(int size) {
            return new Company[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mName);
        parcel.writeString(mCatchPhrase);
        parcel.writeString(mBullStuff);
    }

    //endregion
}
