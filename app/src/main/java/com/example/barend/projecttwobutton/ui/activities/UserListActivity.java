package com.example.barend.projecttwobutton.ui.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.barend.projecttwobutton.R;

/**
 * Created by Barend on 2017/05/29.
 */

public class UserListActivity extends Activity {

    private static final String TAG = "UserListActivity";

    //region start activity
    public static void startActivity(Context context) {

        Intent intent = new Intent(context, UserListActivity.class);

        context.startActivity(intent);
    }
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);
    }
}
