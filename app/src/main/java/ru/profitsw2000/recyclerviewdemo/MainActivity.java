package ru.profitsw2000.recyclerviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    AppData appData ;

    FCAdapterWithRecyclerView fcAdapterWithRecyclerView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_fc_list) ;
        appData = AppData.getAppData(getApplicationContext())   ;
        fcAdapterWithRecyclerView = new FCAdapterWithRecyclerView(this, appData.getLeague())    ;
        LinearLayoutManager layoutManager = new LinearLayoutManager(this)   ;
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(fcAdapterWithRecyclerView);
    }
}