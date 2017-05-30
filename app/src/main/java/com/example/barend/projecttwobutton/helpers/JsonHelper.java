package com.example.barend.projecttwobutton.helpers;

import android.util.Log;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Just a small helper class to keep code clean
 * <p>
 * how to use:
 * just give class constructor the jsonobject you want to use:
 * JsonHelper jsonHelper = new JsonHelper(JSONObject);
 */

public class JsonHelper {

    public static final String DEFAULT_STRING = "";
    public static final int DEFAULT_INT = -1;

    private JsonObject mObject;

    public JsonHelper(JsonObject object) {
        mObject = object;
    }

    public String getString(String name) {
        return getString(name, DEFAULT_STRING);
    }

    public String getString(String name, String defaultValue) {
        try {
            return mObject.get(name).getAsString();
        } catch (ClassCastException e) {
            return defaultValue;
        }
    }

    public int getInt(String name) {
        return getInt(name, DEFAULT_INT);
    }

    public int getInt(String name, int defaultValue) {
        try {
            return mObject.get(name).getAsInt();
        } catch (ClassCastException e) {
            return defaultValue;
        }
    }

    public JsonObject getObject(String name) {
        if (mObject.has(name)) {
            try {
                return mObject.getAsJsonObject(name);
            } catch (JsonParseException e) {
                return null;
            } catch (ClassCastException e) {
                return null;
            }
        } else {
            return null;
        }
    }

    public JsonArray getArray(String name) {
        if (mObject.has(name)) {
            try {
                return mObject.getAsJsonArray(name);
            } catch (JsonParseException e) {
                return null;
            } catch (ClassCastException e) {
                return null;
            }
        } else {
            return null;
        }
    }
}
