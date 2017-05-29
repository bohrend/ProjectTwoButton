package com.example.barend.projecttwobutton.datatypes;

import org.json.JSONObject;

/**
 * Created by Barend on 2017/05/29.
 */

public class Company {

    //region members
    private String mName;
    private String mCatchPhrase;
    private String mBullStuff;
    //endregion

    //region getters and setters

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmCatchPhrase() {
        return mCatchPhrase;
    }

    public void setmCatchPhrase(String mCatchPhrase) {
        this.mCatchPhrase = mCatchPhrase;
    }

    public String getmBullStuff() {
        return mBullStuff;
    }

    public void setmBullStuff(String mBullStuff) {
        this.mBullStuff = mBullStuff;
    }

    //endregion

    //region to and from api
    public static Company fromApi(JSONObject jsonObject) {
        Company toReturn = new Company();

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
}
