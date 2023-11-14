package com.example.demo.Repositories;

import com.example.demo.models.League;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LeagueRepository extends MongoRepository<League, String> {
}
