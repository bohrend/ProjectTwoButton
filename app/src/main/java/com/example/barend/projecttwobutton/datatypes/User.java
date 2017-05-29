package com.example.barend.projecttwobutton.datatypes;

import com.example.barend.projecttwobutton.helpers.JsonHelper;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Barend on 2017/05/29.
 */

public class User {

    //region members
    private int mId;
    private String mUsername;
    private String mEmail;
    private Address mAddress;
    private String mPhone;
    private String mWebsite;
    private Company mCompany;
    //endregion

    //region getters and setters
    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmUsername() {
        return mUsername;
    }

    public void setmUsername(String mUsername) {
        this.mUsername = mUsername;
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public Address getmAddress() {
        return mAddress;
    }

    public void setmAddress(Address mAddress) {
        this.mAddress = mAddress;
    }

    public String getmPhone() {
        return mPhone;
    }

    public void setmPhone(String mPhone) {
        this.mPhone = mPhone;
    }

    public String getmWebsite() {
        return mWebsite;
    }

    public void setmWebsite(String mWebsite) {
        this.mWebsite = mWebsite;
    }

    public Company getmCompany() {
        return mCompany;
    }

    public void setmCompany(Company mCompany) {
        this.mCompany = mCompany;
    }


    //endregion

    //region to and from api

    private static User fromApi(JSONObject jsonObject) {
        User toReturn = new User();
        JsonHelper jsonHelper = new JsonHelper(jsonObject);

        jsonHelper.isValid()

        return toReturn;
    }

    public static ArrayList<User> fromApi(JSONArray jsonArray) {
        ArrayList<User> toReturn = new ArrayList<>();
        User user;

        for (int i = 0; i < jsonArray.length(); i++) {
            user = fromApi(jsonArray.getJSONObject(i));
            toReturn.add(user);
        }
        return toReturn;
    }
    //endregion

    //region toString
    @Override
    public String toString() {
        return "User{" +
                "mId=" + mId +
                ", mUsername='" + mUsername + '\'' +
                ", mEmail='" + mEmail + '\'' +
                ", mAddress=" + mAddress +
                ", mPhone='" + mPhone + '\'' +
                ", mWebsite='" + mWebsite + '\'' +
                ", mCompany=" + mCompany +
                '}';
    }
    //endregion

}
