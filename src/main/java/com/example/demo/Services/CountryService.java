package com.example.demo.Services;

import com.example.demo.Repositories.CountryRepository;
import com.example.demo.models.Country;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CountryService {
    @Autowired
    private CountryRepository countryRepository;

    public void saveCountry(Country country) {
        countryRepository.save(country);
    }

    public List<Country> getCountries(){
        List<Country> countries = countryRepository.findAll();
        return countries;
    }
}
