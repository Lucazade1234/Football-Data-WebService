package com.example.demo.Services;

import com.example.demo.Repositories.TeamStatRepository;
import com.example.demo.models.TeamStat;
import com.example.demo.requesting.Requester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class TeamStatService {
    @Autowired
    private TeamStatRepository teamStatRepository;
    private final Requester requester = new Requester();

    public TeamStat getTeamStats(int teamID, int leagueID) throws InterruptedException {
        if(teamStatRepository.findTeamStatByTeam_IdAndLeague_Id(teamID, leagueID) == null){
            System.out.println("No statistics found for this team");
            teamStatRepository.save(requester.requestTeamStats(teamID, leagueID));
        }
        return teamStatRepository.findTeamStatByTeam_IdAndLeague_Id(teamID, leagueID);
    }

    public void deleteAllItems(){
        teamStatRepository.deleteAll();
    }
}
