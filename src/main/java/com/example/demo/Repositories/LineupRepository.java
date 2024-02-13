package com.example.demo.Repositories;

import com.example.demo.models.Lineup;
import org.springframework.data.mongodb.repository.MongoRepository;

import javax.sound.sampled.Line;
import java.util.ArrayList;

public interface LineupRepository extends MongoRepository<Lineup, Integer> {

    public ArrayList<Lineup> findLineupsByFixtureId(int fixtureID);
}
