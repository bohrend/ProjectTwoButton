package com.example.barend.projecttwobutton.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.barend.projecttwobutton.R;
import com.example.barend.projecttwobutton.datatypes.User;
import com.example.barend.projecttwobutton.ui.viewholders.UserViewHolder;

import java.util.ArrayList;

/**
 * Created by Barend on 2017/05/29.
 */

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder> {

    private Context mContext;
    private ArrayList<User> mDataset;


    public UserAdapter(Context context, ArrayList<User> dataset) {
        this.mContext = context;
        this.mDataset = dataset;
    }


    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_user, parent, false);
        UserViewHolder userViewHolder = new UserViewHolder(v);
        return userViewHolder;
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        User user = mDataset.get(position);
        holder.mUserNameTextView.setText(user.getName());
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }


    public void updateDataset(ArrayList<User> users) {
        this.mDataset = new ArrayList<>();
        this.mDataset = users;
        notifyDataSetChanged();
    }
}
