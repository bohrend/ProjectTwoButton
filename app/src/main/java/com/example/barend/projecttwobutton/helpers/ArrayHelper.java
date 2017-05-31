package com.example.barend.projecttwobutton.helpers;

import android.content.Context;
import android.text.TextUtils;

import com.example.barend.projecttwobutton.R;
import com.example.barend.projecttwobutton.datatypes.User;

import java.util.ArrayList;

/**
 * Created by Barend on 2017/05/31.
 */

public class ArrayHelper {


    //usually stick to a method only does one thing rule, but this was quicker to do
    public static CharSequence[] getCharSquence(Context context, ArrayList<User> userArrayList, String filterOption) {

        //make charsequence specific for assessment purposes (alertdialog takes that)
        CharSequence[] toReturn;
        ArrayList<String> list = new ArrayList<>();

        //if is no filteroption is given return list of all names
        if (TextUtils.isEmpty(filterOption)) {
            for (int i = 0; i < userArrayList.size(); i++) {
                list.add(userArrayList.get(i).getName());
            }
        } else {
            //if filteroption is given return the email of the filteroption given
            boolean found = false;
            for (int i = 0; i < userArrayList.size(); i++) {
                User user = userArrayList.get(i);
                String name = user.getUsername();

                if (name.equals(filterOption)) {
                    list.add(user.getEmail());
                    found = true;
                }
            }

            if (!found) {
                list.add(context.getResources().getString(R.string.text_not_found));
            }
        }

        toReturn = list.toArray(new CharSequence[list.size()]);
        return toReturn;
    }
}
