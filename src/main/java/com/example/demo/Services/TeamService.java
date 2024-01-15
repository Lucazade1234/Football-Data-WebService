package com.example.demo.Services;

import com.example.demo.Repositories.TeamRepository;
import com.example.demo.models.Team;
import com.example.demo.requesting.Requester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;
    private final Requester requester = new Requester();

    public List<Team> getAllTeams(){
        return teamRepository.findAll();
    }

    public List<Team> getTeams(String country, int leagueID) throws InterruptedException{
        if(teamRepository.findTeamsByCountryAndLeagueID(country, leagueID).isEmpty()){
            System.out.println("No teams found for this league");
            teamRepository.saveAll(requester.requestTeams(country, leagueID));
        }
        return teamRepository.findTeamsByCountryAndLeagueID(country,leagueID);
    }

}
