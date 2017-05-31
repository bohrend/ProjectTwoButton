package com.example.barend.projecttwobutton.ui.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.barend.projecttwobutton.R;
import com.example.barend.projecttwobutton.keys.IntentKeys;

/**
 * Created by Barend on 2017/05/29.
 * <p>
 * idea is to pass through userid, and display rest of details here, but then db or better storage needs be setup
 */

public class UserDetailsActivity extends Activity {

    private static final String TAG = "UserDetailsActivity";

    //region members
    private int mUserId;
    //endregion

    //region start activity
    public static void startActivity(Context context, int userId) {

        Intent intent = new Intent(context, UserDetailsActivity.class);
        intent.putExtra(IntentKeys.EXTRA_USER_ID, userId);

        context.startActivity(intent);
    }

    public static void startActivity(Context context) {
        startActivity(context, 0);
    }
    //endregion

    //region page state and instance saving logic
    @Override
    protected void onSaveInstanceState(Bundle outState) {

        if (outState == null) {
            outState = new Bundle();
        }

        outState.putInt(IntentKeys.EXTRA_USER_ID, mUserId);
        super.onSaveInstanceState(outState);
    }

    private void handleState(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            mUserId = savedInstanceState.getInt(IntentKeys.EXTRA_USER_ID);
        } else {
            mUserId = getIntent().getIntExtra(IntentKeys.EXTRA_USER_ID, 0);
        }
    }

    //endregion


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);

        handleState(savedInstanceState);
    }
}
