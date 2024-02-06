package com.example.demo.requesting;

import com.example.demo.models.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.bson.json.JsonObject;

import java.io.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class Requester {
    public static void main(String[] args) throws IOException, InterruptedException {
        Requester requester = new Requester();
        //System.out.println(requester.requestLeagues("England"));
        //System.out.println("request teams: " + requester.requestTeams("England", 39));
        //System.out.println("request teamstats: "  + requester.requestTeamStats(33, 39));
        System.out.println(requester.requestPlayerStatsByPlayerID(633));


    }


    private static void processJsonResponse(String jsonResponse) {
        try {
            // Parse the JSON response
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonObject = objectMapper.readTree(jsonResponse);
            JsonNode jsonArray = jsonObject.get("response");

            // Check if the parsed JSON is an array
            if (jsonObject.isObject()) {
                ArrayList<League> leagues = new ArrayList<>();
                // Iterate through the array elements
                for (JsonNode element : jsonArray) {
                    if (element.get("league").get("type").asText().equals("League")) {
                        System.out.println(element.get("league").get("name"));

                    }

                }
            } else {
                System.out.println("The JSON response is not an array.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public ArrayList<League> requestLeagues(String country) throws InterruptedException {
        ArrayList<League> leagues = new ArrayList<>();
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api-football-v1.p.rapidapi.com/v3/leagues?country=" + country))
                    .header("X-RapidAPI-Key", "beb2d7eac8msh58aa520e5aa67c7p187818jsndadd4a0969ce")
                    .header("X-RapidAPI-Host", "api-football-v1.p.rapidapi.com")
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());


            try {
                // Parse the JSON response
                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode jsonObject = objectMapper.readTree(response.body());
                JsonNode jsonArray = jsonObject.get("response");

                // Check if the parsed JSON is an array
                if (jsonObject.isObject()) {
                    // Iterate through the array elements
                    for (JsonNode element : jsonArray) {
                        if (element.get("league").get("type").asText().equals("League")) {
                            //add league data to array list
                            League league = new League(element.get("league").get("name").asText(),
                                    element.get("league").get("id").asInt(),
                                    element.get("league").get("type").asText(),
                                    element.get("league").get("logo").asText(),
                                    element.get("country").get("name").asText());

                            leagues.add(league);
                        }

                    }
                } else {
                    System.out.println("The JSON response is not an array.");
                    return leagues;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // return array list of leagues
        //System.out.println(leagues);
        return leagues;

    }


    public ArrayList<Team> requestTeams(String country, int leagueID) throws InterruptedException {
        ArrayList<Team> teams = new ArrayList<>();
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api-football-v1.p.rapidapi.com/v3/teams?league=" + leagueID +
                            "&season=2023&country=" + country))
                    .header("X-RapidAPI-Key", "beb2d7eac8msh58aa520e5aa67c7p187818jsndadd4a0969ce")
                    .header("X-RapidAPI-Host", "api-football-v1.p.rapidapi.com")
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());


            try {
                // Parse the JSON response
                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode jsonObject = objectMapper.readTree(response.body());
                JsonNode jsonArray = jsonObject.get("response");

                // Check if the parsed JSON is an array
                if (jsonObject.isObject()) {
                    // Iterate through the array elements
                    for (JsonNode element : jsonArray) {
                        //add team data to array list
                        Team team = new Team(element.get("team").get("name").asText(),
                                leagueID,
                                element.get("team").get("id").asInt(),
                                element.get("team").get("country").asText(),
                                element.get("team").get("founded").asInt(),
                                element.get("team").get("logo").asText(),
                                element.get("venue").get("name").asText(),
                                element.get("venue").get("city").asText(),
                                element.get("venue").get("capacity").asInt(),
                                element.get("venue").get("image").asText());

                        teams.add(team);
                    }
                } else {
                    System.out.println("The JSON response is not an array.");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return teams;

    }

    //method for processing all statistics related to team performance
    public TeamStat requestTeamStats(int teamID, int leagueID) throws InterruptedException {
        TeamStat teamStat = new TeamStat();
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api-football-v1.p.rapidapi.com/v3/teams/statistics?league=" + leagueID +
                            "&season=2023&team=" + teamID))
                    .header("X-RapidAPI-Key", "beb2d7eac8msh58aa520e5aa67c7p187818jsndadd4a0969ce")
                    .header("X-RapidAPI-Host", "api-football-v1.p.rapidapi.com")
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());

            try {
                // Parse the JSON response
                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode jsonObject = objectMapper.readTree(response.body());
                System.out.println(jsonObject);

                // Check if the parsed JSON is an array
                if (jsonObject.isObject()) {


                    //processing information about this team's league
                    teamStat.setLeague(new TeamStat.LeagueInfo(
                            jsonObject.get("response").get("league").get("id").asInt(),
                            jsonObject.get("response").get("league").get("name").asText(),
                            jsonObject.get("response").get("league").get("country").asText(),
                            jsonObject.get("response").get("league").get("logo").asText(),
                            jsonObject.get("response").get("league").get("flag").asText()
                    ));

                    //processing general info about team, like ID, name and logo
                    teamStat.setTeam(new TeamStat.TeamInfo(
                            jsonObject.get("response").get("team").get("id").asInt(),
                            jsonObject.get("response").get("team").get("name").asText(),
                            jsonObject.get("response").get("team").get("logo").asText()
                    ));

                    //processing String representing form of team
                    teamStat.setForm(jsonObject.get("response").get("form").asText());


                    //processing the fixtures played at home and away
                    teamStat.setFixtures(new TeamStat.FixtureInfo(
                            jsonObject.get("response").get("fixtures").get("played").get("home").asInt(),
                            jsonObject.get("response").get("fixtures").get("played").get("away").asInt()
                    ));

                    //processing goals scored both home and away
                    teamStat.setGoals(new TeamStat.GoalInfo(
                            jsonObject.get("response").get("goals").get("for").get("total").get("home").asInt(),
                            jsonObject.get("response").get("goals").get("for").get("total").get("away").asInt()
                    ));

                    //processing the team's record on most goals, win streak, lose streak and draw steak
                    teamStat.setBiggest(new TeamStat.BiggestInfo(
                            new TeamStat.BiggestStreakInfo(
                                    jsonObject.get("response").get("biggest").get("streak").get("wins").asInt(),
                                    jsonObject.get("response").get("biggest").get("streak").get("draws").asInt(),
                                    jsonObject.get("response").get("biggest").get("streak").get("loses").asInt()
                            ),
                            jsonObject.get("response").get("biggest").get("wins").get("home").asText(),
                            jsonObject.get("response").get("biggest").get("wins").get("away").asText(),
                            new TeamStat.GoalInfo(
                                    jsonObject.get("response").get("biggest").get("goals").get("for").get("home").asInt(),
                                    jsonObject.get("response").get("biggest").get("goals").get("for").get("away").asInt()
                            )
                    ));

                    //processing clean sheet data
                    teamStat.setCleanSheet(new TeamStat.CleanSheetInfo(
                            jsonObject.get("response").get("clean_sheet").get("home").asInt(),
                            jsonObject.get("response").get("clean_sheet").get("away").asInt()
                    ));

                    //processing how many times the team failed to score
                    teamStat.setFailedToScore(new TeamStat.FailedToScoreInfo(
                            jsonObject.get("response").get("failed_to_score").get("home").asInt(),
                            jsonObject.get("response").get("failed_to_score").get("away").asInt()
                    ));

                    //processing penalty information
                    teamStat.setPenalty(new TeamStat.PenaltyInfo(
                            jsonObject.get("response").get("penalty").get("scored").get("total").asInt(),
                            jsonObject.get("response").get("penalty").get("missed").get("total").asInt(),
                            jsonObject.get("response").get("penalty").get("scored").get("percentage").asText(),
                            jsonObject.get("response").get("penalty").get("missed").get("total").asText()
                    ));

                    //processing lineup information:
                    List<TeamStat.LineupInfo> lineupInfos = new ArrayList<>();
                    JsonNode formations = jsonObject.get("response").get("lineups");

                    for (JsonNode formation : formations) {

                        String formationString = formation.get("formation").asText();
                        int timesPlayed = formation.get("played").asInt();
                        TeamStat.LineupInfo lineupInfo = new TeamStat.LineupInfo(formationString, timesPlayed);

                        lineupInfos.add(lineupInfo);
                    }
                    teamStat.setLineups(lineupInfos);

                    // now processing card information; amount of yellow and red cards during each part of the game:
                    // Yellow card data:
                    List<TeamStat.MinuteInfo> yellow = new ArrayList<>();

                    //processing number yellow of cards between minutes 0-15
                    yellow.add(new TeamStat.MinuteInfo(
                            jsonObject.get("response").get("cards").get("yellow").get("0-15").get("total").asInt(),
                            jsonObject.get("response").get("cards").get("yellow").get("0-15").get("percentage").asText(),
                            "0-15"
                    ));

                    //processing number yellow of cards between minutes 16-30
                    yellow.add(new TeamStat.MinuteInfo(
                            jsonObject.get("response").get("cards").get("yellow").get("16-30").get("total").asInt(),
                            jsonObject.get("response").get("cards").get("yellow").get("16-30").get("percentage").asText(),
                            "16-30"
                    ));

                    //processing number yellow of cards between minutes 31-45
                    yellow.add(new TeamStat.MinuteInfo(
                            jsonObject.get("response").get("cards").get("yellow").get("31-45").get("total").asInt(),
                            jsonObject.get("response").get("cards").get("yellow").get("31-45").get("percentage").asText(),
                            "31-45"
                    ));

                    //processing number yellow of cards between minutes 46-60
                    yellow.add(new TeamStat.MinuteInfo(
                            jsonObject.get("response").get("cards").get("yellow").get("46-60").get("total").asInt(),
                            jsonObject.get("response").get("cards").get("yellow").get("46-60").get("percentage").asText(),
                            "46-60"
                    ));

                    //processing number yellow of cards between minutes 61-75
                    yellow.add(new TeamStat.MinuteInfo(
                            jsonObject.get("response").get("cards").get("yellow").get("61-75").get("total").asInt(),
                            jsonObject.get("response").get("cards").get("yellow").get("61-75").get("percentage").asText(),
                            "61-75"
                    ));

                    //processing number yellow of cards between minutes 76-90
                    yellow.add(new TeamStat.MinuteInfo(
                            jsonObject.get("response").get("cards").get("yellow").get("76-90").get("total").asInt(),
                            jsonObject.get("response").get("cards").get("yellow").get("76-90").get("percentage").asText(),
                            "76-90"
                    ));

                    //processing number yellow of cards between minutes 91-105
                    yellow.add(new TeamStat.MinuteInfo(
                            jsonObject.get("response").get("cards").get("yellow").get("91-105").get("total").asInt(),
                            jsonObject.get("response").get("cards").get("yellow").get("91-105").get("percentage").asText(),
                            "91-105"
                    ));

                    //processing number yellow of cards between minutes 106-120
                    yellow.add(new TeamStat.MinuteInfo(
                            jsonObject.get("response").get("cards").get("yellow").get("106-120").get("total").asInt(),
                            jsonObject.get("response").get("cards").get("yellow").get("106-120").get("percentage").asText(),
                            "106-120"
                    ));

                    //red card data:
                    List<TeamStat.MinuteInfo> red = new ArrayList<>();

                    //processing number red of cards between minutes 0-15
                    red.add(new TeamStat.MinuteInfo(
                            jsonObject.get("response").get("cards").get("red").get("0-15").get("total").asInt(),
                            jsonObject.get("response").get("cards").get("red").get("0-15").get("percentage").asText(),
                            "0-15"
                    ));

                    //processing number red of cards between minutes 16-30
                    red.add(new TeamStat.MinuteInfo(
                            jsonObject.get("response").get("cards").get("red").get("16-30").get("total").asInt(),
                            jsonObject.get("response").get("cards").get("red").get("16-30").get("percentage").asText(),
                            "16-30"
                    ));

                    //processing number red of cards between minutes 31-45
                    red.add(new TeamStat.MinuteInfo(
                            jsonObject.get("response").get("cards").get("red").get("31-45").get("total").asInt(),
                            jsonObject.get("response").get("cards").get("red").get("31-45").get("percentage").asText(),
                            "31-45"
                    ));

                    //processing number red of cards between minutes 46-60
                    red.add(new TeamStat.MinuteInfo(
                            jsonObject.get("response").get("cards").get("red").get("46-60").get("total").asInt(),
                            jsonObject.get("response").get("cards").get("red").get("46-60").get("percentage").asText(),
                            "46-60"
                    ));

                    //processing number red of cards between minutes 61-75
                    red.add(new TeamStat.MinuteInfo(
                            jsonObject.get("response").get("cards").get("red").get("61-75").get("total").asInt(),
                            jsonObject.get("response").get("cards").get("red").get("61-75").get("percentage").asText(),
                            "61-75"
                    ));

                    //processing number red of cards between minutes 76-90
                    red.add(new TeamStat.MinuteInfo(
                            jsonObject.get("response").get("cards").get("red").get("76-90").get("total").asInt(),
                            jsonObject.get("response").get("cards").get("red").get("76-90").get("percentage").asText(),
                            "76-90"
                    ));

                    //processing number red of cards between minutes 91-105
                    red.add(new TeamStat.MinuteInfo(
                            jsonObject.get("response").get("cards").get("red").get("91-105").get("total").asInt(),
                            jsonObject.get("response").get("cards").get("red").get("91-105").get("percentage").asText(),
                            "91-105"
                    ));

                    //processing number red of cards between minutes 106-120
                    red.add(new TeamStat.MinuteInfo(
                            jsonObject.get("response").get("cards").get("red").get("106-120").get("total").asInt(),
                            jsonObject.get("response").get("cards").get("red").get("106-120").get("percentage").asText(),
                            "106-120"
                    ));

                    // add both yellow and red card data to CardInfo object, and teamStat
                    teamStat.setCards(new TeamStat.CardInfo(
                            yellow, red
                    ));


                } else {
                    System.out.println("The JSON response is not an array.");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return teamStat;

    }



    public Squad requestPlayersByTeam(int teamID) throws InterruptedException {
        ArrayList<SquadMember> players = new ArrayList<>();
        String teamName = null;
        Requester requester = new Requester();
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api-football-v1.p.rapidapi.com/v3/players/squads?team=" + teamID))
                    .header("X-RapidAPI-Key", "beb2d7eac8msh58aa520e5aa67c7p187818jsndadd4a0969ce")
                    .header("X-RapidAPI-Host", "api-football-v1.p.rapidapi.com")
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());



            try {
                // Parse the JSON response
                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode jsonObject = objectMapper.readTree(response.body());
                JsonNode jsonArray = jsonObject.get("response");
                System.out.println(jsonObject.get("response"));


                for(JsonNode node : jsonArray){
                    JsonNode playerList = node.get("players");
                    teamName = node.get("team").get("name").asText();

                    for(JsonNode player : playerList){
                        int id = player.get("id").asInt();
                        String name = player.get("name").asText();
                        int age = player.get("age").asInt();
                        int number = player.get("number").asInt();
                        String position = player.get("position").asText();
                        String photo = player.get("photo").asText();

                        SquadMember p = new SquadMember(id, name, age, number, position, photo);
                        players.add(p);
                    }
                }


            } catch (Exception e) {
                e.printStackTrace();
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }



        return new Squad (teamID, players, teamName);

    }

    public Player requestPlayerStatsByPlayerID(int playerID) {
        Player player = new Player();

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api-football-v1.p.rapidapi.com/v3/players?id=" + playerID + "&season=2023"))
                    .header("X-RapidAPI-Key", "beb2d7eac8msh58aa520e5aa67c7p187818jsndadd4a0969ce")
                    .header("X-RapidAPI-Host", "api-football-v1.p.rapidapi.com")
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            //System.out.println(response.body());



            try {

                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode jsonObject = objectMapper.readTree(response.body());
                JsonNode jsonArray = jsonObject.get("response");

                for(JsonNode element : jsonArray){

                    player.setPlayerID(element.get("player").get("id").asInt());
                    player.setFirstname(element.get("player").get("firstname").asText());
                    player.setLastname(element.get("player").get("lastname").asText());
                    player.setAge(element.get("player").get("age").asInt());
                    player.setDob(element.get("player").get("birth").get("date").asText());
                    player.setPlaceOfBirth(element.get("player").get("birth").get("place").asText());
                    player.setNationality(element.get("player").get("nationality").asText());
                    player.setHeight(element.get("player").get("height").asText());
                    player.setWeight(element.get("player").get("weight").asText());
                    player.setInjured(element.get("player").get("injured").asBoolean());
                    player.setPhoto(element.get("player").get("photo").asText());

                    JsonNode statistics = element.get("statistics");
                    JsonNode statistic = statistics.get(0);

                    player.setPlayerStats(new PlayerStat(
                                    new PlayerStat.Team(
                                            getJsonValueAsInt(statistic.get("team"), "id"),
                                            getJsonValueAsString(statistic.get("team"), "name"),
                                            getJsonValueAsString(statistic.get("team"), "logo")
                                    ),
                                    new PlayerStat.League(
                                            getJsonValueAsInt(statistic.get("league"), "id"),
                                            getJsonValueAsString(statistic.get("league"), "name"),
                                            getJsonValueAsString(statistic.get("league"), "country"),
                                            getJsonValueAsString(statistic.get("league"), "logo"),
                                            getJsonValueAsString(statistic.get("league"), "flag"),
                                            getJsonValueAsInt(statistic.get("league"), "season")
                                    ),
                                    new PlayerStat.Games(
                                            getJsonValueAsInt(statistic.get("games"), "appearences"),
                                            getJsonValueAsInt(statistic.get("games"), "lineups"),
                                            getJsonValueAsInt(statistic.get("games"), "minutes"),
                                            getJsonValueAsString(statistic.get("games"), "number"),
                                            getJsonValueAsString(statistic.get("games"), "position"),
                                            statistic.get("games").get("captain").asBoolean()
                                    ),
                                    new PlayerStat.Substitutes(
                                            getJsonValueAsInt(statistic.get("substitutes"), "in"),
                                            getJsonValueAsInt(statistic.get("substitutes"), "out"),
                                            getJsonValueAsInt(statistic.get("substitutes"), "bench")
                                    ),
                                    new PlayerStat.Shots(
                                            getJsonValueAsInt(statistic.get("shots"), "total"),
                                            getJsonValueAsInt(statistic.get("shots"), "on")
                                    ),
                                    new PlayerStat.Goals(
                                            getJsonValueAsInt(statistic.get("goals"), "total"),
                                            getJsonValueAsInt(statistic.get("goals"), "conceded"),
                                            getJsonValueAsInt(statistic.get("goals"), "assists"),
                                            getJsonValueAsInt(statistic.get("goals"), "saves")
                                    ),
                                    new PlayerStat.Passes(
                                            getJsonValueAsInt(statistic.get("passes"), "total"),
                                            getJsonValueAsInt(statistic.get("passes"), "key"),
                                            getJsonValueAsInt(statistic.get("passes"), "accuracy")
                                    ),
                                    new PlayerStat.Tackles(
                                            getJsonValueAsInt(statistic.get("tackles"), "total"),
                                            getJsonValueAsInt(statistic.get("tackles"), "blocks"),
                                            getJsonValueAsInt(statistic.get("tackles"), "interceptions")
                                    ),
                                    new PlayerStat.Duels(
                                            getJsonValueAsInt(statistic.get("duels"), "total"),
                                            getJsonValueAsInt(statistic.get("duels"), "won")
                                    ),
                                    new PlayerStat.Dribbles(
                                            getJsonValueAsInt(statistic.get("dribbles"), "attempts"),
                                            getJsonValueAsInt(statistic.get("dribbles"), "success"),
                                            getJsonValueAsInt(statistic.get("dribbles"), "past")
                                    ),
                                    new PlayerStat.Fouls(
                                            getJsonValueAsInt(statistic.get("fouls"), "drawn"),
                                            getJsonValueAsInt(statistic.get("fouls"), "committed")
                                    ),
                                    new PlayerStat.Cards(
                                            getJsonValueAsInt(statistic.get("cards"), "yellow"),
                                            getJsonValueAsInt(statistic.get("cards"), "yellowred"),
                                            getJsonValueAsInt(statistic.get("cards"), "red")
                                    ),
                                    new PlayerStat.Penalty(
                                            getJsonValueAsInt(statistic.get("penalty"), "won"),
                                            getJsonValueAsInt(statistic.get("penalty"), "committed"),
                                            getJsonValueAsInt(statistic.get("penalty"), "scored"),
                                            getJsonValueAsInt(statistic.get("penalty"), "missed"),
                                            getJsonValueAsInt(statistic.get("penalty"), "saved")
                                    )
                            ));




                }
            } catch (Exception e) {
                e.printStackTrace();
            }


        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }



        return player;
    }


    private int getJsonValueAsInt(JsonNode node, String fieldName) {
        JsonNode fieldNode = node.get(fieldName);
        return (fieldNode != null) ? fieldNode.asInt() : 0;
    }

    private String getJsonValueAsString(JsonNode node, String fieldName) {
        JsonNode fieldNode = node.get(fieldName);
        return (fieldNode != null) ? fieldNode.asText() : "0";
    }



}


