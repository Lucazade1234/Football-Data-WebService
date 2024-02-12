package com.example.demo.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Map;

@Getter
@Setter
@Data
@Document(collection = "Fixtures")
public class Fixture {

    @Id
    private String id;
    private long fixtureID;
    private String referee;
    private String timezone;
    private String date;
    private long timestamp;
    private Venue venue;
    private Status status;
    private Leagueinfo leagueinfo;
    private Teams teams;
    private Goals goals;
    private Score score;
    private ArrayList<Integer> teamIDs = new ArrayList<>();


    public Fixture(long fixtureID, String referee, String timezone, String date, long timestamp, Venue venue, Status status, Leagueinfo leagueinfo, Teams teams, Goals goals, Score score) {
        this.fixtureID = fixtureID;
        this.referee = referee;
        this.timezone = timezone;
        this.date = date;
        this.timestamp = timestamp;
        this.venue = venue;
        this.status = status;
        this.leagueinfo = leagueinfo;
        this.teams = teams;
        this.goals = goals;
        this.score = score;

        this.teamIDs.add(teams.getHome().getId());
        this.teamIDs.add(teams.getAway().getId());
    }

    @Override
    public String toString() {
        return "Fixture{" +
                " fixtureID=" + fixtureID +
                ", referee='" + referee + '\'' +
                ", timezone='" + timezone + '\'' +
                ", date='" + date + '\'' +
                ", timestamp=" + timestamp +
                ", venue=" + venue +
                ", status=" + status +
                ", leagueinfo=" + leagueinfo +
                ", teams=" + teams +
                ", goals=" + goals +
                ", score=" + score +
                '}';
    }
}


