package com.example.demo.Repositories;

import com.example.demo.models.Fixture;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.ArrayList;

public interface FixtureRepository extends MongoRepository<Fixture, Integer> {

    public ArrayList<Fixture> findFixturesByTeamIDsContains(int teamID);

}
