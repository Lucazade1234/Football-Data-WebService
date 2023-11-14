package com.example.demo.requesting;

import com.example.demo.models.League;
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
    public static void main(String[] args) throws IOException {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api-football-v1.p.rapidapi.com/v3/leagues?country=England"))
                    .header("X-RapidAPI-Key", "beb2d7eac8msh58aa520e5aa67c7p187818jsndadd4a0969ce")
                    .header("X-RapidAPI-Host", "api-football-v1.p.rapidapi.com")
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());

            processJsonResponse(response.body());

            } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

    }



    private static void processJsonResponse(String jsonResponse) {
        try {
            // Parse the JSON response
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonObject = objectMapper.readTree(jsonResponse);

            JsonNode jsonArray = jsonObject.get("response");
            System.out.println(jsonArray);

            //System.out.println(jsonObject);
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

}


