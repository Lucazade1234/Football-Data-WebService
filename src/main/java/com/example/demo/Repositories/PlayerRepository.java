package com.example.demo.Repositories;

import com.example.demo.models.Player;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlayerRepository extends MongoRepository<Player, Integer> {

    public Player findPlayerByPlayerID(int id);
}
