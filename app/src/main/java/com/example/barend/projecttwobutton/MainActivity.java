package com.example.barend.projecttwobutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


import com.example.barend.projecttwobutton.ui.activities.UserListActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    //region members
    private Button mMakeCallButton;
    private Button mShowInfoButton;
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupView();
    }

    private void setupView() {
        mMakeCallButton = (Button) findViewById(R.id.btn_make_call);
        mShowInfoButton = (Button) findViewById(R.id.btn_show_info);

        mMakeCallButton.setOnClickListener(new OnMakeCallClickListener());
        mShowInfoButton.setOnClickListener(new OnShowInfoClickListener());
    }

    //region listeners
    private class OnMakeCallClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            Log.i(TAG, "OnMakeCallClickListener+onClick");
            UserListActivity.startActivity(MainActivity.this);
        }
    }

    private class OnShowInfoClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            Log.i(TAG, "OnShowInfoClickListener+onClick");
        }
    }


    //endregion
}