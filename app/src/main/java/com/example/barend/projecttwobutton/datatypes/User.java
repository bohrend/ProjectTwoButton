package com.example.barend.projecttwobutton.datatypes;

import com.example.barend.projecttwobutton.backend.keys.JsonKeys;
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
    private String mName;
    private String mUsername;
    private String mEmail;
    private Address mAddress;
    private String mPhone;
    private String mWebsite;
    private Company mCompany;
    //endregion

    //region getters and setters

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getUsername() {
        return mUsername;
    }

    public void setUsername(String username) {
        mUsername = username;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    public Address getAddress() {
        return mAddress;
    }

    public void setAddress(Address address) {
        mAddress = address;
    }

    public String getPhone() {
        return mPhone;
    }

    public void setPhone(String phone) {
        mPhone = phone;
    }

    public String getWebsite() {
        return mWebsite;
    }

    public void setWebsite(String website) {
        mWebsite = website;
    }

    public Company getCompany() {
        return mCompany;
    }

    public void setCompany(Company company) {
        mCompany = company;
    }

    //endregion

    //region to and from api

    private static User fromApi(JSONObject jsonObject) {
        User toReturn = new User();
        JsonHelper jsonHelper = new JsonHelper(jsonObject);

        jsonHelper.getString(JsonKeys.NAME)


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
