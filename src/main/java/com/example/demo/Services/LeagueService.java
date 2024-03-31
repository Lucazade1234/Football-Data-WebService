package com.example.demo.Services;

import com.example.demo.Repositories.LeagueRepository;
import com.example.demo.models.Country;
import com.example.demo.models.League;
import com.example.demo.requesting.Requester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeagueService {
    @Autowired
    private LeagueRepository leagueRepository;
    private final Requester requester = new Requester();

    public List<League> getAllLeagues(){
        return leagueRepository.findAll();
    }

    public List<League> getLeagues(String country) throws InterruptedException {
        //check to see if the data exists already, if it doesn't request sent to API
        System.out.println(leagueRepository.findLeagueByCountry(country).isEmpty());
        if(leagueRepository.findLeagueByCountry(country).isEmpty()){
            System.out.println("No leagues found for country: " + country);
            leagueRepository.saveAll(requester.requestLeagues(country));
        }
        return leagueRepository.findLeagueByCountry(country);
    }

    public void deleteAllItems(){
        leagueRepository.deleteAll();
    }
}