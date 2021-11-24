package ru.profitsw2000.recyclerviewdemo;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ListFCFragment extends Fragment {

    Context context ;
    View view   ;
    private RecyclerView recyclerView;
    FragmentManager fragmentManager ;
    FragmentActionListener fragmentActionListener   ;
    AppData appData ;
    List<FootballClub> league   ;
    FootballClub footballClub   ;
    FCAdapterWithRecyclerView fcAdapterWithRecyclerView ;
    LinearLayoutManager linearLayoutManager ;
    Button addFC   ;
    Button modifyFC ;

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

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        Bundle bundle = getArguments()  ;
        if (bundle != null) {
            footballClub = bundle.getParcelable(FragmentActionListener.KEY_SELECTED_CLUB)   ;
            league.add(footballClub)    ;
            fcAdapterWithRecyclerView.notifyDataSetChanged();
        }
    }

    public void setFragmentActionListener(FragmentActionListener fragmentActionListener) {
        this.fragmentActionListener = fragmentActionListener    ;
    }

    private void initUI()
    {
        context = getContext()  ;
        recyclerView = view.findViewById(R.id.recycler_view_fc_list)    ;
        configureButtons();

        appData = AppData.getAppData(context)   ;
        league = appData.getLeague()   ;
        fcAdapterWithRecyclerView = new FCAdapterWithRecyclerView(context, league)    ;

        linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)   ;

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(fcAdapterWithRecyclerView);
        fcAdapterWithRecyclerView.SetOnItemClickListener(new FCAdapterWithRecyclerView.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                Toast.makeText(context, Integer.toString(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void configureButtons() {
        addFC = view.findViewById(R.id.add_button)  ;
        modifyFC = view.findViewById(R.id.modify_button)    ;

        addFC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle()    ;
                bundle.putInt(FragmentActionListener.ACTION_KEY,FragmentActionListener.ACTION_VALUE_ADD_CLUB);
                fragmentActionListener.onActionPerformed(bundle);
            }
        });

        modifyFC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (league.size() > 0) {
                    league.remove(league.size() - 1)    ;
                    fcAdapterWithRecyclerView.notifyDataSetChanged();
                }
            }
        });

    }
}