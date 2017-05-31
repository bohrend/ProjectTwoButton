package com.example.barend.projecttwobutton.ui.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.barend.projecttwobutton.R;

/**
 * Created by Barend on 2017/05/30.
 *
 * viewholder class for recyclerview
 */

public class UserViewHolder extends RecyclerView.ViewHolder {

    public TextView mUserNameTextView;

    public UserViewHolder(View itemView) {
        super(itemView);
        mUserNameTextView = (TextView) itemView.findViewById(R.id.txt_username);
    }


}
