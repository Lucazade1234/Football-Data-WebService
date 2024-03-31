package com.example.demo.Services;

import com.example.demo.Repositories.LineupRepository;
import com.example.demo.models.Lineup;
import com.example.demo.requesting.Requester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sound.sampled.Line;
import java.util.ArrayList;

@Service
public class LineupService {

    @Autowired
    private LineupRepository lineupRepository;
    private final Requester requester = new Requester();

    public ArrayList<Lineup> getLineups(int fixtureID){
        ArrayList<Lineup> lineups = lineupRepository.findLineupsByFixtureId(fixtureID);

        if(lineups.isEmpty()){
            System.out.println("No lineups found locally for this fixture... fetching lineups now");
            try{
                lineupRepository.saveAll(requester.requestLineup(fixtureID));
            } catch (InterruptedException e) {
                System.out.println("No lineups found for the fixture with this ID");
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("Data found");
        }

        return lineupRepository.findLineupsByFixtureId(fixtureID);
    }

    public void deleteAllItems(){
        lineupRepository.deleteAll();
    }
}
