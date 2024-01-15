package com.example.demo.requesting;

import com.example.demo.models.League;
import com.example.demo.models.Team;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class Requester {
    public static void main(String[] args) throws IOException, InterruptedException {
       Requester requester = new Requester();
       //System.out.println(requester.requestLeagues("England"));
        System.out.println(requester.requestTeams("England",39));


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
                    if (element.get("league").get("type").asText().equals("League")){
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
                        if (element.get("league").get("type").asText().equals("League")){
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
                    .uri(URI.create("https://api-football-v1.p.rapidapi.com/v3/teams?league=" + leagueID + "&season=2023&country=" + country))
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

}


