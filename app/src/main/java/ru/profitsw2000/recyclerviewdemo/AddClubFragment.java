package ru.profitsw2000.recyclerviewdemo;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.ConditionVariable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddClubFragment extends Fragment {

    View rootView   ;
    Context context ;
    FootballClub footballClub   ;
    FragmentActionListener fragmentActionListener   ;
    Button addButton    ;
    EditText clubName   ;
    EditText cityName   ;
    EditText country   ;
    int clubLogoID  ;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_add_club, container, false);
        initUI();
        return rootView ;
    }

    public void setFragmentActionListener(FragmentActionListener fragmentActionListener) {
        this.fragmentActionListener = fragmentActionListener  ;
    }

    private void initUI() {
        context = getContext()  ;
        addButton = (Button) rootView.findViewById(R.id.add_club_button) ;
        clubName = (EditText) rootView.findViewById(R.id.edit_club)  ;
        cityName = (EditText) rootView.findViewById(R.id.edit_city)  ;
        country = (EditText) rootView.findViewById(R.id.edit_country)  ;

/*        TypedArray pictures = context.getResources().obtainTypedArray(R.array.fc_logos);
        clubLogoID = pictures.getResourceId(0, 0);*/
        clubLogoID = R.drawable.bayern  ;

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show();
                if (fragmentActionListener != null) {
                    Bundle bundle = new Bundle()    ;
                    footballClub = new FootballClub(clubName.getText().toString(), cityName.getText().toString(), country.getText().toString(), clubLogoID) ;
                    bundle.putInt(FragmentActionListener.ACTION_KEY,FragmentActionListener.ACTION_VALUE_CLUB_ADDED);
                    bundle.putParcelable(FragmentActionListener.KEY_SELECTED_CLUB, footballClub);
                    fragmentActionListener.onActionPerformed(bundle);
                }
            }
        });
    }


}