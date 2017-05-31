package com.example.barend.projecttwobutton.backend;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Response;

/**
 * Created by Barend on 2017/05/30.
 * <p>
 * apiinterface used to process info from server, using ionwrapper/helper
 */

public abstract class ApiInterface implements FutureCallback<Response<String>> {

    private static final String TAG = "ApiInterface";

    //region server response codes
    private static final int STATUS_CODE_SUCCESS = 200;
    private static final int STATUS_CODE_FAILED = 400;
    //endregion

    //region abstract methods class / activities needs to implement
    public abstract void onStart();

    public abstract void onComplete();

    public abstract void onSuccess();

    public abstract void onFail();

    public abstract void onNoConnection();
    //endregion

    //region instance members
    private String mMessage;
    private JsonArray mJsonArray;
    //endregion

    //region to be used by classes using this interface
    public JsonArray getJsonArray() {
        return this.mJsonArray;
    }

    private void setJsonArray(JsonArray jsonArray) {
        this.mJsonArray = jsonArray;
    }

    //message will be used mainly for when it fails, so server related message can be given to user
    public String getMessage() {
        return this.mMessage;
    }

    private void setMessage(String message) {
        this.mMessage = message;
    }
    //endregion

    //ion overwritten method to inform that call has completed
    @Override
    public void onCompleted(Exception e, Response<String> result) {
        Log.i(TAG, "onCompleted+" + result);

        //no exception so call went through
        if (e == null) {
            parseFromServer(result);
        } else {
            setMessage(e.getMessage());
            onComplete();
            onFail();
        }
    }

    //method to parse data from server
    private void parseFromServer(Response<String> response) {

        JsonArray jsonArray;

        switch (response.getHeaders().code()) {
            case STATUS_CODE_SUCCESS: {

                Gson gson = new Gson();
                JsonElement jsonElement = gson.fromJson(response.getResult(), JsonElement.class);
                jsonArray = jsonElement.getAsJsonArray();

                setJsonArray(jsonArray);
                onComplete();
                onSuccess();

                break;
            }
            case STATUS_CODE_FAILED: {
                setMessage("failed"); //need to get context here to move string to strings
                onComplete();
                onFail();
                break;
            }
            default: {
                break;
            }
        }
    }
}
