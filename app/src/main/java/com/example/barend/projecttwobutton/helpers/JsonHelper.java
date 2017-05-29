package com.example.barend.projecttwobutton.helpers;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Just a small helper class to keep code clean
 *
 * how to use:
 * just give class constructor the jsonobject you want to use:
 * JsonHelper jsonHelper = new JsonHelper(JSONObject);
 */

public class JsonHelper {

    public static final String DEFAULT_STRING = "";
    public static final int DEFAULT_INT = -1;

    private JSONObject mObject;

    public JsonHelper(JSONObject object) {
        mObject = object;
    }

    public String getString(String name){
        return getString(name, DEFAULT_STRING);
    }

    public String getString(String name, String defaultValue){
        try{
            return get(name, defaultValue);
        } catch (ClassCastException e){
            return defaultValue;
        }
    }

    public int getInt(String name){
        return getInt(name, DEFAULT_INT);
    }

    public int getInt(String name, int defaultValue){
        try{
            return get(name, defaultValue);
        } catch (ClassCastException e){
            return defaultValue;
        }
    }

    public JSONObject getObject(String name){
        if(mObject.has(name)){
            try{
                return mObject.getJSONObject(name);
            } catch (JSONException e){
                return null;
            } catch (ClassCastException e){
                return null;
            }
        } else {
            return null;
        }
    }

    public JSONArray getArray(String name){
        if(mObject.has(name)){
            try{
                return mObject.getJSONArray(name);
            } catch (JSONException e){
                return null;
            } catch (ClassCastException e){
                return null;
            }
        } else {
            return null;
        }
    }

    private <T> T get(String name, T defaultValue){
        if(isValid()){
            if(mObject.has(name)){
                try {
                    return (T) mObject.get(name);
                } catch (ClassCastException e){
                    e.printStackTrace();
                    return defaultValue;
                } catch (JSONException e){
                    e.printStackTrace();
                    return defaultValue;
                }
            } else {
                return defaultValue;
            }
        } else {
            return defaultValue;
        }
    }

    private boolean isValid(){
        if(mObject != null){
            return true;
        } else {
            return false;
        }
    }
}
