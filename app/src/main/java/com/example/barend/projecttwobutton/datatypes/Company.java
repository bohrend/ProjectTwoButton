package com.example.barend.projecttwobutton.datatypes;

import com.example.barend.projecttwobutton.backend.keys.JsonKeys;
import com.example.barend.projecttwobutton.helpers.JsonHelper;

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
    public static Company fromApi(JSONObject jsonObject) {
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
}
