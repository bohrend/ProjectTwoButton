package com.example.barend.projecttwobutton.ui.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.barend.projecttwobutton.R;
import com.example.barend.projecttwobutton.backend.ApiInterface;
import com.example.barend.projecttwobutton.backend.services.UserService;
import com.example.barend.projecttwobutton.datatypes.User;
import com.example.barend.projecttwobutton.ui.adapters.UserAdapter;

import java.util.ArrayList;

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

    private SwipeRefreshLayout mSwipeRefreshLayout;

    private RecyclerView mRecyclerView;
    private UserAdapter mUserAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

        setupView();
        setupRecyclerView();

        UserService.getUsers(UserListActivity.this, new OnGetUsersApiInterface());
    }

    private void setupView() {
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_layout);
        mSwipeRefreshLayout.setOnRefreshListener(new OnSwipeRefreshLayoutListener());

    }

    private void setupRecyclerView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(UserListActivity.this));
        mUserAdapter = new UserAdapter(UserListActivity.this, new ArrayList<User>());
        mRecyclerView.setAdapter(mUserAdapter);
    }


    //region listeners
    private class OnSwipeRefreshLayoutListener implements SwipeRefreshLayout.OnRefreshListener {

        @Override
        public void onRefresh() {
            UserService.getUsers(UserListActivity.this, new OnGetUsersApiInterface());
        }
    }

    private class OnGetUsersApiInterface extends ApiInterface {

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

            ArrayList<User> userArrayList = User.fromApi(getJsonArray());
            mUserAdapter.updateDataset(userArrayList);

            if (mSwipeRefreshLayout != null) {
                mSwipeRefreshLayout.setRefreshing(false);
            }
        }

        @Override
        public void onFail() {
            Log.i(TAG, "onFail()");

        }

        @Override
        public void onNoConnection() {
            Log.i(TAG, "onNoConnection()");
        }
    }

    //endregion
}
