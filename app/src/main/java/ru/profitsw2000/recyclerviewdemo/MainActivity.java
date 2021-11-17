package ru.profitsw2000.recyclerviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    FragmentManager fragmentManager ;
    FragmentTransaction fragmentTransaction ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager()   ;
        addFCListFragment();
    }

    private void addFCListFragment() {
        fragmentTransaction = fragmentManager.beginTransaction()    ;
        ListFCFragment listFCFragment = new ListFCFragment()    ;
        fragmentTransaction.add(R.id.main_frame, listFCFragment)    ;
        fragmentTransaction.commit()    ;
    }
}