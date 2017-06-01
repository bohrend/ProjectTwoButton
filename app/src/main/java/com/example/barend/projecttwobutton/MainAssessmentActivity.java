package com.example.barend.projecttwobutton;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;

import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.barend.projecttwobutton.backend.ApiInterface;
import com.example.barend.projecttwobutton.backend.services.UserService;
import com.example.barend.projecttwobutton.datatypes.User;
import com.example.barend.projecttwobutton.helpers.ArrayHelper;
import com.example.barend.projecttwobutton.ui.activities.UserDetailsActivity;

import java.util.ArrayList;

/**
 * Created by Barend on 2017/05/31.
 * <p>
 * as main assessment request two alert dialogs to display data
 */

public class MainAssessmentActivity extends Activity {

    private static final String TAG = "MainAssessmentActivity";

    private static final String sTestingQuery = "Samantha";
    private ArrayList<User> mUserArrayList;

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
            UserService.getUsers(MainAssessmentActivity.this, new OnGetUsersApiInterface());
        }
    }

    private class OnShowInfoClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            Log.i(TAG, "OnShowInfoClickListener+onClick");

            if (mUserArrayList != null && mUserArrayList.size() > 0) {
                alertDialog(sTestingQuery);
            } else {
                UserService.getUsers(MainAssessmentActivity.this, new OnGetUsersApiInterface(sTestingQuery));
            }
        }
    }

    private class OnGetUsersApiInterface extends ApiInterface {

        private String mFilter;

        public OnGetUsersApiInterface() {
        }

        ;

        public OnGetUsersApiInterface(String filter) {
            this.mFilter = filter;
        }

        @Override
        public void onStart() {
            Log.i(TAG, "onStart()");
        }

        @Override
        public void onComplete() {
            Log.i(TAG, "onComplete()");
        }

        @Override
        public void onSuccess() {
            Log.i(TAG, "onSuccess()");

            if (mUserArrayList != null) {
                mUserArrayList.clear();
            }

            mUserArrayList = User.fromApi(getJsonArray());

            alertDialog(mFilter);
        }

        @Override
        public void onFail() {
            Log.i(TAG, "onFail()");

        }

        @Override
        public void onNoConnection() {
            Log.i(TAG, "onNoConnection()");

            //depends what you want to do here, can either go getMessage() to see what went wrong or do something like this:

            StringBuilder errorMessage = new StringBuilder();
            errorMessage.append(getResources().getString(R.string.text_error_no_internet));

            if (mUserArrayList != null && mUserArrayList.size() > 0) {
                errorMessage.append(getResources().getString(R.string.text_cached_data_available));

                alertDialog(mFilter);

            } else {
                errorMessage.append(getResources().getString(R.string.text_no_cached_data_available));
            }

            //will obvious show this to the user, but just for the sake of it trying to show as much different things as i possible can
            Log.d(TAG, errorMessage.toString());
        }
    }

    private class OnUserItemClickListener implements DialogInterface.OnClickListener {

        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            Log.i(TAG, "OnUserItemClickListener+onClick");

            //// TODO: 2017/05/31  future phase etc
            //go to detailed page of user
            UserDetailsActivity.startActivity(MainAssessmentActivity.this);
        }
    }

    //endregion

    private void alertDialog(String filter) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(MainAssessmentActivity.this);
        builder.setItems(ArrayHelper.getCharSquence(MainAssessmentActivity.this, mUserArrayList, filter), new OnUserItemClickListener());
        AlertDialog alertDialog = builder.create();

        alertDialog.show();
    }

}
