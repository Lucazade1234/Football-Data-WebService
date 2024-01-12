package com.example.demo.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Leagues")
public class League {

    private String id;
    private int leagueID;
    private String name;
    private String type;
    private String logo;
    private String country;


    public League(String id, int leagueID, String name, String type, String logo, String country) {
        this.id = id;
        this.leagueID = leagueID;
        this.name = name;
        this.type = type;
        this.logo = logo;
        this.country = country;
    }

    public League(String name, int leagueID, String type, String logo, String country) {
        this.name = name;
        this.leagueID = leagueID;
        this.type = type;
        this.logo = logo;
        this.country = country;
    }

    public League() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getLeagueID() {
        return leagueID;
    }

    public void setLeagueID(int leagueID) {
        this.leagueID = leagueID;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
