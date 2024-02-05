package com.example.demo.Repositories;

import com.example.demo.models.Squad;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SquadRepository extends MongoRepository<Squad, Integer> {

    public Squad findSquadByTeamID(int id);
}
