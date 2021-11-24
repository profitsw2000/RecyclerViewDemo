package ru.profitsw2000.recyclerviewdemo;

import android.os.Bundle;

public interface FragmentActionListener {

    String ACTION_KEY = "action_key"    ;
    int ACTION_VALUE_CLUB_SELECTED = 1  ;
    int ACTION_VALUE_ADD_CLUB = 2  ;
    int ACTION_VALUE_CLUB_ADDED = 3  ;
    String KEY_SELECTED_CLUB = "KEY_SELECTED_CLUB"    ;

    void onActionPerformed(Bundle bundle)    ;
}
