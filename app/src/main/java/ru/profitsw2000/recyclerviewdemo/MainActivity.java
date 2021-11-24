package ru.profitsw2000.recyclerviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements FragmentActionListener {

    FragmentManager fragmentManager ;
    FragmentTransaction fragmentTransaction ;
    Navigation navigation   ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigation = new Navigation(getSupportFragmentManager())    ;
        Bundle bundle = null    ;
        addFCListFragment(bundle);
    }

    private void addFCListFragment(Bundle bundle) {
        if (bundle != null) {
            ListFCFragment listFCFragment = new ListFCFragment()    ;
            listFCFragment.setFragmentActionListener(this);
            listFCFragment.setArguments(bundle);
            navigation.addFragment(listFCFragment,R.id.main_frame,false);
        } else {
            ListFCFragment listFCFragment = new ListFCFragment()    ;
            listFCFragment.setFragmentActionListener(this);
            navigation.addFragment(listFCFragment,R.id.main_frame,false);
        }
    }

    private void addFCDialogFragment() {
        AddClubFragment addClubFragment = new AddClubFragment() ;
        addClubFragment.setFragmentActionListener(this);
        navigation.addFragment(addClubFragment, R.id.main_frame, false);
    }

    /**
     * Method to start fragment with description of selected football club
     * @param bundle - parameters from main fragment
     */
    @Override
    public void onActionPerformed(Bundle bundle) {
        int actionPerformed = bundle.getInt(ACTION_KEY) ;
        switch (actionPerformed) {
            case FragmentActionListener.ACTION_VALUE_CLUB_SELECTED:
                break;
            case FragmentActionListener.ACTION_VALUE_ADD_CLUB:
                addFCDialogFragment();
                break;
            case FragmentActionListener.ACTION_VALUE_CLUB_ADDED:
                addFCListFragment(bundle);
                break;
        }
    }
}