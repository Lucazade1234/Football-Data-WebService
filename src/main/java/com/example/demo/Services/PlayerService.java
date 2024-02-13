package com.example.demo.Services;

import com.example.demo.Repositories.PlayerRepository;
import com.example.demo.models.Player;
import com.example.demo.requesting.Requester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;
    private final Requester requester = new Requester();

    public Player getPlayer(int playerID) throws InterruptedException {
        Player player = playerRepository.findPlayerByPlayerID(playerID);

        if(player == null){
            System.out.println("No LineupPlayer found with the provided LineupPlayer ID");
            playerRepository.save(requester.requestPlayerStatsByPlayerID(playerID));
        } else {
            System.out.println("Data found");
        }

        return playerRepository.findPlayerByPlayerID(playerID);
    }
}
