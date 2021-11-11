package ru.profitsw2000.recyclerviewdemo;

import android.content.Context;
import android.content.res.TypedArray;

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
        logoIDs = getImageArray(context)  ;

        league = new ArrayList<FootballClub>()  ;
        for (int i = 0; i < clubNames.length; i++) {
            FootballClub footballClub = new FootballClub(clubNames[i], clubCitys[i], countrys[i], logoIDs[i]);
            league.add(footballClub)    ;
        }
    }

    private int[] getImageArray(Context context){
        TypedArray pictures = context.getResources().obtainTypedArray(R.array.fc_logos);
        int length = pictures.length();
        int[] answer = new int[length];
        for(int i = 0; i < length; i++){
            answer[i] = pictures.getResourceId(i, 0);
        }
        return answer;
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
