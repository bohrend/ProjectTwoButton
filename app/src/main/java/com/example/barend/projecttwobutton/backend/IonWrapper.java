package com.example.barend.projecttwobutton.backend;

import android.content.Context;
import android.util.Log;

import com.example.barend.projecttwobutton.ServerConfig;
import com.example.barend.projecttwobutton.enums.HttpMethod;
import com.example.barend.projecttwobutton.helpers.NetworkHelper;
import com.koushikdutta.ion.Ion;

import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/**
 * Created by Barend on 2017/05/30.
 * just simple wrapper for ion, just so if things change in lib, I only need to change it here, and not everywhere in app
 */

public class IonWrapper {

    private static void nuke(Context context) {
        try {
            TrustManager[] trustManager = new TrustManager[]{
                    new X509TrustManager() {
                        @Override
                        public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

                        }

                        @Override
                        public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

                        }

                        @Override
                        public X509Certificate[] getAcceptedIssuers() {
                            X509Certificate[] trustedAnchors = new X509Certificate[0];
                            return trustedAnchors;
                        }
                    }
            };

            Ion ion = Ion.getDefault(context);

            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustManager, new SecureRandom());
            ion.configure().createSSLContext("TLS");
            ion.getHttpClient().getSSLSocketMiddleware().setSSLContext(sc);
            ion.getHttpClient().getSSLSocketMiddleware().setTrustManagers(trustManager);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static final String TAG = "IonWrapper";

    public static void get(Context context, String endpoint, ApiInterface apiInterface) {
        String url = ServerConfig.getBaseUrl() + endpoint;
        Log.i(TAG, "get " + url);

        new IonBuilder(HttpMethod.GET.toString(), url, apiInterface)
                .build(context);
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
