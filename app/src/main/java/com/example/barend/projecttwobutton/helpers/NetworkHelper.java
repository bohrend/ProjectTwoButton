package com.example.barend.projecttwobutton.helpers;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Barend on 2017/05/30.
 *
 * small helper to check for connection
 */

public class NetworkHelper {

    //get network info
    private static NetworkInfo getNetworkInfo(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo();
    }


    //check if connectivity is available
    public static boolean isConnected(Context context) {
        NetworkInfo networkInfo = NetworkHelper.getNetworkInfo(context);
        return (networkInfo != null && networkInfo.isConnected());
    }
}
