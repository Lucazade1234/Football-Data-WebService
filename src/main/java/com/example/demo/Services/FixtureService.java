package com.example.demo.Services;

import com.example.demo.Repositories.FixtureRepository;
import com.example.demo.models.Fixture;
import com.example.demo.requesting.Requester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class FixtureService {

    @Autowired
    private FixtureRepository fixtureRepository;
    private final Requester requester = new Requester();

    public ArrayList<Fixture> getFixtures(int teamID, int leagueID){
        ArrayList<Fixture> fixtures = fixtureRepository.findFixturesByTeamIDsContains(teamID);

        if(fixtures.isEmpty()){
            System.out.println("No fixtures found with that team ID");
            fixtureRepository.saveAll(requester.requestTeamFixtures(teamID, leagueID));
        } else if(fixtures.size() == 2){
            System.out.println("Only some fixtures are saved locally.... fetching all of them");
            fixtureRepository.saveAll(requester.requestTeamFixtures(teamID, leagueID));
        } else {
            System.out.println("Data found");
        }


        return fixtureRepository.findFixturesByTeamIDsContains(teamID);
    }

    public void deleteAllItems(){
        fixtureRepository.deleteAll();
    }
}
