package com.example.demo.Repositories;

import com.example.demo.models.League;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.ArrayList;

public interface LeagueRepository extends MongoRepository<League, String> {

    public ArrayList<League> findLeagueByCountry(String country);
}
