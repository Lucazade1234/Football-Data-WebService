package com.example.demo.Repositories;

import com.example.demo.models.League;
import com.example.demo.models.Team;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.ArrayList;
public interface TeamRepository extends MongoRepository<Team, String> {
    public ArrayList<Team> findTeamsByCountryAndLeagueID(String country, int leagueID);

}
