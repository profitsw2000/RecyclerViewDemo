package ru.profitsw2000.recyclerviewdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.net.ContentHandler;
import java.util.List;

public class FCAdapterWithRecyclerView extends RecyclerView.Adapter<FCAdapterWithRecyclerView.ClubViewHolder> {

    private Context context ;
    private List<FootballClub> clubList ;

    public FCAdapterWithRecyclerView(Context context, List<FootballClub> clubList) {
        this.context = context;
        this.clubList = clubList;
    }

    @NonNull
    @Override
    public ClubViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_view_2, parent, false) ;
        return new ClubViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClubViewHolder holder, int position) {
        final FootballClub footballClub = clubList.get(position)    ;

        holder.twClubName.setText(footballClub.getClubName());
        holder.twCity.setText(footballClub.getClubCity());
        holder.twCountry.setText(footballClub.getCountry());
        holder.clubLogoImage.setImageResource(footballClub.getClubLogo());
    }

    @Override
    public int getItemCount() {
        return clubList.size();
    }

    class ClubViewHolder extends RecyclerView.ViewHolder {
        public TextView twClubName    ;
        public TextView twCity    ;
        public TextView twCountry    ;
        public ImageView clubLogoImage    ;

        public ClubViewHolder(View view) {
            super(view);
            twClubName = (TextView) view.findViewById(R.id.club_name)   ;
            twCity = (TextView) view.findViewById(R.id.city_of_club)   ;
            twCountry = (TextView) view.findViewById(R.id.country)   ;
            clubLogoImage = (ImageView) view.findViewById(R.id.club_logo)   ;
        }
    }
}
