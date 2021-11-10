package ru.profitsw2000.recyclerviewdemo;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class AppData {

    private String[] clubNames ;
    private String[] clubCitys ;
    private String[] countrys  ;
    private int[] logoIDs  ;

    private Context context ;

    private List<FootballClub> league    ;

    private static AppData appData  ;

    private AppData(Context context) {
        this.context = context  ;
        clubNames = context.getResources().getStringArray(R.array.names_of_clubs)   ;
        clubCitys = context.getResources().getStringArray(R.array.cities_of_clubs)  ;
        countrys = context.getResources().getStringArray(R.array.countries_of_clubs)    ;
        logoIDs = context.getResources().getIntArray(R.array.fc_logos)  ;

        league = new ArrayList<FootballClub>()  ;
        for (int i = 0; i < clubNames.length; i++) {
            FootballClub footballClub = new FootballClub(clubNames[i], clubCitys[i], countrys[i], logoIDs[i]);
            league.add(footballClub)    ;
        }
    }

    public static AppData getAppData(Context context) {
        if (appData == null) {
            appData = new AppData(context)  ;
        }
        return appData;
    }

    public String[] getClubNames() {
        return clubNames;
    }

    public String[] getClubCitys() {
        return clubCitys;
    }

    public String[] getCountrys() {
        return countrys;
    }

    public int[] getLogoIDs() {
        return logoIDs;
    }

    public List<FootballClub> getLeague() {
        return league;
    }
}
