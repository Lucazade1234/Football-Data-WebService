package com.example.demo.Repositories;

import com.example.demo.models.League;
import com.example.demo.models.TeamStat;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TeamStatRepository extends MongoRepository<TeamStat, String> {
    public TeamStat findTeamStatByTeam_IdAndLeague_Id(int teamInfo, int leagueInfo);

    public boolean findTeamStatsByTeamName(String name);

    public TeamStat findTeamStatsBy(TeamStat teamStat);

}
