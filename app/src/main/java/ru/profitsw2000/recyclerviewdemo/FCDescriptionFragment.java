package ru.profitsw2000.recyclerviewdemo;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class FCDescriptionFragment extends Fragment {

    View rootView   ;
    FootballClub footballClub   ;
    FragmentActionListener fragmentActionListener   ;
    TextView clubName   ;
    TextView cityName   ;
    TextView country    ;
    ImageView clubLogo  ;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_f_c_description, container, false);
        initUI()    ;
        // Inflate the layout for this fragment
        return rootView ;
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        Bundle bundle = getArguments()  ;
        if (bundle != null) {
            footballClub = bundle.getParcelable(FragmentActionListener.KEY_SELECTED_CLUB)   ;

            clubName.setText(footballClub.getClubName());
            cityName.setText(footballClub.getClubCity());
            country.setText(footballClub.getCountry());
            clubLogo.setImageResource(footballClub.getClubLogo());
        }
    }

    public void setFragmentActionListener(FragmentActionListener fragmentActionListener) {
        this.fragmentActionListener = fragmentActionListener  ;
    }

    private void initUI() {
        clubName = (TextView) rootView.findViewById(R.id.description_club) ;
        cityName = (TextView) rootView.findViewById(R.id.description_city)  ;
        country = (TextView) rootView.findViewById(R.id.description_country)    ;
        clubLogo = (ImageView) rootView.findViewById(R.id.description_logo) ;
    }
}