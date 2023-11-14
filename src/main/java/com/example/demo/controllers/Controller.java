package com.example.demo.controllers;

import com.example.demo.Services.CountryService;
import com.example.demo.models.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class Controller {

    @Autowired
    private CountryService countryService;

    @GetMapping("/countries")
    public List<Country> getCountries() {
        return countryService.getCountries();
    }
}
