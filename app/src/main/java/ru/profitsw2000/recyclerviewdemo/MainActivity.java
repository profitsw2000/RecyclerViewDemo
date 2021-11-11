package ru.profitsw2000.recyclerviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    AppData appData ;

    FootballClubAdapter footballClubAdapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.list_of_football_clubs) ;

        appData = AppData.getAppData(getApplicationContext())   ;
        footballClubAdapter = new FootballClubAdapter(this, appData.getLeague())    ;
        listView.setAdapter(footballClubAdapter);
    }
}