package com.example.demo.controllers;

import com.example.demo.Services.*;
import com.example.demo.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return teamStatService.getTeamStats(leagueID, teamID);
    }

    @GetMapping("/Squad/{teamID}")
    public Squad getTeamSquad(@PathVariable int teamID) throws InterruptedException {
        return squadService.getSquad(teamID);
    }

    @GetMapping("/PlayerStats/{playerID}")
    public Player getPlayerStats(@PathVariable int playerID) throws InterruptedException {
        return playerService.getPlayer(playerID);
    }

    @GetMapping("/leagues")
    public List<League> getAllLeagues() {
        return leagueService.getAllLeagues();
    }


}