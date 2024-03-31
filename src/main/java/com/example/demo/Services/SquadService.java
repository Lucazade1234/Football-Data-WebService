package com.example.demo.Services;

import com.example.demo.Repositories.SquadRepository;
import com.example.demo.models.Squad;
import com.example.demo.requesting.Requester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SquadService {
    @Autowired
    private SquadRepository squadRepository;
    private final Requester requester = new Requester();


    public Squad getSquad(int teamID) throws InterruptedException {
        Squad squad = squadRepository.findSquadByTeamID(teamID);
        if(squad == null ){
            System.out.println("No Squads found with this provided team ID");
            squadRepository.save(requester.requestPlayersByTeam(teamID));
        } else {
            System.out.println("data found");
        }
        return squadRepository.findSquadByTeamID(teamID);
    }

    public void deleteAllItems(){
        squadRepository.deleteAll();
    }
}
