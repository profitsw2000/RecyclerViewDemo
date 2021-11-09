package ru.profitsw2000.recyclerviewdemo;

public class FootballClub {

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
}
