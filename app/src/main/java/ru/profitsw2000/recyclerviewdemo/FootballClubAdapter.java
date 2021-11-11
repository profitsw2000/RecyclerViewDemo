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

            ClubViewHolder clubViewHolder   ;

        if (convertView == null){
            layoutInflater = layoutInflater.from(this.context)  ;
            convertView = layoutInflater.inflate(R.layout.item_view, null)  ;

            clubViewHolder = new ClubViewHolder()   ;
            clubViewHolder.textViewClubName = (TextView)convertView.findViewById(R.id.club_name)  ;
            clubViewHolder.textViewCity = (TextView)convertView.findViewById(R.id.city_of_club) ;
            clubViewHolder.textViewCountry = (TextView)convertView.findViewById(R.id.country)   ;
            clubViewHolder.imageViewClubLogo = (ImageView)convertView.findViewById(R.id.club_logo)  ;

            convertView.setTag(clubViewHolder);
        } else {
            clubViewHolder = (ClubViewHolder) convertView.getTag()  ;
        }

        final FootballClub footballClub = league.get(position);

        ((TextView)convertView.findViewById(R.id.club_name)).setText(footballClub.getClubName());
        ((TextView)convertView.findViewById(R.id.city_of_club)).setText(footballClub.getClubCity());
        ((TextView)convertView.findViewById(R.id.country)).setText(footballClub.getCountry());
        ((ImageView)convertView.findViewById(R.id.club_logo)).setImageResource(footballClub.getClubLogo());

        return convertView;
    }

    private static class ClubViewHolder {
        public TextView textViewClubName    ;
        public TextView textViewCity    ;
        public TextView textViewCountry    ;
        public ImageView imageViewClubLogo    ;
    }
}
