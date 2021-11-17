package ru.profitsw2000.recyclerviewdemo;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ListFCFragment extends Fragment {

    Context context ;
    View view   ;
    private RecyclerView recyclerView;
    AppData appData ;
    FCAdapterWithRecyclerView fcAdapterWithRecyclerView ;
    LinearLayoutManager linearLayoutManager ;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_list_f_c, container, false);
        initUI();
        return view ;
    }

    private void initUI()
    {
        context = getContext()  ;
        recyclerView = view.findViewById(R.id.recycler_view_fc_list)    ;
        appData = AppData.getAppData(context)   ;
        fcAdapterWithRecyclerView = new FCAdapterWithRecyclerView(context, appData.getLeague())    ;

        linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)   ;

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(fcAdapterWithRecyclerView);
    }
}