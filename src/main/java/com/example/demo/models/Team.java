package com.example.demo.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Teams")
public class Team {
    @Id
    private String id;
    private int teamID;
    private int leagueID;
    private String name;
    private String country;
    private int founded;
    private String logo;
    private String ground;
    private String city;
    private int capacity;
    private String image;


    public Team() {
    }

    public Team(String name, int leagueID, int teamID, String country, int founded, String logo, String ground, String city, int capacity, String image) {
        this.setName(name);
        this.setLeagueID(leagueID);
        this.setTeamID(teamID);
        this.setCountry(country);
        this.setFounded(founded);
        this.setLogo(logo);
        this.setGround(ground);
        this.setCity(city);
        this.setCapacity(capacity);
        this.setImage(image);
    }

    public void setTeamID(int teamID) {
        this.teamID = teamID;
    }

    public void setLeagueID(int leagueID) {
        this.leagueID = leagueID;
    }

    public int getTeamID() {
        return teamID;
    }

    public int getLeagueID() {
        return leagueID;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public int getFounded() {
        return founded;
    }

    public String getLogo() {
        return logo;
    }

    public String getGround() {
        return ground;
    }

    public String getCity() {
        return city;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getImage() {
        return image;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setFounded(int founded) {
        this.founded = founded;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public void setGround(String ground) {
        this.ground = ground;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
