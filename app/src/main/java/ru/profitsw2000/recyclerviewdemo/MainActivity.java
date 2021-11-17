package ru.profitsw2000.recyclerviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    AppData appData ;
    FCAdapterWithRecyclerView fcAdapterWithRecyclerView ;
    LinearLayoutManager linearLayoutManager ;
    GridLayoutManager gridLayoutManager ;
    StaggeredGridLayoutManager staggeredGridLayoutManager   ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_fc_list) ;
        appData = AppData.getAppData(getApplicationContext())   ;
        fcAdapterWithRecyclerView = new FCAdapterWithRecyclerView(this, appData.getLeague())    ;

        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)   ;
        gridLayoutManager = new GridLayoutManager(this, 2)  ;
        staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)  ;

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(fcAdapterWithRecyclerView);
    }
}