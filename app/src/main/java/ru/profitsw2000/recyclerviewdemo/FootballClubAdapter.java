package ru.profitsw2000.recyclerviewdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class FootballClubAdapter extends BaseAdapter {

    List<FootballClub> league	;
    Context context	;
    LayoutInflater layoutInflater;

    public FootballClubAdapter(Context context, List<FootballClub> league) {
        this.context = context	;
        this.league = league	;
    }

    @Override
    public int getCount() {
        return league.size();
    }

    @Override
    public Object getItem(int position) {
        return league.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        layoutInflater = layoutInflater.from(this.context)  ;

        final FootballClub footballClub = league.get(position);

        convertView = layoutInflater.inflate(R.layout.item_view, null)  ;
        ((TextView)convertView.findViewById(R.id.club_name)).setText(footballClub.getClubName());
        ((TextView)convertView.findViewById(R.id.city_of_club)).setText(footballClub.getClubCity());
        ((TextView)convertView.findViewById(R.id.country)).setText(footballClub.getCountry());
        ((ImageView)convertView.findViewById(R.id.club_logo)).setImageResource(footballClub.getClubLogo());

        return convertView;
    }
}
