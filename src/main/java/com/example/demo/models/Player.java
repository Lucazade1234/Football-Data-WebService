package com.example.demo.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Data
@Document(collection = "Players")
public class Player {
    @Id
    private String id;
    private int playerID;
    private String firstname;
    private String lastname;
    private int age;
    private String dob;
    private String placeOfBirth;
    private String nationality;
    private String height;
    private String weight;
    private boolean injured;
    private String photo;
    private PlayerStat playerStats;

    public Player() {
    }

    public Player(String id,
                  int playerID,
                  String firstname,
                  String lastname,
                  int age,
                  String dob,
                  String placeOfBirth,
                  String nationality,
                  String height,
                  String weight,
                  boolean injured,
                  String photo,
                  PlayerStat playerStats) {

        this.id = id;
        this.playerID = playerID;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.dob = dob;
        this.placeOfBirth = placeOfBirth;
        this.nationality = nationality;
        this.height = height;
        this.weight = weight;
        this.injured = injured;
        this.photo = photo;
        this.playerStats = playerStats;
    }

}