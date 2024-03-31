package com.example.demo.controllers;

import com.example.demo.Repositories.PlayerRepository;
import com.example.demo.Services.*;
import com.example.demo.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class Controller {

    @Autowired
    private CountryService countryService;

    @Autowired
    private LeagueService leagueService;

    @Autowired
    private TeamService teamService;

    @Autowired
    private TeamStatService teamStatService;

    @Autowired
    private SquadService squadService;

    @Autowired
    private PlayerService playerService;

    @Autowired
    private FixtureService fixtureService;

    @Autowired
    private LineupService lineupService;


    @GetMapping("/countries")
    public List<Country> getCountries() {
        return countryService.getCountries();
    }

    @GetMapping("/{country}/leagues")
    public List<League> getLeaguesByCountry(@PathVariable String country) throws InterruptedException {
        return leagueService.getLeagues(country);
    }

    @GetMapping("/{country}/{leagueID}/teams")
    public List<Team> getTeamsByLeagueId(@PathVariable String country, @PathVariable int leagueID) throws InterruptedException {
        return teamService.getTeams(country, leagueID);
    }

    @GetMapping("/{leagueID}/{teamID}/TeamStats")
    public TeamStat getTeamStats(@PathVariable int leagueID, @PathVariable int teamID) throws InterruptedException {
        return teamStatService.getTeamStats(teamID, leagueID);
    }

    @GetMapping("/Squad/{teamID}")
    public Squad getTeamSquad(@PathVariable int teamID) throws InterruptedException {
        return squadService.getSquad(teamID);
    }

    @GetMapping("/Fixtures/{teamID}/{leagueID}")
    public ArrayList<Fixture> getTeamFixtures(@PathVariable int teamID, @PathVariable int leagueID){
        return fixtureService.getFixtures(teamID, leagueID);
    }

    @GetMapping("/Lineups/{fixtureID}")
    public ArrayList<Lineup> getlineups(@PathVariable int fixtureID){
        return lineupService.getLineups(fixtureID);
    }

    @GetMapping("/PlayerStats/{playerID}")
    public Player getPlayerStats(@PathVariable int playerID) throws InterruptedException {
        return playerService.getPlayer(playerID);
    }

    @PutMapping("/Cache/flush")
    public void clearCache(){
        fixtureService.deleteAllItems();
        lineupService.deleteAllItems();
        playerService.deleteAllItems();
        squadService.deleteAllItems();
        teamService.deleteAllItems();
        teamStatService.deleteAllItems();
        leagueService.deleteAllItems();
    }



    @GetMapping("/leagues")
    public List<League> getAllLeagues() {
        return leagueService.getAllLeagues();
    }



}