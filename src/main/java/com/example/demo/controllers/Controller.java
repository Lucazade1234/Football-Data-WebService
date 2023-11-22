package com.example.demo.controllers;

import com.example.demo.Services.CountryService;
import com.example.demo.Services.LeagueService;
import com.example.demo.models.Country;
import com.example.demo.models.League;
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

    @GetMapping("/countries")
    public List<Country> getCountries() {
        return countryService.getCountries();
    }

    @GetMapping("/{country}/leagues")
    public List<League> getLeaguesByCountry(@PathVariable String country) throws InterruptedException {

        return leagueService.getLeagues(country);
    }

    @GetMapping("/leagues")
    public List<League> getAllLeagues(){
        return leagueService.getAllLeagues();
    }
}