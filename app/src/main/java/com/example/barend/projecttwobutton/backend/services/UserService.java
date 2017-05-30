package com.example.barend.projecttwobutton.backend.services;

import android.content.Context;

import com.example.barend.projecttwobutton.backend.ApiInterface;
import com.example.barend.projecttwobutton.backend.IonWrapper;

/**
 * Created by Barend on 2017/05/29.
 * <p>
 * so my idea with the service for each object would be for the developer to only use this in readable method formats, and
 * not worry about ionwrapper / ionbuilder doing the actual call / logic
 */

public class UserService {

    private static final String TAG = "UserService";

    //region endpoints
    public static final String BASE_USERS = "/users";
    //endregion


    //returns list of users
    public static void getUsers(Context context, ApiInterface apiInterface) {
        IonWrapper.get(context, BASE_USERS, apiInterface);
    }

}
