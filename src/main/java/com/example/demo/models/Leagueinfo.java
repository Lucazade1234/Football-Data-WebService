package com.example.demo.models;

public class Leagueinfo {
    private int id;
    private String name;
    private String country;
    private String logo;
    private String flag;
    private int season;
    private String round;


    public Leagueinfo(int id, String name, String country, String logo, String flag, int season, String round) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.logo = logo;
        this.flag = flag;
        this.season = season;
        this.round = round;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public String getRound() {
        return round;
    }

    public void setRound(String round) {
        this.round = round;
    }
}
