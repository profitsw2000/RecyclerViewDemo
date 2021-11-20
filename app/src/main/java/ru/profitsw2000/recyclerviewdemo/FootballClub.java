package ru.profitsw2000.recyclerviewdemo;

import android.os.Parcel;
import android.os.Parcelable;

public class FootballClub implements Parcelable {

    private String clubName ;
    private String clubCity ;
    private String country  ;
    private int clubLogo    ;

    public FootballClub() {
        super();
    }

    public FootballClub (String clubName, String clubCity, String country, int clubLogo) {
        this.clubName = clubName    ;
        this.clubCity = clubCity    ;
        this.country = country  ;
        this.clubLogo = clubLogo    ;
    }

    protected FootballClub(Parcel in) {
        clubName = in.readString();
        clubCity = in.readString();
        country = in.readString();
        clubLogo = in.readInt();
    }

    public static final Creator<FootballClub> CREATOR = new Creator<FootballClub>() {
        @Override
        public FootballClub createFromParcel(Parcel in) {
            return new FootballClub(in);
        }

        @Override
        public FootballClub[] newArray(int size) {
            return new FootballClub[size];
        }
    };

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getClubCity() {
        return clubCity;
    }

    public void setClubCity(String clubCity) {
        this.clubCity = clubCity;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getClubLogo() {
        return clubLogo;
    }

    public void setClubLogo(int clubLogo) {
        this.clubLogo = clubLogo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(clubName);
        dest.writeString(clubCity);
        dest.writeString(country);
        dest.writeInt(clubLogo);
    }
}
