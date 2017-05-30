package com.example.barend.projecttwobutton.backend;

import android.content.Context;
import android.util.Log;

import com.example.barend.projecttwobutton.ServerConfig;
import com.example.barend.projecttwobutton.enums.HttpMethod;
import com.example.barend.projecttwobutton.helpers.NetworkHelper;
import com.koushikdutta.ion.Ion;

/**
 * Created by Barend on 2017/05/30.
 * just simple wrapper for ion, just so if things change in lib, I only need to change it here, and not everywhere in app
 */

public class IonWrapper {

    private static final String TAG = "IonWrapper";

    public static void get(Context context, String endpoint, ApiInterface apiInterface) {
        Log.i(TAG, "get" + endpoint);

        new IonBuilder(HttpMethod.GET.toString(), ServerConfig.getBaseUrl() + endpoint, apiInterface);
    }

    //builder pattern used for ion, mainly because in future it can grow to posts, and more thingies need be added, builder seemed likecorrect way to go
    private static class IonBuilder {
        private String mRestfulMethod;
        private String mUrl;
        private ApiInterface mApiInterface;

        public IonBuilder(String restfulMethod, String url, ApiInterface apiInterface) {
            this.mRestfulMethod = restfulMethod;
            this.mUrl = url;
            this.mApiInterface = apiInterface;
        }

        public void build(Context context) {

            mApiInterface.onStart();

            //can do few checks here in future for now only internet necessary i would say
            if (NetworkHelper.isConnected(context)) {
                Ion.with(context)
                        .load(this.mRestfulMethod, this.mUrl)
                        .asString()
                        .withResponse()
                        .setCallback(this.mApiInterface);
            } else {
                mApiInterface.onComplete();
                mApiInterface.onNoConnection();
            }
        }
    }
}
